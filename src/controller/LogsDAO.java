/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author mathe
 */
public class LogsDAO {
    
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    
    public void carregarLogs(JTable tabLogs, JFrame jfPainel) {
        try {
            con = Conexao.conectar();
            sql = "SELECT NomeUsuario, Acao, DataHora FROM Logs";
            pst = con.prepareStatement(sql);            
            rs=pst.executeQuery();
            tabLogs.setModel(DbUtils.resultSetToTableModel(rs));
            Conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfPainel, "Erro ao consultar: "+e);
        }
    }
    
    public void cadastrarLog(String Acao, String NomeUsuario) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Logs (Acao, NomeUsuario) VALUES(? , ?)";
            pst = con.prepareStatement(sql);   
            pst.setString(1, Acao);
            pst.setString(2, NomeUsuario);
            pst.execute();            

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar log: " + e);
        }
    }
    
}
