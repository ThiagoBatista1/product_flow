package writer;

import mapper.ColumnIndexMapper;
import model.Product;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TemplateWriter {

    public void escreverProduto(List<Product> produtos, String caminhoTemplate, String caminhoSaida) throws IOException {

        try (FileInputStream fis = new FileInputStream(caminhoTemplate);
             Workbook workbook = WorkbookFactory.create(fis)) {

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

                try (FileOutputStream fos = new FileOutputStream(caminhoSaida)){
                    workbook.write(fos);
                }
            }
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
