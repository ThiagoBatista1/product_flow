package mapper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnIndexMapper {

    public Map<String, List<Integer>> mapear(Row linhaCabecalho){
        Map<String, List<Integer>> indiceColunas = new HashMap<>();

        for (Cell celula : linhaCabecalho) {
            String nomeColuna = celula.getStringCellValue().trim();
            int indice = celula.getColumnIndex();
            indiceColunas.computeIfAbsent(nomeColuna, k -> new ArrayList<>()).add(indice);
        }
        return indiceColunas;
    }
}
