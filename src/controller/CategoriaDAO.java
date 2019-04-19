package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Categoria;

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

    //Métodos
    public void cadastrarCategoria(Categoria categoria, JFrame jfCategoria, int idUsuario) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Categorias (NomeCategoria) VALUES(?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, categoria.getNomeCategoria());
            pst.execute();
            logsDao.cadastrarLog("Uma categoria foi cadastrada", idUsuario);
            
            JOptionPane.showMessageDialog(jfCategoria, "Cadastrado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCategoria, "Erro ao Cadastrar: " + e);
        }

    }

    //ALTERAR
    public void alterarDadosUsuario(Categoria categoria, JFrame jfCategoria) {
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
    
}
