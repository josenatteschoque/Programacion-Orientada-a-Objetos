package subte.datos.dao.txt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import subte.datos.dao.TramoDAO;
import subte.datos.dto.TramoDTO;

public class TramoDaoTxt implements TramoDAO {
    private String rutaArchivo;

    public TramoDaoTxt(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public List<TramoDTO> obtenerTodos() throws Exception {
        List<TramoDTO> lista = new ArrayList<>();
        try (Scanner read = new Scanner(new File(rutaArchivo))) {
            while (read.hasNextLine()) {
                String lineaTexto = read.nextLine().trim();
                
                // Ignorar líneas vacías por seguridad
                if (lineaTexto.isEmpty()) continue;
                
                String[] campos = lineaTexto.split(";");
                if (campos.length >= 4) {
                    String codigoEstacion1 = campos[0].trim();
                    String codigoEstacion2 = campos[1].trim();
                    
                    // Manejo seguro del parseo numérico para evitar caídas imprevistas
                    int tiempo = Integer.parseInt(campos[2].trim());
                    int tipo = Integer.parseInt(campos[3].trim());
                    
                    // Se inserta al inicio (índice 0) respetando el comportamiento de tu código original
                    lista.add(0, new TramoDTO(codigoEstacion1, codigoEstacion2, tiempo, tipo));
                }
            }
        }
        return lista;
    }
}
