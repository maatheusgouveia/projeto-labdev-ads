package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.CmbObjectItem;
import model.Subcategoria;

/**
 *
 * @author matheusgouveia
 */
public class SubcategoriaDAO {
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    LogsDAO logsDao = new LogsDAO();

    //Métodos
    public void cadastrarSubcategoria(Subcategoria subcategoria, JFrame jfCadastros, String NomeUsuario) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Subcategorias (NomeSubcategoria, idCategoria) VALUES(?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, subcategoria.getNomeSubcategoria());
            pst.setInt(2, subcategoria.getIdCategoria());
            pst.execute();
            logsDao.cadastrarLog("Uma subcategoria foi cadastrada", NomeUsuario);
            
            JOptionPane.showMessageDialog(jfCadastros, "Cadastrado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCadastros, "Erro ao Cadastrar: " + e);
        }
    }

    //ALTERAR
    public void alterarSubcategoria(Subcategoria subcategoria, JFrame jfCadastros) {
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
    public void apagarSubcategoria(Subcategoria subcategoria, JFrame jfCadastros) {            
        try {
             con = Conexao.conectar();
             sql = "DELETE FROM Subcategorias WHERE idSucategoria = ?";
             pst=con.prepareStatement(sql);
             pst.setInt(1, subcategoria.getIdSubcategoria());
             
             if(JOptionPane.showConfirmDialog(jfCadastros, "Tem certeza que deseja excluir esta subcategoria?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION) == 0){
                pst.execute();                               
                JOptionPane.showMessageDialog(jfCadastros, "Excluido com sucesso");
                Conexao.desconectar();
             }
             
        } catch (Exception e) {
             JOptionPane.showConfirmDialog(jfCadastros, "Erro ao excluir: "+e);
        }                   

    }
    
        public void preencherComboBox (JComboBox cmbCategorias, JFrame jfCadastro) {
        //List strList = new ArrayList();
        
        try {
            con = Conexao.conectar();
            sql = "SELECT * FROM Categorias";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()){
                CmbObjectItem item = new CmbObjectItem();
                item.setIndex(rs.getInt("idCategoria"));
                item.setName(rs.getString("NomeCategoria"));
                cmbCategorias.addItem(item);
            }
            
            pst.close();                        
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCadastro, "Erro ao obter categorias: "+e);
        }
                
    }
    
}
