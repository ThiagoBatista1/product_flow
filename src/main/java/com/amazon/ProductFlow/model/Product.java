package com.amazon.ProductFlow.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Product {

    private String nome; //Nome do Produto
    private String codigoFornecedor; //Código do fornecedor
    private String skuFornecedor; //SKU do fornecedor
    private String tipoProduto; //Tipo de produto
    private String destaqueProduto; //Destaque do Produto
    private String nomeMarca; //Nome da marca
    private String tipoIdExterno; //Tipo de ID externo do produto
    private String idExterno; //ID externo do produto
    private String categoria; //Categoria do produto
    private String subCategoria; //Subcategoria do produto
    private String caminhoRecomendado1; //Caminhos de Navegação Recomendados
    private String caminhoRecomendado2; //Caminhos de Navegação Recomendados
    private String nivelPacote; //Nível de pacote
    private String numModelo; //Número do modelo
    private String nomeModelo; //Nome do modelo
    private String fabricante; //Fabricante
    private String topico1; //Tópico
    private String topico2; //Tópico
    private String topico3; //Tópico
    private String topico4; //Tópico
    private String topico5; //Tópico
    private String palavrasChave; //Palavras-chave de Pesquisa
    private String material; //Material
    private String quantidadeItens; //Quantidade de itens
    private String nomeTipoProduto; //Nome do Tipo de Produto
    private String descricao; //Descrição do produto
    private String cor; //Cor
    private String numPeca; //Número da peça
    private String fonteEnergia; //Fonte de energia
    private String precoCusto; //Preço de custo
    private String codigoNCM; //Código NCM
    private String origemMercadoria; //Origem da mercadoria
    private String comprimentoPacote; //Comprimento do pacote
    private String uniComprimentoPacote; //Unidade de comprimento do pacote
    private String larguraPacote; //Largura do pacote
    private String uniLarguraPacote; //Unidade de largura do pacote
    private String alturaPacote; //Altura do pacote
    private String uniAlturaPacote; //Unidade de altura do pacote
    private String pesoPacote; //Peso do pacote
    private String uniPesoPacote; //Unidade de peso do pacote
    private String quantItensPacote; //Quantidade de itens dentro de cada pacote interno
    private String numCaixas; //Número de caixas
    private String paisOrigem; //País de origem
    private String baterias; //Baterias são necessárias?
    private String regProdutosPerigosos; //Regulamentações de produtos perigosos
    private String certTesteExterna; //Certificação de teste externa

    public Product(String nome, String codigoFornecedor, String skuFornecedor, String tipoProduto, String destaqueProduto, String nomeMarca, String tipoIdExterno, String idExterno, String categoria, String subCategoria, String caminhoRecomendado1, String caminhoRecomendado2, String nivelPacote, String numModelo, String nomeModelo, String fabricante, String topico1, String topico2, String topico3, String topico4, String topico5, String palavrasChave, String material, String quantidadeItens, String nomeTipoProduto, String descricao, String cor, String numPeca, String fonteEnergia, String precoCusto, String codigoNCM, String origemMercadoria, String comprimentoPacote, String uniComprimentoPacote, String larguraPacote, String uniLarguraPacote, String alturaPacote, String uniAlturaPacote, String pesoPacote, String uniPesoPacote, String quantItensPacote, String numCaixas, String paisOrigem, String baterias, String regProdutosPegrigosos, String certTesteExterna) {
        this.nome = nome;
        this.codigoFornecedor = codigoFornecedor;
        this.skuFornecedor = skuFornecedor;
        this.tipoProduto = tipoProduto;
        this.destaqueProduto = destaqueProduto;
        this.nomeMarca = nomeMarca;
        this.tipoIdExterno = tipoIdExterno;
        this.idExterno = idExterno;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.caminhoRecomendado1 = caminhoRecomendado1;
        this.caminhoRecomendado2 = caminhoRecomendado2;
        this.nivelPacote = nivelPacote;
        this.numModelo = numModelo;
        this.nomeModelo = nomeModelo;
        this.fabricante = fabricante;
        this.topico1 = topico1;
        this.topico2 = topico2;
        this.topico3 = topico3;
        this.topico4 = topico4;
        this.topico5 = topico5;
        this.palavrasChave = palavrasChave;
        this.material = material;
        this.quantidadeItens = quantidadeItens;
        this.nomeTipoProduto = nomeTipoProduto;
        this.descricao = descricao;
        this.cor = cor;
        this.numPeca = numPeca;
        this.fonteEnergia = fonteEnergia;
        this.precoCusto = precoCusto;
        this.codigoNCM = codigoNCM;
        this.origemMercadoria = origemMercadoria;
        this.comprimentoPacote = comprimentoPacote;
        this.uniComprimentoPacote = uniComprimentoPacote;
        this.larguraPacote = larguraPacote;
        this.uniLarguraPacote = uniLarguraPacote;
        this.alturaPacote = alturaPacote;
        this.uniAlturaPacote = uniAlturaPacote;
        this.pesoPacote = pesoPacote;
        this.uniPesoPacote = uniPesoPacote;
        this.quantItensPacote = quantItensPacote;
        this.numCaixas = numCaixas;
        this.paisOrigem = paisOrigem;
        this.baterias = baterias;
        this.regProdutosPerigosos = regProdutosPegrigosos;
        this.certTesteExterna = certTesteExterna;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "nome='" + nome + '\'' +
//                ", codigoFornecedor='" + codigoFornecedor + '\'' +
//                ", skuFornecedor='" + skuFornecedor + '\'' +
//                ", tipoProduto='" + tipoProduto + '\'' +
//                ", destaqueProduto='" + destaqueProduto + '\'' +
//                ", nomeMarca='" + nomeMarca + '\'' +
//                ", tipoIdExterno='" + tipoIdExterno + '\'' +
//                ", idExterno='" + idExterno + '\'' +
//                ", categoria='" + categoria + '\'' +
//                ", subCategoria='" + subCategoria + '\'' +
//                ", caminhoRecomendado1='" + caminhoRecomendado1 + '\'' +
//                ", caminhoRecomendado2='" + caminhoRecomendado2 + '\'' +
//                ", nivelPacote='" + nivelPacote + '\'' +
//                ", numModelo='" + numModelo + '\'' +
//                ", nomeModelo='" + nomeModelo + '\'' +
//                ", fabricante='" + fabricante + '\'' +
//                ", topico1='" + topico1 + '\'' +
//                ", topico2='" + topico2 + '\'' +
//                ", topico3='" + topico3 + '\'' +
//                ", topico4='" + topico4 + '\'' +
//                ", topico5='" + topico5 + '\'' +
//                ", palavrasChave='" + palavrasChave + '\'' +
//                ", material='" + material + '\'' +
//                ", quantidadeItens='" + quantidadeItens + '\'' +
//                ", nomeTipoProduto='" + nomeTipoProduto + '\'' +
//                ", descricao='" + descricao + '\'' +
//                ", cor='" + cor + '\'' +
//                ", numPeca='" + numPeca + '\'' +
//                ", fonteEnergia='" + fonteEnergia + '\'' +
//                ", precoCusto='" + precoCusto + '\'' +
//                ", codigoNCM='" + codigoNCM + '\'' +
//                ", origemMercadoria='" + origemMercadoria + '\'' +
//                ", comprimentoPacote='" + comprimentoPacote + '\'' +
//                ", uniComprimentoPacote='" + uniComprimentoPacote + '\'' +
//                ", larguraPacote='" + larguraPacote + '\'' +
//                ", uniLarguraPacote='" + uniLarguraPacote + '\'' +
//                ", alturaPacote='" + alturaPacote + '\'' +
//                ", uniAlturaPacote='" + uniAlturaPacote + '\'' +
//                ", pesoPacote='" + pesoPacote + '\'' +
//                ", uniPesoPacote='" + uniPesoPacote + '\'' +
//                ", quantItensPacote='" + quantItensPacote + '\'' +
//                ", numCaixas='" + numCaixas + '\'' +
//                ", paisOrigem='" + paisOrigem + '\'' +
//                ", baterias='" + baterias + '\'' +
//                ", RegProdutosPegrigosos='" + regProdutosPerigosos + '\'' +
//                ", CertTesteExterna='" + certTesteExterna + '\'' +
//                '}';
//    }
}
