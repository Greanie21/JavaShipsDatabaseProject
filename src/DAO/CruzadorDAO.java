/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.CruzadorVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abol9
 */
public class CruzadorDAO {

    private ArrayList columns = new ArrayList();
    MysqlFactory factory = new MysqlFactory();

    public CruzadorDAO() {
        columns.add("idNavioCruzador");
        columns.add("numCanhoes");
    }

    public int Insert(CruzadorVO cruzador) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(cruzador.getNum_canhoes());

        return factory.inserir("cruzador", columns, dados);
    }

    public ResultSet Read() throws SQLException {
        ArrayList tableName = new ArrayList();
        tableName.add("navio");
        tableName.add("navioDeGuerra");
        tableName.add("cruzador");

        ArrayList[] columnsArray = new ArrayList[3];
        ArrayList a = new ArrayList();
        a.add("id");
        a.add("nome");
        a.add("tripulantes");
        columnsArray[0] = a;
        a = new ArrayList();
        a.add("idNavioDeGuerra");
        a.add("blindagem");
        a.add("ataque");
        columnsArray[1] = a;
        columnsArray[2] = columns;

        ArrayList nameColumnToJoin = new ArrayList();
        nameColumnToJoin.add("idNavioDeGuerra");
        nameColumnToJoin.add("idNavioCruzador");

        return factory.readJoin(tableName, columnsArray, nameColumnToJoin);
    }

    public ResultSet Read(int id) throws SQLException {
        ArrayList tableName = new ArrayList();
        tableName.add("navio");
        tableName.add("navioDeGuerra");
        tableName.add("cruzador");

        ArrayList[] columnsArray = new ArrayList[3];
        ArrayList a = new ArrayList();
        a.add("id");
        a.add("nome");
        a.add("tripulantes");
        columnsArray[0] = a;
        a = new ArrayList();
        a.add("idNavioDeGuerra");
        a.add("blindagem");
        a.add("ataque");
        columnsArray[1] = a;
        columnsArray[2] = columns;
        ArrayList nameColumnToJoin = new ArrayList();
        nameColumnToJoin.add("idNavioDeGuerra");
        nameColumnToJoin.add("idNavioCruzador");

        return factory.readJoin(tableName, columnsArray, nameColumnToJoin, id);
    }

    public int Edit(CruzadorVO cruzador, int idBase) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(cruzador.getNum_canhoes());

        ResultSet rs=Read(idBase);
        if (rs.next() == false) {
            return -1;
        }
        int realID=rs.getInt(columns.get(0).toString());
        
        return factory.Edit("cruzador", columns, dados, realID);
    }

    public int Delete(ResultSet rs) throws SQLException {
        int id = rs.getInt(columns.get(0).toString());
        
        int delete = factory.Delete("cruzador", columns, id);
        return delete;
    }

}
