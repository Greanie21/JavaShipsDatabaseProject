/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.PortaAvioesVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abol9
 */
public class PortaAvioesDAO {

    private ArrayList columns = new ArrayList();
    MysqlFactory factory = new MysqlFactory();

    public PortaAvioesDAO()//
    {
        columns.add("idNavioPortaAvioes");
        columns.add("numAvioes");
    }

    public int Insert(PortaAvioesVO pAvioesVO) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(pAvioesVO.getNumAvioes());

        return factory.inserir("portaAvioes", columns, dados);
    }

    public ResultSet Read() throws SQLException {
        ArrayList tableName = new ArrayList();
        tableName.add("navio");
        tableName.add("navioDeGuerra");
        tableName.add("portaAvioes");

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
        nameColumnToJoin.add("idNavioPortaAvioes");

        return factory.readJoin(tableName, columnsArray, nameColumnToJoin);
    }

    public ResultSet Read(int id) throws SQLException {
        ArrayList tableName = new ArrayList();
        tableName.add("navio");
        tableName.add("navioDeGuerra");
        tableName.add("portaAvioes");

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
        nameColumnToJoin.add("idNavioPortaAvioes");

        return factory.readJoin(tableName, columnsArray, nameColumnToJoin, id);
    }

    public int Edit(PortaAvioesVO pAvioesVO, int idBase) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(pAvioesVO.getNumAvioes());

        ResultSet rs=Read(idBase);
        if (rs.next() == false) {
            return -1;
        }
        int realID=rs.getInt(columns.get(0).toString());
        
        return factory.Edit("portaAvioes", columns, dados, realID);
    }

    public int Delete(ResultSet rs) throws SQLException {
        int id = rs.getInt("idNavioPortaAvioes");
        
        int delete = factory.Delete("portaAvioes", columns, id);
        return delete;
    }
}
