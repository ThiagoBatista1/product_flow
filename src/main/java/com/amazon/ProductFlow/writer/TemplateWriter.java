package com.amazon.ProductFlow.writer;

import com.amazon.ProductFlow.mapper.ColumnIndexMapper;
import com.amazon.ProductFlow.model.Product;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.List;
import java.util.Map;

public class TemplateWriter {

    public void escreverProduto(List<Product> produtos, InputStream templateInputStream, OutputStream outputStream) throws IOException {

        try (Workbook workbook = WorkbookFactory.create(templateInputStream)) {

            Sheet aba = workbook.getSheetAt(0);

            Row linhaCabecalho = aba.getRow(2);
            ColumnIndexMapper mapper = new ColumnIndexMapper();
            Map<String, List<Integer>> indiceColunas = mapper.mapear(linhaCabecalho);

            for(int i = 0; i < produtos.size(); i++){
                Product produto = produtos.get(i);
                int numeroLinha = 6 + i;

                Row linha = aba.getRow(numeroLinha);
                if (linha == null){
                    linha = aba.createRow(numeroLinha);
                }

//                System.out.println("Linha " + numeroLinha + ": " + produto);
//                System.out.println(new File(caminhoSaida).getAbsolutePath());

                setValorCelula(linha, indiceColunas, "Nome do Produto", 0, produto.getNome());
                setValorCelula(linha, indiceColunas, "Código do fornecedor", 0, produto.getCodigoFornecedor());
                setValorCelula(linha, indiceColunas, "SKU do fornecedor", 0, produto.getSkuFornecedor());
                setValorCelula(linha, indiceColunas, "Tipo de produto", 0, produto.getTipoProduto());
                setValorCelula(linha, indiceColunas, "Destaque do Produto", 0, produto.getDestaqueProduto());
                setValorCelula(linha, indiceColunas, "Nome da marca", 0, produto.getNomeMarca());
                setValorCelula(linha, indiceColunas, "Tipo de ID externo do produto", 0, produto.getTipoIdExterno());
                setValorCelula(linha, indiceColunas, "ID externo do produto", 0, produto.getIdExterno());
                setValorCelula(linha, indiceColunas, "Categoria do produto", 0, produto.getCategoria());
                setValorCelula(linha, indiceColunas, "Subcategoria do produto", 0, produto.getSubCategoria());
                setValorCelula(linha, indiceColunas, "Caminhos de Navegação Recomendados", 0, produto.getCaminhoRecomendado1());
                setValorCelula(linha, indiceColunas, "Caminhos de Navegação Recomendados", 1, produto.getCaminhoRecomendado2());
                setValorCelula(linha, indiceColunas, "Nível de pacote", 0, produto.getNivelPacote());
                setValorCelula(linha, indiceColunas, "Número do modelo", 0, produto.getNumModelo());
                setValorCelula(linha, indiceColunas, "Nome do modelo", 0, produto.getNomeModelo());
                setValorCelula(linha, indiceColunas, "Fabricante", 0, produto.getFabricante());
                setValorCelula(linha, indiceColunas, "Tópico", 0, produto.getTopico1());
                setValorCelula(linha, indiceColunas, "Tópico", 1, produto.getTopico2());
                setValorCelula(linha, indiceColunas, "Tópico", 2, produto.getTopico3());
                setValorCelula(linha, indiceColunas, "Tópico", 3, produto.getTopico4());
                setValorCelula(linha, indiceColunas, "Tópico", 4, produto.getTopico5());
                setValorCelula(linha, indiceColunas, "Palavras-chave de Pesquisa", 0, produto.getPalavrasChave());
                setValorCelula(linha, indiceColunas, "Material", 0, produto.getMaterial());
                setValorCelula(linha, indiceColunas, "Quantidade de itens", 0, produto.getQuantidadeItens());
                setValorCelula(linha, indiceColunas, "Nome do Tipo de Produto", 0, produto.getNomeTipoProduto());
                setValorCelula(linha, indiceColunas, "Descrição do produto", 0, produto.getDescricao());
                setValorCelula(linha, indiceColunas, "Cor", 0, produto.getCor());
                setValorCelula(linha, indiceColunas, "Número da peça", 0, produto.getNumPeca());
                setValorCelula(linha, indiceColunas, "Fonte de energia", 0, produto.getFonteEnergia());
                setValorCelula(linha, indiceColunas, "Preço de custo", 0, produto.getPrecoCusto());
                setValorCelula(linha, indiceColunas, "Código NCM", 0, produto.getCodigoNCM());
                setValorCelula(linha, indiceColunas, "Origem da mercadoria", 0, produto.getOrigemMercadoria());
                setValorCelula(linha, indiceColunas, "Comprimento do pacote", 0, produto.getComprimentoPacote());
                setValorCelula(linha, indiceColunas, "Unidade de comprimento do pacote", 0, produto.getUniComprimentoPacote());
                setValorCelula(linha, indiceColunas, "Largura do pacote", 0, produto.getLarguraPacote());
                setValorCelula(linha, indiceColunas, "Unidade de largura do pacote", 0, produto.getUniLarguraPacote());
                setValorCelula(linha, indiceColunas, "Altura do pacote", 0, produto.getAlturaPacote());
                setValorCelula(linha, indiceColunas, "Unidade de altura do pacote", 0, produto.getUniAlturaPacote());
                setValorCelula(linha, indiceColunas, "Peso do pacote", 0, produto.getPesoPacote());
                setValorCelula(linha, indiceColunas, "Unidade de peso do pacote", 0, produto.getUniPesoPacote());
                setValorCelula(linha, indiceColunas, "Quantidade de itens dentro de cada pacote interno", 0, produto.getQuantItensPacote());
                setValorCelula(linha, indiceColunas, "Número de caixas", 0, produto.getNumCaixas());
                setValorCelula(linha, indiceColunas, "País de origem", 0, produto.getPaisOrigem());
                setValorCelula(linha, indiceColunas, "Baterias são necessárias?", 0, produto.getBaterias());
                setValorCelula(linha, indiceColunas, "Regulamentações de produtos perigosos", 0, produto.getRegProdutosPerigosos());
                setValorCelula(linha, indiceColunas, "Certificação de teste externa", 0, produto.getCertTesteExterna());


            }
            workbook.write(outputStream);
        }
    }
    private void setValorCelula(Row linha, Map<String, List<Integer>> indiceColunas, String nomeColuna, int ocorrencia, String valor){
        List<Integer> posicoes = indiceColunas.get(nomeColuna);
        if (posicoes == null || ocorrencia >= posicoes.size()){
            return;
        }
        int indice = posicoes.get(ocorrencia);
        Cell celula = linha.getCell(indice, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        celula.setCellValue(valor);
    }
}
