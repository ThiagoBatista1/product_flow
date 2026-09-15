function configurarCampo(inputId){
    const inputOrigem = document.getElementById(inputId);
    const campoCard = inputOrigem.closest('.campo-card');
    const titulo = campoCard.querySelector('.card-titulo');
    const subtitulo = campoCard.querySelector('.card-subtitulo');
    const campo = inputOrigem.closest('.campo');
    const tag = campo.querySelector('.campo-tag');

    const tituloOriginal = titulo.textContent;
    const subtituloOriginal = subtitulo.textContent;

    function processarArquivo(arquivo){
        const nomeValido = arquivo.name.endsWith('.xlsx') || arquivo.name.endsWith('.xls');

        if (nomeValido){
            titulo.textContent = arquivo.name;
            campoCard.classList.add('preenchido');
            campoCard.classList.remove('erro');
            tag.classList.remove('erro');
        } else {
            titulo.textContent = 'Erro de importação';
            subtitulo.textContent = 'O formato selecionado não é compatível';
            campoCard.classList.add('erro');
            campoCard.classList.remove('preenchido');
            tag.classList.add('erro');
        }

        verificarFormulario();
    }
    function resetarCampo() {
        inputOrigem.value = '';
        titulo.textContent = tituloOriginal;
        subtitulo.textContent = subtituloOriginal;
        campoCard.classList.remove('preenchido','erro', 'desabilitado');
        tag.classList.remove('erro')
    }
    inputOrigem.addEventListener('change', function (){
        const arquivo = inputOrigem.files[0];
        processarArquivo(arquivo);
    })
    campoCard.addEventListener('dragover', function (event){
        event.preventDefault();
        campoCard.classList.add('arrastando');
    })
    campoCard.addEventListener('dragleave', function (){
        campoCard.classList.remove('arrastando');
    })
    campoCard.addEventListener('drop', function (event){
        event.preventDefault();
        campoCard.classList.remove('arrastando');

        const arquivo = event.dataTransfer.files[0];
        inputOrigem.files = event.dataTransfer.files;

        processarArquivo(arquivo);
    })
    return resetarCampo;
}

verificarFormulario();

function verificarFormulario (){
    const campos = document.querySelectorAll('.campo-card');
    const botao = document.querySelector('.botao-gerar');

    const todosPreenchidos = Array.from(campos).every(function (campo){
        return campo.classList.contains('preenchido');
    })

    botao.disabled = !todosPreenchidos;
}

const botaoGerar = document.querySelector('.botao-gerar');
const textoBotaoGerar = botaoGerar.querySelector('.texto-botao');
const textoOriginalBotao = textoBotaoGerar.textContent;

botaoGerar.addEventListener('click', function (){
    iniciarProcessamento();
    enviarPlanilha();
})

function iniciarProcessamento(){
    botaoGerar.classList.add('processando');
    botaoGerar.disabled = true;
    textoBotaoGerar.textContent = 'Processando';

    const iconeLoading = botaoGerar.querySelector('.icone-loading')
    iconeLoading.hidden = false;

    const campos = document.querySelectorAll('.campo-card');
    campos.forEach(function (campo){
        campo.classList.add('desabilitado');
    })
}

function montarFormData(){
    const formData = new FormData();

    const inputOrigem = document.getElementById('input-origem');
    const inputTemplate = document.getElementById('input-template');

    formData.append('planilhaOrigem', inputOrigem.files[0]);
    formData.append('planilhaTemplate', inputTemplate.files[0]);

    return formData;
}
async function enviarPlanilha(){
    const formData = montarFormData();

    try {
        const resposta = await fetch('/processar-planilha',{
            method:'POST',
            body: formData
        })
        if (resposta.ok){
            const blob = await resposta.blob();
            mostrarSucesso(blob);
        } else {
            mostrarErro();
        }
    }catch (erro) {
        mostrarErro()
    }
}

let arquivoGerado = null;

const tituloResultado = document.querySelector('.titulo-resultado');

function mostrarSucesso(blob){
    arquivoGerado = blob;

    const planilhaForm = document.querySelector('.planilha-form');
    const resultado = document.querySelector('.resultado');
    const cardResultado = document.querySelector('.card-resultado');
    const botaoBaixar = document.querySelector('.botao-baixar');

    planilhaForm.hidden = true;
    resultado.hidden = false;

    tituloResultado.textContent = 'Planilha gerada com sucesso!';
    cardResultado.hidden = false;
    botaoBaixar.hidden = false;
}
function mostrarErro(){
    const planilhaForm = document.querySelector('.planilha-form');
    const resultado = document.querySelector('.resultado');
    const cardResultado = document.querySelector('.card-resultado');
    const botaoBaixar = document.querySelector('.botao-baixar');

    planilhaForm.hidden = true;
    resultado.hidden = false;

    tituloResultado.textContent = 'Erro ao gerar a planilha. Tente novamente.';
    cardResultado.hidden = true;
    botaoBaixar.hidden = true;
}
function resetarFormulario() {
    resetarCampoOrigem()
    resetarCampoTemplate()

    botaoGerar.classList.remove('processando');
    textoBotaoGerar.textContent = textoOriginalBotao;
    const iconeLoading = botaoGerar.querySelector('.icone-loading');
    iconeLoading.hidden = true;

    const planilhaForm = document.querySelector('.planilha-form');
    const resultado = document.querySelector('.resultado');
    planilhaForm.hidden = false;
    resultado.hidden = true;

    arquivoGerado = null;

    verificarFormulario()
}

const resetarCampoOrigem = configurarCampo('input-origem');
const resetarCampoTemplate = configurarCampo('input-template');

const botaoBaixar = document.querySelector('.botao-baixar')

botaoBaixar.addEventListener('click', function () {
    const url = URL.createObjectURL(arquivoGerado);

    const link = document.createElement('a')
    link.href = url;
    link.download = 'planilha_preenchida.xlsx';

    link.click();

    URL.revokeObjectURL(url);
})

const botaoVoltar = document.querySelector('.botao-voltar');
botaoVoltar.addEventListener('click', resetarFormulario);




