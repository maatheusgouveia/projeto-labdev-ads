/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;
import javax.swing.*;
import model.Venda;
/**
 *
 * @author MATHEUSAUGUSTOGOUVEI
 */
public class VendaDAO {
    
    //Atributos
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    LogsDAO logsDao = new LogsDAO();
    public void cadastrarVenda(Venda venda, JFrame jf) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Vendas (idUsuario, Status) VALUES(?, ?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, venda.getIdCliente());
            pst.setString(2, venda.getStatus());
            pst.execute();

            JOptionPane.showMessageDialog(jf, "Cadastrado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jf, "Erro ao Cadastrar: " + e);
        }

    }
}
