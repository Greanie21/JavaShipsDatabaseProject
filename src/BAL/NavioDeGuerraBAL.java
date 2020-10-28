/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAL;

import DAO.NavioDeGuerraDAO;
import VO.NavioDeGuerraVO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abol9
 */
public class NavioDeGuerraBAL {

    /**
     * insert childless navio de guerra
     *
     * @param navio
     * @return
     * @throws Exception
     */
    public int Insert(NavioDeGuerraVO navioDeGuerra) throws Exception {
        CheckInsertRules(navioDeGuerra);
        NavioDeGuerraDAO navioDeGuerraDAO = new NavioDeGuerraDAO();
        return navioDeGuerraDAO.Inserir(navioDeGuerra);
    }

    /**
     * insert navio de guerra with child
     *
     * @param navio
     * @param childId
     * @param childColumn
     * @return
     * @throws Exception
     */
    public int Insert(NavioDeGuerraVO navioDeGuerra, String childColumn) throws Exception {
        CheckInsertRules(navioDeGuerra);
        NavioDeGuerraDAO navioDeGuerraDAO = new NavioDeGuerraDAO();
        return navioDeGuerraDAO.Inserir(navioDeGuerra, childColumn);
    }

    public ResultSet Read(int id) throws SQLException, Exception {
        CheckIdRules(id);
        NavioDeGuerraDAO navioDeGuerraDAO = new NavioDeGuerraDAO();
        return navioDeGuerraDAO.Read(id);
    }

    public ResultSet Read() throws SQLException {
        NavioDeGuerraDAO navioDeGuerraDAO = new NavioDeGuerraDAO();
        return navioDeGuerraDAO.Read();
    }

    public int Edit(NavioDeGuerraVO navioDeGuerra, int id) throws SQLException, Exception {
        CheckInsertRules(navioDeGuerra);
        NavioDeGuerraDAO navioDeGuerraDAO = new NavioDeGuerraDAO();
        return navioDeGuerraDAO.Edit(navioDeGuerra, id);
    }

    public int Delete(ResultSet rs) throws SQLException, Exception {
        //CheckIdRules(id);

        NavioDeGuerraDAO navioDeGuerraDAO = new NavioDeGuerraDAO();
        return navioDeGuerraDAO.Delete(rs);
    }

    void CheckInsertRules(NavioDeGuerraVO navioDeGuerra) throws Exception {
        if (navioDeGuerra == null) {
            throw new Exception("Navio de Guerra esta nulo");
        }
        //TODO criar mais regras de negocio
    }
    
    void CheckIdRules(int id) throws Exception
    {
        if (id<0)
        {
            throw new Exception("id menor que 0");            
        }
    }
}
