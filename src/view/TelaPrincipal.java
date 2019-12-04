package view;

import controller.LogsDAO;
import controller.UsuarioDAO;
import model.Usuario;
import javax.swing.*;
import reports.Relatorio;

public class TelaPrincipal extends javax.swing.JFrame {
    
    Usuario dadosUsuario;
    
    public TelaPrincipal() {
        initComponents();
    }
    
    public void receberDados(Usuario usuario) {
        dadosUsuario = usuario;
        lblBemVindo.setText("Bem vindo, " + dadosUsuario.getNomeUsuario());
        lblBemVindo.setHorizontalTextPosition(JLabel.CENTER);
        lblBemVindo.setVerticalTextPosition(JLabel.TOP);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBemVindo = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btn_cliente = new javax.swing.JButton();
        btn_venda = new javax.swing.JButton();
        btn_produto1 = new javax.swing.JButton();
        btn_usuario1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        lblBemVindo.setBackground(new java.awt.Color(0, 153, 255));
        lblBemVindo.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblBemVindo.setForeground(new java.awt.Color(255, 255, 255));
        lblBemVindo.setText("                                   Bem Vindo");
        lblBemVindo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblBemVindo.setOpaque(true);

        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btn_cliente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/contactlist_theuser_802.png"))); // NOI18N
        btn_cliente.setText("Usuários");
        btn_cliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clienteActionPerformed(evt);
            }
        });

        btn_venda.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/warehause_products_safety_5996.png"))); // NOI18N
        btn_venda.setText("Produtos");
        btn_venda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vendaActionPerformed(evt);
            }
        });

        btn_produto1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_produto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shoppaymentorderbuy-20_icon-icons.com_73877.png"))); // NOI18N
        btn_produto1.setText("Vendas");
        btn_produto1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_produto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produto1ActionPerformed(evt);
            }
        });

        btn_usuario1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_usuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Clients_27015.png"))); // NOI18N
        btn_usuario1.setText("Clientes");
        btn_usuario1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_usuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuario1ActionPerformed(evt);
            }
        });

        jButton1.setText("Relatório de clientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Relatório de usuários");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Relatório de produtos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(lblBemVindo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                .addComponent(btn_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_produto1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButton1)
                .addGap(113, 479, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cliente)
                    .addComponent(btn_venda))
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_usuario1)
                    .addComponent(btn_produto1))
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        TelaLogin telaLogin = new TelaLogin();
        LogsDAO logsDao = new LogsDAO();
        logsDao.cadastrarLog("Saiu", dadosUsuario.getNomeUsuario());
        telaLogin.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnSairActionPerformed

    private void btn_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clienteActionPerformed
        // TODO add your handling code here:
        if (dadosUsuario.getIdTipoUsuario() == 1) {
            PainelAdministrativo painel = new PainelAdministrativo();
            painel.receberDados(dadosUsuario);
            painel.setVisible(true);
            this.setVisible(false);
            
        } else {
            TelaConfiguracoes telaConfiguracoes = new TelaConfiguracoes();
            telaConfiguracoes.receberDados(dadosUsuario);
            telaConfiguracoes.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_btn_clienteActionPerformed

    private void btn_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vendaActionPerformed
        PainelProdutos painelProdutos = new PainelProdutos();
        painelProdutos.receberDados(dadosUsuario);
        painelProdutos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_vendaActionPerformed

    private void btn_produto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produto1ActionPerformed
        TelaVendas telaVendas = new TelaVendas();
        telaVendas.receberDados(dadosUsuario);
        telaVendas.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_produto1ActionPerformed

    private void btn_usuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuario1ActionPerformed
        PainelClientes painelClientes = new PainelClientes();
        painelClientes.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_usuario1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Relatorio relatorio = new Relatorio();
        relatorio.gerarRelatorio("Produtos");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (dadosUsuario.getIdTipoUsuario() == 1) {
            Relatorio relatorio = new Relatorio();
            relatorio.gerarRelatorio("Usuarios");
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem permissão para visualizar este relatório");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UsuarioDAO usuarioDao = new UsuarioDAO();
        if (usuarioDao.verificarUsuario(dadosUsuario.getEmail(), JOptionPane.showInputDialog("Digite sua senha para confirmar: "))) {
            Relatorio relatorio = new Relatorio();
            relatorio.gerarRelatorio("Clientes");
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem permissão para visualizar este relatório");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btn_cliente;
    private javax.swing.JButton btn_produto1;
    private javax.swing.JButton btn_usuario1;
    private javax.swing.JButton btn_venda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel lblBemVindo;
    // End of variables declaration//GEN-END:variables
}
