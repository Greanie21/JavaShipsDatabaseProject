package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlConnector 
{
    private static final String DRIVER="org.mariadb.jdbc.Driver";
    private static final String SERVIDOR="127.0.0.1";
    private static final String PORTA ="3306";
    private static final String BANCO="navios";
    private static final String URL="jdbc:mariadb://"+SERVIDOR+":"+PORTA+"/"+BANCO;
    
    private static final String USUARIO = "root";
    private static final String SENHA = "";//talvez 123
    private static Connection conexao;
    private static Statement statement;
    
    public static Connection getConexao()
    {
        try 
        {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            statement=conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            //System.out.println("Conectou no banco");
        } 
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
        return conexao;
    }
}
