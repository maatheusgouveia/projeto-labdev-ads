/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Carrinho;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author MATHEUSAUGUSTOGOUVEI
 */
public class CarrinhoDAO {
    //Atributos
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    LogsDAO logsDao = new LogsDAO();
    
    public void salvarItens() {
        try {
            con = Conexao.conectar();
            String sqlId = "SELECT MAX(idVenda) AS idVenda FROM Vendas";
            pst = con.prepareStatement(sqlId);
            
            ResultSet rs = pst.executeQuery();
            rs.next();
            int id = rs.getInt("idVenda");
            
            String sql1 = "SELECT * FROM Carrinho";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();
            
            String sql2 = "INSERT INTO ItensVenda (idProduto, idVenda, Quantidade) VALUES (?, ?, ?)";
            PreparedStatement pst2 = con.prepareStatement(sql2);
            
            while (rs1.next()) {
                JOptionPane.showMessageDialog(null, id);
                pst2.setInt(1, rs1.getInt("idProduto"));
                pst2.setInt(2, id);
                pst2.setInt(3, rs1.getInt("Quantidade"));
                pst2.executeUpdate();
            }

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + e);
        }
    }
    
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
    
    public void carregarCarrinho(JTable tab, JFrame jfPainel) {
        try {
            con = Conexao.conectar();
            sql = "SELECT Carrinho.idCarrinho AS id, NomeProduto AS Produto, DescricaoProduto AS Descricao, PrecoProduto AS Preco, Quantidade, (PrecoProduto * Quantidade) AS Subtotal " +
            "FROM Carrinho INNER JOIN Produtos ON Carrinho.idProduto = Produtos.idProduto";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            Conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfPainel, "Erro ao consultar: "+e);
        }
    }
    
    public void inserirProduto(Carrinho carrinho, JFrame jf) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Carrinho (idProduto, Quantidade) VALUES(?, ?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, carrinho.getIdProduto());
            pst.setInt(2, carrinho.getQuantidade());
            pst.execute();

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jf, "Erro ao Cadastrar: " + e);
        }
    }
    
    public void excluirItem (int id) {
        try {
            if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este produto?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION) == 0){
                con = Conexao.conectar();
                sql = "DELETE FROM Carrinho WHERE idCarrinho = ?";
                pst=con.prepareStatement(sql); 
                pst.setInt(1, id);
                pst.execute();
                Conexao.desconectar();
            }
     
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erro ao deletar: "+e);
        }
    }
    
    public void limparCarrinho() {
        try {
            con = Conexao.conectar();
            sql = "DELETE FROM Carrinho";
            pst=con.prepareStatement(sql); 
            pst.execute();
            Conexao.desconectar();
     
        } catch (Exception e) {
             JOptionPane.showConfirmDialog(null, "Erro ao deletar: "+e);
        }
    }
}
