package BAL;

import DAO.NavioMercanteDAO;
import VO.NavioMercanteVO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NavioMercanteBAL {

    public int Inserir(NavioMercanteVO nmVO) throws Exception {
        CheckInsertRules(nmVO);

        NavioMercanteDAO nMercDAO = new NavioMercanteDAO();
        return nMercDAO.Inserir(nmVO);
    }

    public ResultSet Read(int id) throws SQLException {
        NavioMercanteDAO nMercDAO = new NavioMercanteDAO();
        return nMercDAO.Read(id);
    }

    public ResultSet Read() throws SQLException {
        NavioMercanteDAO nMercDAO = new NavioMercanteDAO();
        return nMercDAO.Read();
    }

    public int Edit(NavioMercanteVO nmVO, int id) throws Exception {
        CheckInsertRules(nmVO);

        NavioMercanteDAO nMercDAO = new NavioMercanteDAO();
        return nMercDAO.Edit(nmVO, id);
    }
    
    public int Delete(ResultSet rs) throws SQLException, Exception
    {        
        NavioMercanteDAO nMercDAO = new NavioMercanteDAO();
        return nMercDAO.Delete(rs);
    }

    void CheckInsertRules(NavioMercanteVO nmVO) throws Exception {
        if (nmVO == null) {
            throw new Exception("Navio mercante esta nulo");
        }

        if (nmVO.getCarga() > nmVO.getCapacidadeDeCarga()) {
            throw new Exception("Navio esta sobrecarregado");
        }
        //TODO criar mais regras de negocio
    }
}
