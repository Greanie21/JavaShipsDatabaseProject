/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAL;

import DAO.NavioDAO;
import DAO.NavioDeGuerraDAO;
import DAO.PortaAvioesDAO;
import VO.PortaAvioesVO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abol9
 */
public class PortaAvioesBAL {

    public int Insert(PortaAvioesVO pAvioesVO) throws SQLException {
        //todo regras
        PortaAvioesDAO pAvioesDAO = new PortaAvioesDAO();
        return pAvioesDAO.Insert(pAvioesVO);
    }

    public ResultSet Read() throws SQLException {
        //todo regras
        PortaAvioesDAO pAvioesDAO = new PortaAvioesDAO();
        return pAvioesDAO.Read();
    }

    public ResultSet Read(int id) throws SQLException {
        //todo regras
        PortaAvioesDAO pAvioesDAO = new PortaAvioesDAO();
        return pAvioesDAO.Read(id);
    }

    public int Edit(PortaAvioesVO portaAvioes, int id) throws SQLException {
        //todo regras
        PortaAvioesDAO portaAvioesDAO = new PortaAvioesDAO();
        int i1 = portaAvioesDAO.Edit(portaAvioes, id);
        return i1;
    }

    public int Delete(ResultSet rs) throws SQLException {
        PortaAvioesDAO pAvioesDAO = new PortaAvioesDAO();
        int d = pAvioesDAO.Delete(rs);
        return d;
    }
}
