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
import view.TelaPrincipal;

public class UsuarioDAO {

    //Atributos
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;

    //Métodos
    public void cadastrarUsuario(Usuario usuario, JFrame jfUsuario) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Usuarios (Email, Senha, NomeUsuario, DataCadastro, idTipoUsuario) VALUES(?, md5(?), ?, CURRENT_TIMESTAMP, 2)";
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getEmail());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getNomeUsuario());                        
            pst.execute();

            JOptionPane.showMessageDialog(jfUsuario, "Cadastrado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfUsuario, "Erro ao Cadastrar: " + e);
        }

    }

    //ALTERAR
    public void alterarDadosUsuario(Usuario usuario, JFrame jfUsuario) {
         try {
            con = Conexao.conectar();
            sql = "UPDATE Usuarios SET Email = ?, NomeUsuario = ? WHERE idUsuario = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getEmail());            
            pst.setString(2, usuario.getNomeUsuario());            
            pst.setInt(3, usuario.getIdUsuario());
            pst.execute();            

            JOptionPane.showMessageDialog(jfUsuario, "Alterado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfUsuario, "Erro ao Alterar: " + e);
        }
    }
    
    public void alterarSenhaUsuario(Usuario usuario, JFrame jfUsuario, JTextField txtNovaSenha) {
         try {
            con = Conexao.conectar();
            sql = "SELECT * FROM Usuarios WHERE Email = ? AND Senha = md5(?)";
            pst = con.prepareStatement(sql);            
            pst.setString(1, usuario.getEmail());
            pst.setString(2, usuario.getSenha());
            rs = pst.executeQuery();
            //verificar se a senha está correta, caso a consulta traga resultados a senha será alterada
            
            if(rs.next()){
                sql = "UPDATE Usuarios SET Senha = md5(?) WHERE idUsuario = ?";
                pst = con.prepareStatement(sql);                            
                pst.setString(1, txtNovaSenha.getText());
                pst.setInt(2, usuario.getIdUsuario());
                pst.execute();

                JOptionPane.showMessageDialog(jfUsuario, "Senha alterada com Sucesso!\n Não esqueça de utilizá-la na próxima vez que fizer login");
            } else {
                JOptionPane.showMessageDialog(jfUsuario, "Senha Incorreta");
            }                                 

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfUsuario, "Erro ao Alterar: " + e);
        }
    }

    //APAGAR
    public void apagarUsuario(Usuario usuario, JFrame jfConfig) {
            
        try {
             con = Conexao.conectar();
             sql = "DELETE FROM Usuarios WHERE idUsuario = ?";
             pst=con.prepareStatement(sql);
             pst.setInt(1, usuario.getIdUsuario());
             
             if(JOptionPane.showConfirmDialog(jfConfig, "Tem certeza que deseja excluir sua conta?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION) == 0){
                pst.execute();
                TelaLogin telaLogin = new TelaLogin();                
                JOptionPane.showMessageDialog(jfConfig, "Sentiremos sua falta :(");
                Conexao.desconectar();
                telaLogin.setVisible(true);
                jfConfig.setVisible(false);
             }
             
        } catch (Exception e) {
             JOptionPane.showConfirmDialog(jfConfig, "Erro ao deletar: "+e);
        }                   

    }

    //CONSULTAR POR NOME
    public void consultarUsuarioNome(JTextField txtPesquisa, JTable tabUsuario, JFrame jfUsuario) {
        
        try {
            con = Conexao.conectar();
            sql = "SELECT idUsuario AS ID, Email, idTipoUsuario AS Tipo, NomeUsuario AS NOME, DataCriacao FROM Usuarios WHERE NomeUsuario LIKE ?";
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
            sql = "SELECT * FROM Usuarios WHERE idUsuario=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, codUsuario);
            rs=pst.executeQuery();
            
            if(rs.next()){
                txtid.setText(String.valueOf(rs.getInt("idUsuario")));
                txtlogin.setText(rs.getString("Email"));
                tipo.setSelectedIndex(rs.getInt("idTipoUsuario"));
            }else{
                JOptionPane.showMessageDialog(jfUsuario, "Nenhum Registro Encontrado");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfUsuario, "Erro ao consultar: "+e);
        }
    }
    
    public void login(JTextField txtEmail, JTextField txtSenha, JFrame jfLogin, TelaPrincipal jfPrincipal) {        
        try {
            con = Conexao.conectar();
            sql = "SELECT * FROM Usuarios WHERE Email = ? AND Senha = md5(?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, txtEmail.getText());
            pst.setString(2, txtSenha.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){
                Usuario usuario = new Usuario();                
                jfLogin.setVisible(false);
                jfPrincipal.setVisible(true);
                usuario.setNomeUsuario(rs.getString("NomeUsuario"));
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setDataCadastro(rs.getString("DataCadastro"));
                jfPrincipal.receberDados(usuario);                
            }else{
                JOptionPane.showMessageDialog(jfLogin, "Email ou senha incorreta");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfLogin, "Erro ao consultar: "+e);
        }
    }
}
