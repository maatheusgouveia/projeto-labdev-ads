package controller;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Cliente;
import net.proteanit.sql.DbUtils;

public class ClienteDAO {

    //Atributos
    Connection con;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    LogsDAO logsDao = new LogsDAO();

    //Métodos
    
    public void carregarClientes(JTable tab, JFrame jfPainel) {
        try {
            con = Conexao.conectar();
            sql = "SELECT idCliente AS id, NomeCliente AS Nome, RG, CPF, DataNascimento AS Nascimento FROM Clientes";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            Conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jfPainel, "Erro ao consultar: "+e);
        }
    }
    public void cadastrarCliente(Cliente cliente, JFrame jfCliente) {
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO Usuarios (NomeCliente, CPF, RG, DataNascimento) VALUES(?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNomeCLiente());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getRg());
            pst.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTime()));
            pst.execute();
            
            JOptionPane.showMessageDialog(jfCliente, "Cadastrado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jfCliente, "Erro ao Cadastrar: " + e);
        }

    }

    //ALTERAR
    public void alterarDadosCliente(Cliente cliente, JFrame jf) {
         try {
            con = Conexao.conectar();
            sql = "UPDATE Clientes SET NomeUsuario = ?, CPF = ?, RG = ?, DataNascimento = ? WHERE idCliente = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNomeCLiente());            
            pst.setString(2, cliente.getCpf());            
            pst.setString(3, cliente.getRg());
            pst.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTime()));
            pst.execute();            

            JOptionPane.showMessageDialog(jf, "Alterado com Sucesso!");

            Conexao.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jf, "Erro ao Alterar: " + e);
        }
    }

    //APAGAR
    public void apagarCliente(Cliente cliente, JFrame jf) {            
        try {
             con = Conexao.conectar();
             sql = "DELETE FROM Usuarios WHERE idUsuario = ?";
             pst=con.prepareStatement(sql);
             pst.setInt(1, cliente.getIdCliente());
             
             if(JOptionPane.showConfirmDialog(jf, "Tem certeza que deseja excluir este cliente?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION) == 0){
                pst.execute();
             }
             Conexao.desconectar();
        } catch (Exception e) {
             JOptionPane.showConfirmDialog(jf, "Erro ao deletar: "+e);
        }
    }

    //CONSULTAR POR NOME
    public void consultarCLienteNome(int id, JTextField txt, JFrame jf) {

        try {
            con = Conexao.conectar();
            sql = "SELECT idCLiente AS ID, NomeCliente AS Nome, DataNascimento AS Data Nascimento, RG, CPF FROM Clientes WHERE NomeCliente LIKE ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, "%" + txt.getText() + "%");
            rs = pst.executeQuery();
            Conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jf, "Erro ao consultar: "+e);
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
}
