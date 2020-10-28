/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.NavioMercanteVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abol9
 */
public class NavioMercanteDAO {

    private ArrayList columns = new ArrayList();
    ArrayList parentColumns = new ArrayList();
    MysqlFactory factory = new MysqlFactory();

    public NavioMercanteDAO() {
        this.columns.add("idNavioMercante");
        this.columns.add("capacidadeDeCarga");
        this.columns.add("carga");

        parentColumns.add("id");
        parentColumns.add("nome");
        parentColumns.add("tripulantes");
        parentColumns.add("idNavioMercante");
    }

    public int Inserir(NavioMercanteVO nmVO) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(nmVO.getCapacidadeDeCarga());
        dados.add(nmVO.getCarga());

        int resultInsert = factory.inserir("navioMercante", columns, dados);

        return resultInsert;
    }

    public ResultSet Read() throws SQLException {
        ArrayList tableName = new ArrayList();

        tableName.add("navio");
        tableName.add("navioMercante");

        ArrayList[] columnsArray = new ArrayList[2];
        ArrayList a = new ArrayList();
        a.add("id");
        a.add("nome");
        a.add("tripulantes");
        columnsArray[0] = a;
        columnsArray[1] = columns;

        ArrayList nameColumnToJoin = new ArrayList();
        nameColumnToJoin.add("idNavioMercante");

        return factory.readJoin(tableName, columnsArray, nameColumnToJoin);
    }

    public ResultSet Read(int id) throws SQLException {
        ArrayList tableName = new ArrayList();

        tableName.add("navio");
        tableName.add("navioMercante");

        ArrayList[] columnsArray = new ArrayList[2];
        ArrayList a = new ArrayList();
        a.add("id");
        a.add("nome");
        a.add("tripulantes");
        columnsArray[0] = a;
        columnsArray[1] = columns;

        ArrayList nameColumnToJoin = new ArrayList();
        nameColumnToJoin.add("idNavioMercante");

        return factory.readJoin(tableName, columnsArray, nameColumnToJoin, id);
    }

    public int Edit(NavioMercanteVO nmVO, int idBase) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(nmVO.getCapacidadeDeCarga());
        dados.add(nmVO.getCarga());

        ResultSet rs = Read(idBase);
        if (rs.next() == false) {
            return -1;
        }
        int realID = rs.getInt(columns.get(0).toString());

        return factory.Edit("navioMercante", columns, dados, realID);
    }

    public int Delete(ResultSet rs) throws SQLException {
        int realID = rs.getInt(columns.get(0).toString());

        int delete = factory.Delete("navioMercante", columns, realID);
        return delete;
    }
}
