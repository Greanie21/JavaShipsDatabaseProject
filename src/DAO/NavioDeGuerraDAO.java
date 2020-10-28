/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.NavioDeGuerraVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abol9
 */
public class NavioDeGuerraDAO {

    private ArrayList columns = new ArrayList();
    MysqlFactory factory = new MysqlFactory();

    public NavioDeGuerraDAO() {
        columns.add("idNavioDeGuerra");
        columns.add("blindagem");
        columns.add("ataque");
    }

    public int Inserir(NavioDeGuerraVO nGuerra) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(nGuerra.getBlindagem());
        dados.add(nGuerra.getAtaque());

        return factory.inserir("navioDeGuerra", columns, dados);
    }

    public int Inserir(NavioDeGuerraVO nGuerra, String childColumn) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(nGuerra.getBlindagem());
        dados.add(nGuerra.getAtaque());
        String childName;
        if ("idNavioCruzador".equals(childColumn)) {
            childName = "cruzador";
        } else {
            childName = "portaAvioes";
        }
        int childId = factory.nextId(childName);
        //remove 1 because the child has already been created
        childId -= 1;
        dados.add(childId);

        columns.add(childColumn);

        int myInsert = factory.inserir("navioDeGuerra", columns, dados);
        return myInsert;
    }

    public ResultSet Read(int id) throws SQLException {
        ArrayList tableName = new ArrayList();

        tableName.add("navio");
        tableName.add("navioDeGuerra");

        ArrayList[] columnsArray = new ArrayList[2];
        ArrayList a = new ArrayList();
        a.add("id");
        a.add("nome");
        a.add("tripulantes");
        columnsArray[0] = a;
        columnsArray[1] = columns;

        ArrayList nameColumnToJoin = new ArrayList();
        nameColumnToJoin.add("idNavioDeGuerra");

        return factory.readJoin(tableName, columnsArray, nameColumnToJoin, id);
    }

    public ResultSet Read() throws SQLException {
        ArrayList tableName = new ArrayList();

        tableName.add("navio");
        tableName.add("navioDeGuerra");

        ArrayList[] columnsArray = new ArrayList[2];
        ArrayList a = new ArrayList();
        a.add("id");
        a.add("nome");
        a.add("tripulantes");
        columnsArray[0] = a;
        columnsArray[1] = columns;

        ArrayList nameColumnToJoin = new ArrayList();
        nameColumnToJoin.add("idNavioDeGuerra");

        return factory.readJoin(tableName, columnsArray, nameColumnToJoin);
    }

    public int Edit(NavioDeGuerraVO nGuerra, int idBase) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(nGuerra.getBlindagem());
        dados.add(nGuerra.getAtaque());

        ResultSet rs = Read(idBase);
        if (rs.next() == false) {
            return -1;
        }
        int realID = rs.getInt(columns.get(0).toString());

        return factory.Edit("navioDeGuerra", columns, dados, realID);
    }

    public int Delete(ResultSet rs) throws SQLException {
        int realID = rs.getInt(columns.get(0).toString());

        int delete = factory.Delete("navioDeGuerra", columns, realID);
        return delete;
    }

}
