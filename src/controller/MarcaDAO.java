package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Marca;

/**
 *
 * @author matheusgouveia
 */
public class MarcaDAO {
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    LogsDAO logsDao = new LogsDAO();

    //Métodos
    public void cadastrarMarca(Marca marca, JFrame jfCadastros, String NomeUsuario) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Marcas (NomeMarca) VALUES(?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, marca.getNomeMarca());
            pst.execute();
            logsDao.cadastrarLog("Uma marca foi cadastrada", NomeUsuario);
            
            JOptionPane.showMessageDialog(jfCadastros, "Cadastrado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCadastros, "Erro ao Cadastrar: " + e);
        }
    }

    //ALTERAR
    public void alterarMarca(Marca marca, JFrame jfCadastros) {
         try {
            con = Conexao.conectar();
            sql = "UPDATE Marcas SET NomeMarca = ? WHERE idMarca = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, marca.getNomeMarca());
            pst.setInt(2, marca.getIdMarca());
            pst.execute();

            JOptionPane.showMessageDialog(jfCadastros, "Alterada com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCadastros, "Erro ao Alterar: " + e);
        }
    }
    
    //APAGAR
    public void apagarMarca(Marca marca, JFrame jfCadastros) {            
        try {
             con = Conexao.conectar();
             sql = "DELETE FROM Marcas WHERE idMarca = ?";
             pst=con.prepareStatement(sql);
             pst.setInt(1, marca.getIdMarca());
             
             if(JOptionPane.showConfirmDialog(jfCadastros, "Tem certeza que deseja excluir esta categoria?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION) == 0){
                pst.execute();                               
                JOptionPane.showMessageDialog(jfCadastros, "Excluido com sucesso");
                Conexao.desconectar();                               
             }
             
        } catch (Exception e) {
             JOptionPane.showConfirmDialog(jfCadastros, "Erro ao excluir: "+e);
        }                   

    }
    
}
