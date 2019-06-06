package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Anuncio;
import model.CmbObjectItem;
import model.Subcategoria;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author matheusgouveia
 */
public class AnuncioDAO {
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    LogsDAO logsDao = new LogsDAO();
    
    public void carregarAnuncios(JTable tab, JFrame jfPainel, int idUsuario) {
        try {
            con = Conexao.conectar();
            sql = "SELECT NomeProduto AS Produto, ValidoDe, ValidoAte, Preco FROM anuncios INNER JOIN produtos ON anuncios.idProduto = produtos.idProduto WHERE anuncios.idUsuario = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            rs=pst.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            Conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfPainel, "Erro ao consultar: "+e);
        }
    }

    //Métodos
    public void cadastrarAnuncio(Anuncio anuncio, JFrame jfCadastros, String NomeUsuario) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Anuncios (idProduto, idUsuario, ValidoDe, ValidoAte, Preco) VALUES(?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, anuncio.getIdProduto());
            pst.setInt(2, anuncio.getIdUsuario());
            pst.setString(3, anuncio.getValidoDe());
            pst.setString(4, anuncio.getValidoAte());
            pst.setFloat(5, anuncio.getPreco());
            pst.execute();
            logsDao.cadastrarLog("Um Anuncio foi cadastrado", NomeUsuario);
            
            JOptionPane.showMessageDialog(jfCadastros, "Cadastrado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCadastros, "Erro ao Cadastrar: " + e);
        }
    }

    //ALTERAR
    public void alterarAnuncio(Subcategoria subcategoria, JFrame jfCadastros) {
         try {
            con = Conexao.conectar();
            sql = "UPDATE Subcategorias SET NomeSubcategoria = ? WHERE idMarca = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, subcategoria.getNomeSubcategoria());
            pst.setInt(2, subcategoria.getIdSubcategoria());
            pst.execute();

            JOptionPane.showMessageDialog(jfCadastros, "Alterada com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCadastros, "Erro ao Alterar: " + e);
        }
    }
    
    //APAGAR
    public void apagarAnuncio(Anuncio anuncio, JFrame jfCadastros) {            
        try {
             con = Conexao.conectar();
             sql = "DELETE FROM Anuncios WHERE idAnuncio = ?";
             pst=con.prepareStatement(sql);
             pst.setInt(1, anuncio.getIdAnuncio());
             
             if(JOptionPane.showConfirmDialog(jfCadastros, "Tem certeza que deseja excluir este anuncio?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION) == 0){
                pst.execute();                               
                JOptionPane.showMessageDialog(jfCadastros, "Excluido com sucesso");
                Conexao.desconectar();
             }
             
        } catch (Exception e) {
             JOptionPane.showConfirmDialog(jfCadastros, "Erro ao excluir: "+e);
        }                   

    }
    
        public void preencherComboBoxProdutos (JComboBox cmbProdutos, JFrame jfCadastro) {
        //List strList = new ArrayList();
        
        try {
            con = Conexao.conectar();
            sql = "SELECT * FROM Produtos";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()){
                CmbObjectItem item = new CmbObjectItem();
                item.setIndex(rs.getInt("idProduto"));
                item.setName(rs.getString("NomeProduto"));
                cmbProdutos.addItem(item);
            }
            
            pst.close();                        
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCadastro, "Erro ao obter categorias: "+e);
        }
                
    }
    
}
