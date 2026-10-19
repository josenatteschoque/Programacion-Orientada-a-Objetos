package subte.datos.dao.txt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import subte.datos.dao.LineaDAO;
import subte.datos.dto.LineaDTO;

public class LineaDaoTxt implements LineaDAO {
    private String rutaArchivo;

    public LineaDaoTxt(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public List<LineaDTO> obtenerTodas() throws Exception {
        List<LineaDTO> lista = new ArrayList<>();
        try (Scanner read = new Scanner(new File(rutaArchivo))) {
            while (read.hasNextLine()) {
                String lineaTexto = read.nextLine().trim();
                
                // Ignorar líneas vacías por seguridad
                if (lineaTexto.isEmpty()) continue;
                
                String[] campos = lineaTexto.split(";");
                if (campos.length >= 2) {
                    String codigo = campos[0].trim();
                    String nombre = campos[1].trim();
                    
                    lista.add(new LineaDTO(codigo, nombre));
                }
            }
        }
        return lista;
    }
}
