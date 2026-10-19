package subte.datos.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import subte.datos.dao.bd.BdDAOFactory;
import subte.datos.dao.txt.TxtDAOFactory;

public class DAOLoader {
    private static DAOFactory instanciaFabrica;

    static {
        try {
            Properties prop = new Properties();
            try (InputStream input = new FileInputStream("config.properties")) {
                prop.load(input);
                String tipoOrigen = prop.getProperty("origen.datos", "TXT").toUpperCase();
                
                if ("BD".equals(tipoOrigen)) {
                    instanciaFabrica = new BdDAOFactory();
                } else {
             
                    String archivoLinea = prop.getProperty("linea", "linea.txt");
                    String archivoEstacion = prop.getProperty("estacion", "estacion.txt");
                    String archivoTramo = prop.getProperty("tramo", "tramo.txt");
                    
                    instanciaFabrica = new TxtDAOFactory(archivoLinea, archivoEstacion, archivoTramo);
                }
            }
        } catch (Exception e) {
            // Fallback seguro por defecto si falla el archivo de configuración
            instanciaFabrica = new TxtDAOFactory("linea.txt", "estacion.txt", "tramo.txt");
        }
    }

    public static DAOFactory getFactory() {
        return instanciaFabrica;
    }
}
