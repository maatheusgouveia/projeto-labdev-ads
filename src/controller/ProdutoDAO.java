package controller;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Produto;
import model.Usuario;
import net.proteanit.sql.DbUtils;
import view.TelaLogin;
import view.TelaPrincipal;

public class ProdutoDAO {

    //Atributos
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    LogsDAO logsDao = new LogsDAO();

    //Métodos
    public void cadastrarProduto(Produto produto, JFrame jfProduto) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Produtos (NomeProduto,idSubcategoria,idMarca,ProdutoPreco) VALUES(?,1,1,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, produto.getNomeProduto());
            pst.setInt(2, produto.getidSubcategoria());
            pst.setInt(3, produto.getidMarca());
            pst.setFloat(4, produto.getPrecoProduto());
            pst.execute();            
            JOptionPane.showMessageDialog(jfProduto, "Cadastrado com Sucesso!");
            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfProduto, "Erro ao Cadastrar: " + e);
        }

    }

    //ALTERAR
    public void alterarDadosProduto(Produto produto, JFrame jfProduto) {
         try {
            con = Conexao.conectar();
            sql = "UPDATE Produtos SET NomeProduto = ?, PrecoProduto = ? WHERE idProduto = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, produto.getNomeProduto());            
            pst.setFloat(2, produto.getPrecoProduto());            
            pst.setInt(3, produto.getIdProduto());
            pst.execute();            

            JOptionPane.showMessageDialog(jfProduto, "Alterado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfProduto, "Erro ao Alterar: " + e);
        }
    }
    
    //APAGAR
    public void apagarProduto(Usuario usuario, JFrame jfConfig) {
            
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
                LogsDAO logsDao = new LogsDAO();
                logsDao.cadastrarLog("Entrou", usuario.getNomeUsuario());
                jfPrincipal.receberDados(usuario);                
            }else{
                JOptionPane.showMessageDialog(jfLogin, "Email ou senha incorreta");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfLogin, "Erro ao consultar: "+e);
        }
    }
}
