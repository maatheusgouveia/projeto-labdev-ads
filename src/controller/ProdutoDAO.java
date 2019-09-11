package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Produto;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author matheusgouveia
 */
public class ProdutoDAO {
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    LogsDAO logsDao = new LogsDAO();
    
    public void carregarProdutos(JTable tab, JFrame jfPainel) {
        try {
            con = Conexao.conectar();
            sql = "SELECT NomeProduto AS Produto, DescricaoProduto AS Descricao, PrecoProduto AS Preco FROM produtos";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            Conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfPainel, "Erro ao consultar: "+e);
        }
    }

    //Métodos
    public void cadastrarProduto(Produto produto, JFrame jfCadastros, String NomeUsuario) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Produtos (NomeProduto, DescricaoPro, idMarca) VALUES(?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, produto.getNomeProduto());
            pst.setInt(2, produto.getIdSubcategoria());
            pst.setInt(3, produto.getIdMarca());
            pst.execute();
            logsDao.cadastrarLog("Um produto foi cadastrado", NomeUsuario);
            
            JOptionPane.showMessageDialog(jfCadastros, "Cadastrado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCadastros, "Erro ao Cadastrar: " + e);
        }
    }

    //ALTERAR
    public void alterarProduto(Produto produto, JFrame jfCadastros) {
         try {
            con = Conexao.conectar();
            sql = "UPDATE Produtos SET NomeProduto = ? WHERE idMarca = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, produto.getNomeProduto());
            pst.setInt(2, produto.getIdProduto());
            pst.execute();

            JOptionPane.showMessageDialog(jfCadastros, "Alterada com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCadastros, "Erro ao Alterar: " + e);
        }
    }
    
    //APAGAR
    public void apagarProduto(Produto produto, JFrame jfCadastros) {            
        try {
             con = Conexao.conectar();
             sql = "DELETE FROM Produtos WHERE idProduto = ?";
             pst=con.prepareStatement(sql);
             pst.setInt(1, produto.getIdProduto());
             
             if(JOptionPane.showConfirmDialog(jfCadastros, "Tem certeza que deseja excluir este produto?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION) == 0){
                pst.execute();                               
                JOptionPane.showMessageDialog(jfCadastros, "Excluido com sucesso");
                Conexao.desconectar();
             }
             
        } catch (Exception e) {
             JOptionPane.showConfirmDialog(jfCadastros, "Erro ao excluir: "+e);
        }                   

    }
    
}
