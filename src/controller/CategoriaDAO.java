package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Categoria;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author matheusgouveia
 */
public class CategoriaDAO {
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    LogsDAO logsDao = new LogsDAO();
    
    public void carregarCategorias(JTable tab, JFrame jfPainel) {
        try {
            con = Conexao.conectar();
            sql = "SELECT idCategoria, NomeCategoria FROM Categorias";
            pst = con.prepareStatement(sql);            
            rs=pst.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            Conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfPainel, "Erro ao consultar: "+e);
        }
    }

    //Métodos
    public void cadastrarCategoria(Categoria categoria, JFrame jfCategoria, String NomeUsuario) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Categorias (NomeCategoria) VALUES(?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, categoria.getNomeCategoria());
            pst.execute();
            logsDao.cadastrarLog("Uma categoria foi cadastrada", NomeUsuario);
            
            JOptionPane.showMessageDialog(jfCategoria, "Cadastrado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCategoria, "Erro ao Cadastrar: " + e);
        }
    }

    //ALTERAR
    public void alterarCategoria(Categoria categoria, JFrame jfCategoria) {
         try {
            con = Conexao.conectar();
            sql = "UPDATE Categorias SET NomeCategoria = ? WHERE idCategoria = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, categoria.getNomeCategoria());
            pst.setInt(2, categoria.getIdCategoria());
            pst.execute();

            JOptionPane.showMessageDialog(jfCategoria, "Alterada com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCategoria, "Erro ao Alterar: " + e);
        }
    }
    
    //APAGAR
    public void apagarCategoria(Categoria categoria, JFrame jfCategoria) {            
        try {
             con = Conexao.conectar();
             sql = "DELETE FROM Categorias WHERE idCategoria = ?";
             pst=con.prepareStatement(sql);
             pst.setInt(1, categoria.getIdCategoria());
             
             if(JOptionPane.showConfirmDialog(jfCategoria, "Tem certeza que deseja excluir esta categoria?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION) == 0){
                pst.execute();                               
                JOptionPane.showMessageDialog(jfCategoria, "Excluido com sucesso");
                Conexao.desconectar();                               
             }
             
        } catch (Exception e) {
             JOptionPane.showConfirmDialog(jfCategoria, "Erro ao excluir: "+e);
        }                   

    }
    
}
