package subte.datos.dao.txt;

import subte.datos.dao.DAOFactory;
import subte.datos.dao.EstacionDAO;
import subte.datos.dao.LineaDAO;
import subte.datos.dao.TramoDAO;

public class TxtDAOFactory implements DAOFactory {

    private final String rutaLinea;
    private final String rutaEstacion;
    private final String rutaTramo;

    // MEJORA: Las rutas entran desde afuera, la fábrica ya no depende de CargaParametros
    public TxtDAOFactory(String rutaLinea, String rutaEstacion, String rutaTramo) {
        this.rutaLinea = rutaLinea;
        this.rutaEstacion = rutaEstacion;
        this.rutaTramo = rutaTramo;
    }

    @Override
    public LineaDAO getLineaDAO() {
        return new LineaDaoTxt(this.rutaLinea);
    }

    @Override
    public EstacionDAO getEstacionDAO() {
        return new EstacionDaoTxt(this.rutaEstacion);
    }

    @Override
    public TramoDAO getTramoDAO() {
        return new TramoDaoTxt(this.rutaTramo);
    }
}
