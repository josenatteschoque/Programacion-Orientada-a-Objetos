package subte.datos.dao.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import subte.datos.dao.EstacionDAO;
import subte.datos.dto.EstacionDTO;
import subte.datos.ConexionBD;

public class EstacionDaoBd implements EstacionDAO {

    @Override
    public List<EstacionDTO> obtenerTodas() throws Exception {
        List<EstacionDTO> lista = new ArrayList<>();
        String sql = "SELECT codigo, nombre, codigo_linea FROM estaciones"; 

        Connection con = ConexionBD.obtenerConexion(); // Mantenemos la conexión abierta
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                lista.add(new EstacionDTO(
                    rs.getString("codigo").trim(),
                    rs.getString("nombre").trim(),
                    rs.getString("codigo_linea").trim()
                ));
            }
        }
        return lista;
    }
}
