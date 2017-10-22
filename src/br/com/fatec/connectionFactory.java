package br.com.fatec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guerr
 */
public class connectionFactory {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/db_museu";
    private final String USER = "root";
    private final String PASS = "";
    
    /*
    short tries = 0;
        while(tries < 10)
        {
            try
            {
                DB_CONN = DriverManager.getConnection("jdbc:mysql://" + HOST_PORT + "/?user=" + USER + "&password=" + PASSWORD); // UjXf7a.;8-sd0f
                break;
            }
            catch (SQLException ex)
            {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                tries++;
                if(tries == 1)
                {
                    // Inicia o MySQL
                    System.out.println("Tentando iniciar o MySQL...");
                    try
                    {
                        ProcessBuilder pb = new ProcessBuilder("recursos/MySQL_Server_5.6/bin/mysqld.exe");
                        File HH = new File("recursos/MySQL_Server_5.6/bin/");
                        pb.directory(HH);
                        PubliClass.MYSQL_PROCESS = pb.start();
                    }
                    catch (Exception exx)
                    {
                        System.out.println(exx.getMessage());
                        System.out.println(exx.getStackTrace());
                        ex.printStackTrace();
                        System.out.println("Não pode iniciar o MySQL!");
                        PubliClass.SystemExit_Pause(1);
                        return;
                    }
                    try
                    {
                        Thread.sleep(7000);
                    } 
                    catch (InterruptedException ex1) 
                    {
                        System.out.println(ex1.getMessage());
                        System.out.println(ex1.getStackTrace());
                        ex.printStackTrace();
                        System.out.println("Não pode iniciar o MySQL!");
                        PubliClass.SystemExit_Pause(1);
                        return;
                    }
                }
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException ex1) 
                {
                    System.out.println(ex1.getMessage());
                    System.out.println(ex1.getStackTrace());
                    ex.printStackTrace();
                    System.out.println("Não pode iniciar o MySQL!");
                    PubliClass.SystemExit_Pause(1);
                    return;
                }
            }
        }
        if(DB_CONN == null)
        {
            System.out.println("Não pode conectar ao servidor MySQL!");
            PubliClass.SystemExit_Pause(1);
        }
        
        System.out.println("Conexão aberta com servidor MySQL.");

    */

        
    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexao: ",ex);
        }
    }
    
   
    public static void closeConnection(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(connectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(connectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(connectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
