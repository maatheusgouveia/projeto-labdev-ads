/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;
import javax.swing.*;
import model.Venda;
import net.proteanit.sql.DbUtils;
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
    
    public void carregarTotal (JLabel txt, JFrame jf) {
        try {
            con = Conexao.conectar();
            sql = "SELECT  SUM(PrecoProduto * Quantidade) AS Total " +
            "FROM Carrinho INNER JOIN Produtos ON Carrinho.idProduto = Produtos.idProduto";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            txt.setText("" + rs.getFloat("Total"));
            Conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jf, "Erro ao consultar: "+e);
        }
    }
    
    public void carregarVendas(JTable tab, JFrame jfPainel) {
        try {
            con = Conexao.conectar();
            sql = "SELECT idVenda AS id, clientes.NomeCliente AS Nome, clientes.CPF, date(DataHora) AS `Data`, time(DataHora) AS Hora FROM vendas " +
"INNER JOIN clientes ON vendas.idCliente = clientes.idCliente ;";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            Conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfPainel, "Erro ao consultar: "+e);
        }
    }
    
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
