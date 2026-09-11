package com.amazon.ProductFlow.reader;

import com.amazon.ProductFlow.mapper.ColumnIndexMapper;
import com.amazon.ProductFlow.model.Product;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ProductReader {

    private final DataFormatter formatter = new DataFormatter();

    public List<Product> lerProdutos(InputStream inputStream) throws IOException{
        List<Product> produtos = new ArrayList<>(); // cria uma lista vazia

        try(Workbook workbook = WorkbookFactory.create(inputStream)){

            Sheet aba = workbook.getSheetAt(0);

            Row linhaCabecalho = aba.getRow(2);
            ColumnIndexMapper mapper = new ColumnIndexMapper();
            Map<String, List<Integer>> indiceColunas = mapper.mapear(linhaCabecalho);

            for (int i = 5; i <= aba.getLastRowNum(); i++){
                Row linha = aba.getRow(i);

                //produtos.add(new Product(nome, codigoFornecedor));
                produtos.add(Product.builder()
                        .nome(getValorCelula(linha, indiceColunas, "Nome do Produto",0))
                        .codigoFornecedor(getValorCelula(linha, indiceColunas, "Código do fornecedor",0))
                        .skuFornecedor(getValorCelula(linha, indiceColunas, "SKU do fornecedor",0))
                        .tipoProduto(getValorCelula(linha, indiceColunas, "Tipo de produto",0))
                        .destaqueProduto(getValorCelula(linha, indiceColunas, "Destaque do Produto",0))
                        .nomeMarca(getValorCelula(linha, indiceColunas, "Nome da marca",0))
                        .tipoIdExterno(getValorCelula(linha, indiceColunas, "Tipo de ID externo do produto",0))
                        .idExterno(getValorCelula(linha, indiceColunas, "ID externo do produto",0))
                        .categoria(getValorCelula(linha, indiceColunas, "Categoria do produto",0))
                        .subCategoria(getValorCelula(linha, indiceColunas, "Subcategoria do produto",0))
                        .caminhoRecomendado1(getValorCelula(linha, indiceColunas, "Caminhos de Navegação Recomendados",0))
                        .caminhoRecomendado2(getValorCelula(linha, indiceColunas, "Caminhos de Navegação Recomendados",1))
                        .nivelPacote(getValorCelula(linha, indiceColunas, "Nível de pacote",0))
                        .numModelo(getValorCelula(linha, indiceColunas, "Número do modelo",0))
                        .nomeModelo(getValorCelula(linha, indiceColunas, "Nome do modelo",0))
                        .fabricante(getValorCelula(linha, indiceColunas, "Fabricante",0))
                        .topico1(getValorCelula(linha, indiceColunas, "Tópico",0))
                        .topico2(getValorCelula(linha, indiceColunas, "Tópico",1))
                        .topico3(getValorCelula(linha, indiceColunas, "Tópico",2))
                        .topico4(getValorCelula(linha, indiceColunas, "Tópico",3))
                        .topico5(getValorCelula(linha, indiceColunas, "Tópico",4))
                        .palavrasChave(getValorCelula(linha, indiceColunas, "Palavras-chave de Pesquisa",0))
                        .material(getValorCelula(linha, indiceColunas, "Material",0))
                        .quantidadeItens(getValorCelula(linha, indiceColunas, "Quantidade de itens",0))
                        .nomeTipoProduto(getValorCelula(linha, indiceColunas, "Nome do Tipo de Produto",0))
                        .descricao(getValorCelula(linha, indiceColunas, "Descrição do produto",0))
                        .cor(getValorCelula(linha, indiceColunas, "Cor",0))
                        .numPeca(getValorCelula(linha, indiceColunas, "Número da peça",0))
                        .fonteEnergia(getValorCelula(linha, indiceColunas, "Fonte de energia",0))
                        .precoCusto(getValorCelula(linha, indiceColunas, "Preço de custo",0))
                        .codigoNCM(getValorCelula(linha, indiceColunas, "Código NCM",0))
                        .origemMercadoria(getValorCelula(linha, indiceColunas, "Origem da mercadoria",0))
                        .comprimentoPacote(getValorCelula(linha, indiceColunas, "Comprimento do pacote",0))
                        .uniComprimentoPacote(getValorCelula(linha, indiceColunas, "Unidade de comprimento do pacote",0))
                        .larguraPacote(getValorCelula(linha, indiceColunas, "Largura do pacote",0))
                        .uniLarguraPacote(getValorCelula(linha, indiceColunas, "Unidade de largura do pacote",0))
                        .alturaPacote(getValorCelula(linha, indiceColunas, "Altura do pacote",0))
                        .uniAlturaPacote(getValorCelula(linha, indiceColunas, "Unidade de altura do pacote",0))
                        .pesoPacote(getValorCelula(linha, indiceColunas, "Peso do pacote",0))
                        .uniPesoPacote(getValorCelula(linha, indiceColunas, "Unidade de peso do pacote",0))
                        .quantItensPacote(getValorCelula(linha, indiceColunas, "Quantidade de itens dentro de cada pacote interno",0))
                        .numCaixas(getValorCelula(linha, indiceColunas, "Número de caixas",0))
                        .paisOrigem(getValorCelula(linha, indiceColunas, "País de origem",0))
                        .baterias(getValorCelula(linha, indiceColunas, "Baterias são necessárias?",0))
                        .regProdutosPerigosos(getValorCelula(linha, indiceColunas, "Regulamentações de produtos perigosos",0))
                        .certTesteExterna(getValorCelula(linha, indiceColunas, "Certificação de teste externa",0))
                        .build());
            }
        }
        return produtos;
    }

    private String getValorCelula(Row linha, Map<String, List<Integer>> indiceColunas, String nomeColuna, int ocorrencia){
        List<Integer> posicoes = indiceColunas.get(nomeColuna);
        if (posicoes == null || ocorrencia >= posicoes.size()){
            return "";
        }
        int indice = posicoes.get(ocorrencia);
        Cell celula = linha.getCell(indice);
        if (celula == null){
            return "";
        }
        return formatter.formatCellValue(celula).trim();
    }
}
