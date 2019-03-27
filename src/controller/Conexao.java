package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    //Atributos
    static Connection conexao = null;
    static String driver = null;
    
    //Métodos
    public static Connection conectar(){
                
        //Carregar o driver
        try {
            //Configura driver
            driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/LabDev","root","");
            System.out.println("Conectado com Sucesso!");
            return conexao;
        } catch (Exception e) {
             System.out.println("Erro ao conectar: "+e);
        }
            return null;
    }
    
    
    public static Connection desconectar(){
        
        try {
            conexao.close();
             System.out.println("Desconectado com Sucesso!");
        } catch (Exception e) {
             System.out.println("Erro ao desconectar: "+e);
        }
        
        return null;
    }
    
}
