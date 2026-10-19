package subte.datos.dao.bd;

import subte.datos.dao.DAOFactory;
import subte.datos.dao.EstacionDAO;
import subte.datos.dao.LineaDAO;
import subte.datos.dao.TramoDAO;

public class BdDAOFactory implements DAOFactory {

    @Override
    public LineaDAO getLineaDAO() {
        return new LineaDaoBd();
    }

    @Override
    public EstacionDAO getEstacionDAO() {
        return new EstacionDaoBd();
    }

    @Override
    public TramoDAO getTramoDAO() {
        return new TramoDaoBd();
    }
}
