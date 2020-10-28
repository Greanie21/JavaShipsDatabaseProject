/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.NavioVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abol9
 */
public class NavioDAO {

    private ArrayList columns = new ArrayList();
    MysqlFactory factory = new MysqlFactory();

    public NavioDAO() {
        columns.add("id");
        columns.add("nome");
        columns.add("tripulantes");
    }

    public int Inserir(NavioVO navio) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(navio.getNome());
        dados.add(navio.getTripulantes());

        return factory.inserir("navioDeGuerra", columns, dados);
    }

    public int Inserir(NavioVO navio, String childColumn) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(navio.getNome());
        dados.add(navio.getTripulantes());
        String childName;
        if ("idNavioDeGuerra".equals(childColumn)) {
            childName = "navioDeGuerra";
        } else {
            childName = "navioMercante";
        }
        int childId = factory.nextId(childName);
        //remove 1 because the child has already been created
        childId -= 1;
        dados.add(childId);

        columns.add(childColumn);

        return factory.inserir("navio", columns, dados);
    }

    public ResultSet Read() throws SQLException {
        return factory.Read(columns, "navio");
    }

    public ResultSet Read(int id) throws SQLException {
        return factory.Read(columns, "navio", id);
    }

    public int Edit(NavioVO navio, int id) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(navio.getNome());
        dados.add(navio.getTripulantes());

        return factory.Edit("navio", columns, dados, id);
    }

    public int Delete(int id) throws SQLException {
        return factory.Delete("navio", columns, id);
    }
}
