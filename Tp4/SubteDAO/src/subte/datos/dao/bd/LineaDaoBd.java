package subte.datos.dao.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import subte.datos.dao.LineaDAO;
import subte.datos.dto.LineaDTO;
import subte.datos.ConexionBD;

public class LineaDaoBd implements LineaDAO {

    @Override
    public List<LineaDTO> obtenerTodas() throws Exception {
        List<LineaDTO> lista = new ArrayList<>();
        String sql = "SELECT codigo, nombre FROM lineas"; 

        Connection con = ConexionBD.obtenerConexion(); // NO la metas en el try() para que no se cierre
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                lista.add(new LineaDTO(
                    rs.getString("codigo").trim(),
                    rs.getString("nombre").trim()
                ));
            }
        }
        return lista;
    }
}
