package subte.datos.dao.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import subte.datos.dao.TramoDAO;
import subte.datos.dto.TramoDTO;
import subte.datos.ConexionBD;

public class TramoDaoBd implements TramoDAO {

    @Override
    public List<TramoDTO> obtenerTodos() throws Exception {
        List<TramoDTO> lista = new ArrayList<>();
        String sql = "SELECT codigo_estacion1, codigo_estacion2, tiempo, congestion FROM tramos"; 

        Connection con = ConexionBD.obtenerConexion(); // Mantenemos la conexión abierta
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                lista.add(0, new TramoDTO(
                    rs.getString("codigo_estacion1").trim(),
                    rs.getString("codigo_estacion2").trim(),
                    rs.getInt("tiempo"),
                    rs.getInt("congestion")
                ));
            }
        }
        return lista;
    }
}


