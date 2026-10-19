package subte.datos.dao.txt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import subte.datos.dao.EstacionDAO;
import subte.datos.dto.EstacionDTO;

public class EstacionDaoTxt implements EstacionDAO {
    private String rutaArchivo;

    public EstacionDaoTxt(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public List<EstacionDTO> obtenerTodas() throws Exception {
        List<EstacionDTO> lista = new ArrayList<>();
        try (Scanner read = new Scanner(new File(rutaArchivo))) {
            while (read.hasNextLine()) {
                String lineaTexto = read.nextLine().trim();
                if (lineaTexto.isEmpty()) continue;
                String[] campos = lineaTexto.split(";");
                if (campos.length >= 3) {
                    lista.add(new EstacionDTO(
                        campos[0].trim(), 
                        campos[1].trim(), 
                        campos[2].trim()
                    ));
                }
            }
        }
        return lista;
    }
}
