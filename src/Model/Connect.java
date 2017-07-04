package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    private static Connection con;  //Declarando Conexão
        // Método de Conexão com o Banco SQLite
    private Connect(){
        try{
            Class.forName("org.sqlite.JDBC").newInstance();     //Driver sqlite
            con = DriverManager.getConnection("jdbc:sqlite:DBinfo.db");
        } catch (Exception e) {
            System.out.println("Não foi possível encontrar o driver.");
            e.printStackTrace();
        }
    }
        //Gera conexão caso ela não exista
    public static Connection getConnection(){
        if(con == null){
            new Connect();
        }
        return con;
    }
        //"Libera" Conexão para um possível re-uso ou somente para segurnça
    public static void releaseCon(){
        con = null;
    }
}

