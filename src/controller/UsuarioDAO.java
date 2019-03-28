package controller;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Usuario;
import net.proteanit.sql.DbUtils;
import view.TelaLogin;
import view.TelaCadastro;

public class UsuarioDAO {

    //Atributos
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;

    //Métodos
    //SALVAR
    public void salvarUsuario(Usuario usuario, JFrame jfUsuario) {

        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Usuarios (Email, Senha, NomeUsuario, DataCadastro, idTipoUsuario) VALUES(?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getEmail());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getNomeUsuario());
            pst.setString(4, usuario.getDataCadastro());
            pst.setInt(5, usuario.getIdTipoUsuario());
            pst.execute();

            JOptionPane.showMessageDialog(jfUsuario, "Cadastrado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfUsuario, "Erro ao Cadastrar: " + e);
        }

    }

    //ALTERAR
    public void alterarUsuario(Usuario usuario, JFrame jfUsuario) {
         try {
            con = Conexao.conectar();
            sql = "UPDATE Usuarios set Email = ?, Senha = ?, NomeUsuario = ?, DataCadastro = ?, idTipoUsuario = ? WHERE idUsuario = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getEmail());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getNomeUsuario());
            pst.setString(4, usuario.getDataCadastro());
            pst.setInt(5, usuario.getIdTipoUsuario());
            pst.setInt(6, usuario.getIdUsuario());
            pst.execute();

            JOptionPane.showMessageDialog(jfUsuario, "Alterado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfUsuario, "Erro ao Alterar: " + e);
        }
    }

    //APAGAR
    public void apagarUsuario(Usuario usuario, JFrame jfUsuario) {
            
        try {
             con = Conexao.conectar();
             sql = "delete from Usuario where usu_id = ?";
             pst=con.prepareStatement(sql);
             pst.setInt(1, usuario.getIdUsuario());
             
             if(JOptionPane.showConfirmDialog(jfUsuario, "Deseja Deletar?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION)==0){
                 pst.execute();
                 JOptionPane.showMessageDialog(jfUsuario, "Deletado com Sucesso!");
                 Conexao.desconectar();
             }
             
        } catch (Exception e) {
             JOptionPane.showConfirmDialog(jfUsuario, "Erro ao deletar: "+e);
        }
          
         

    }

    //CONSULTAR POR NOME
    public void consultarUsuarioNome(JTextField txtPesquisa, JTable tabUsuario, JFrame jfUsuario) {
        
        try {
            con = Conexao.conectar();
            sql = "select usu_id as ID, usu_login as Login, usu_tipo as Tipo from Usuario where usu_login like ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, txtPesquisa.getText()+"%");
            rs=pst.executeQuery();
            tabUsuario.setModel(DbUtils.resultSetToTableModel(rs));
            Conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfUsuario, "Erro ao consultar: "+e);
        }

    }

    //CONSULTAR POR ID
    public void consultarUsuarioID(int codUsuario,JTextField txtid, JTextField txtlogin, JComboBox tipo, JFrame jfUsuario) {
        
        try {
            con = Conexao.conectar();
            sql = "select * from Usuario where usu_id=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, codUsuario);
            rs=pst.executeQuery();
            
            if(rs.next()){
                txtid.setText(String.valueOf(rs.getInt("usu_id")));
                txtlogin.setText(rs.getString("usu_login"));
                tipo.setSelectedIndex(rs.getInt("usu_tipo"));
            }else{
                JOptionPane.showMessageDialog(jfUsuario, "Nenhum Registro Encontrado");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfUsuario, "Erro ao consultar: "+e);
        }

    }

}
