/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAL;

import DAO.CruzadorDAO;
import DAO.NavioDAO;
import DAO.NavioDeGuerraDAO;
import VO.CruzadorVO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abol9
 */
public class CruzadorBAL {

    public int Insert(CruzadorVO cruzador) throws SQLException {
        //todo regras
        CruzadorDAO cruzadorDAO = new CruzadorDAO();
        return cruzadorDAO.Insert(cruzador);
    }

    public ResultSet Read() throws SQLException {
        CruzadorDAO cruzadorDAO = new CruzadorDAO();
        return cruzadorDAO.Read();
    }

    public ResultSet Read(int id) throws SQLException {
        CruzadorDAO cruzadorDAO = new CruzadorDAO();
        return cruzadorDAO.Read(id);
    }

    public int Edit(CruzadorVO cruzador, int id) throws SQLException {
        //todo regras
        CruzadorDAO cruzadorDAO = new CruzadorDAO();
        int i1 = cruzadorDAO.Edit(cruzador, id);
        return i1;
    }

    public int Delete(ResultSet rs) throws SQLException {
//
//        //deletar avo
//        NavioDAO nav = new NavioDAO();
//        int i1 = nav.Delete(id);
//        //deletar pai
//        NavioDeGuerraDAO navG = new NavioDeGuerraDAO();
//        int i2 = navG.Delete(rs);

        CruzadorDAO cruzadorDAO = new CruzadorDAO();
        int d = cruzadorDAO.Delete(rs);
        return d;
    }
}
