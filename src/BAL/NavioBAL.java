/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAL;

import DAO.NavioDAO;
import VO.NavioVO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abol9
 */
public class NavioBAL {

    /**
     * insert childless navio
     *
     * @param navio
     * @return
     * @throws Exception
     */
    public int Insert(NavioVO navio) throws Exception {
        CheckInsertRules(navio);
        NavioDAO navioDAO = new NavioDAO();
        return navioDAO.Inserir(navio);
    }

    /**
     * insert navio with child
     *
     * @param navio
     * @param childColumn
     * @return
     * @throws Exception
     */
    public int Insert(NavioVO navio, String childColumn) throws Exception {
        CheckInsertRules(navio);
        NavioDAO navioDAO = new NavioDAO();
        return navioDAO.Inserir(navio, childColumn);
    }

    void CheckInsertRules(NavioVO navio) throws Exception {
        if (navio == null) {
            throw new Exception("Esse navio esta nulo");
        }
        //TODO criar mais regras de negocio
    }

    public ResultSet Read() throws SQLException {
        NavioDAO navioDAO = new NavioDAO();
        return navioDAO.Read();
    }

    public ResultSet Read(int id) throws SQLException {
        NavioDAO navioDAO = new NavioDAO();
        return navioDAO.Read(id);
    }

    public int Edit(NavioVO navio, int id) throws Exception {
        CheckInsertRules(navio);
        NavioDAO navioDAO = new NavioDAO();
        return navioDAO.Edit(navio, id);
    }

    public int Delete(int id) throws SQLException {
        NavioDAO nav = new NavioDAO();
        int i = nav.Delete(id);
        return i;
    }
}
