/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CarrinhoDAO;
import controller.ClienteDAO;
import controller.ProdutoDAO;
import controller.UsuarioDAO;
import controller.VendaDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Carrinho;
import model.Usuario;
import model.Venda;

/**
 *
 * @author MATHEUSAUGUSTOGOUVEI
 */
public class TelaVendas extends javax.swing.JFrame {

    /**
     * Creates new form TelaVendas
     */
    public TelaVendas() {
        initComponents();        
    }
    
    CarrinhoDAO carrinhoDao = new CarrinhoDAO();
    VendaDAO vendaDao = new VendaDAO();
    ProdutoDAO produtoDao = new ProdutoDAO();
    Usuario dadosUsuario = new Usuario();
    
    public void receberDados(Usuario usuario) {
        dadosUsuario = usuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_produtos_consulta = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_clientes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_itens = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_concluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_nome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_consulta_vendas = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_itens_consulta = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btn_pagar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_consulta_produtos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });

        tbl_produtos_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Produto", "Descricao", "Preco", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_produtos_consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_produtos_consultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_produtos_consulta);

        tbl_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nome", "RG", "CPF", "Nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clientesMouseClicked(evt);
            }
        });
        tbl_clientes.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tbl_clientesComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_clientes);

        tbl_itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Produto", "Preco", "Quantidade", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_itens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itensMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_itens);

        jLabel1.setText("Itens da venda");

        btn_concluir.setText("Concluir");
        btn_concluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_concluirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Cliente:");

        btn_nome.setEditable(false);
        btn_nome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Total:");

        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_total.setText("0,00");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("R$");

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(428, 428, 428)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_total)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btn_concluir))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton4)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_concluir)
                    .addComponent(jLabel6)
                    .addComponent(btn_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_total)
                    .addComponent(jLabel9))
                .addGap(37, 37, 37))
        );

        jTabbedPane1.addTab("Venda", jPanel1);

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        tbl_consulta_vendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Cliente", "Data", "Hora", "Status"
            }
        ));
        tbl_consulta_vendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_consulta_vendasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_consulta_vendas);

        tbl_itens_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Produto", "Descricao", "Preco", "Quantidade", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_itens_consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itens_consultaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_itens_consulta);

        jLabel5.setText("Itens do pedido");

        btn_pagar.setText("Pagar");
        btn_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar venda selecionada");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Canceladas");

        jRadioButton2.setText("Pendentes");

        jRadioButton3.setText("Finalizadas");

        tbl_consulta_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Produto", "Descricao", "Preco", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_consulta_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_consulta_produtosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_consulta_produtos);

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(79, 79, 79)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jRadioButton3)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButton2)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_cancelar)
                        .addGap(66, 66, 66)
                        .addComponent(btn_pagar)))
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jButton3))
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_pagar))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_clientesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tbl_clientesComponentShown
        
        
    }//GEN-LAST:event_tbl_clientesComponentShown

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
            
    }//GEN-LAST:event_jTabbedPane1ComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        ClienteDAO clienteDao = new ClienteDAO();
        clienteDao.carregarClientes(tbl_clientes, this);
        ProdutoDAO produtoDao = new ProdutoDAO();
        produtoDao.carregarProdutos(tbl_produtos_consulta, this);
        carrinhoDao.carregarCarrinho(tbl_itens, this);
        carrinhoDao.carregarTotal(lbl_total, this);
    }//GEN-LAST:event_formComponentShown

    private void tbl_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clientesMouseClicked
        int setar = tbl_clientes.getSelectedRow();
        btn_nome.setText(tbl_clientes.getModel().getValueAt(setar, 1).toString() + " " + tbl_clientes.getModel().getValueAt(setar, 3).toString());
    }//GEN-LAST:event_tbl_clientesMouseClicked

    private void tbl_produtos_consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_produtos_consultaMouseClicked
        int setar = tbl_produtos_consulta.getSelectedRow();
        Carrinho carrinho = new Carrinho();
        carrinho.setIdProduto(Integer.parseInt(tbl_produtos_consulta.getModel().getValueAt(setar, 0).toString()));
        if (carrinho.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Quantidade")))) {
            carrinhoDao.inserirProduto(carrinho, this);
            carrinhoDao.carregarCarrinho(tbl_itens, this);
            carrinhoDao.carregarTotal(lbl_total, this);
        }
    }//GEN-LAST:event_tbl_produtos_consultaMouseClicked

    private void tbl_itensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itensMouseClicked
        int setar = tbl_itens.getSelectedRow();
        carrinhoDao.excluirItem(Integer.parseInt(tbl_itens.getModel().getValueAt(setar, 0).toString()));
        carrinhoDao.carregarCarrinho(tbl_itens, this);
        carrinhoDao.carregarTotal(lbl_total, this);
        JOptionPane.showMessageDialog(null, new Date());
    }//GEN-LAST:event_tbl_itensMouseClicked

    private void btn_concluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_concluirActionPerformed
        Venda venda = new Venda();
        int linhaCliente = tbl_clientes.getSelectedRow();
        venda.setIdCliente(Integer.parseInt(tbl_clientes.getModel().getValueAt(linhaCliente, 0).toString()));
        if (JOptionPane.showConfirmDialog(this, "Deseja pagar agora?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
            venda.setStatus("Fechada");
        } else {
            venda.setStatus("Pendente");
        }
        vendaDao.cadastrarVenda(venda, this);
        carrinhoDao.salvarItens();
        carrinhoDao.limparCarrinho();
        carrinhoDao.carregarCarrinho(tbl_itens, this);
        carrinhoDao.carregarTotal(lbl_total, this);
    }//GEN-LAST:event_btn_concluirActionPerformed

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        vendaDao.carregarVendas(tbl_consulta_vendas, this);
        produtoDao.carregarProdutos(tbl_consulta_produtos, this);
    }//GEN-LAST:event_jPanel2ComponentShown

    private void tbl_consulta_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_consulta_produtosMouseClicked
        int setarVenda = tbl_consulta_vendas.getSelectedRow();
        int setarProduto = tbl_consulta_produtos.getSelectedRow();
        vendaDao.inserirProduto(
                Integer.parseInt(tbl_consulta_vendas.getModel().getValueAt(setarVenda, 0).toString()),
                Integer.parseInt(tbl_consulta_produtos.getModel().getValueAt(setarProduto, 0).toString()),
                Integer.parseInt(JOptionPane.showInputDialog("Quantidade: ")), this);
        
        vendaDao.carregarItensVenda(tbl_itens_consulta, Integer.parseInt(tbl_consulta_vendas.getModel().getValueAt(setarVenda, 0).toString()), this);
    }//GEN-LAST:event_tbl_consulta_produtosMouseClicked

    private void tbl_consulta_vendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_consulta_vendasMouseClicked
        int setar = tbl_consulta_vendas.getSelectedRow();
        vendaDao.carregarItensVenda(tbl_itens_consulta, Integer.parseInt(tbl_consulta_vendas.getModel().getValueAt(setar, 0).toString()), this);
    }//GEN-LAST:event_tbl_consulta_vendasMouseClicked

    private void tbl_itens_consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itens_consultaMouseClicked
        int setarVenda = tbl_itens_consulta.getSelectedRow();
        vendaDao.excluirItem(Integer.parseInt(tbl_itens_consulta.getModel().getValueAt(setarVenda, 0).toString()));
        int setar = tbl_consulta_vendas.getSelectedRow();
        vendaDao.carregarItensVenda(tbl_itens_consulta, Integer.parseInt(tbl_consulta_vendas.getModel().getValueAt(setar, 0).toString()), this);
    }//GEN-LAST:event_tbl_itens_consultaMouseClicked

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        UsuarioDAO usuarioDao = new UsuarioDAO();
        if (usuarioDao.verificarUsuario(dadosUsuario.getEmail(), JOptionPane.showInputDialog("Digite sua senha para confirmar: "))) {
            int setarVenda = tbl_consulta_vendas.getSelectedRow();
            String status = tbl_consulta_vendas.getModel().getValueAt(setarVenda, 5).toString();
            if ("Pendente".equals(status)) {
                JOptionPane.showMessageDialog(null, tbl_consulta_vendas.getModel().getValueAt(setarVenda, 0).toString());
                vendaDao.alterarStatus(this, Integer.parseInt(tbl_consulta_vendas.getModel().getValueAt(setarVenda, 0).toString()), "Cancelada");
                vendaDao.carregarVendas(tbl_consulta_vendas, this);
            } else {
                JOptionPane.showMessageDialog(null, "Só é possível cancelar uma venda pendente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem permissão para alterar o status da venda");
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagarActionPerformed
        int setarVenda = tbl_consulta_vendas.getSelectedRow();
        String status = tbl_consulta_vendas.getModel().getValueAt(setarVenda, 5).toString();
        if ("Pendente".equals(status)) {
            JOptionPane.showMessageDialog(null, tbl_consulta_vendas.getModel().getValueAt(setarVenda, 0).toString());
            vendaDao.alterarStatus(this, Integer.parseInt(tbl_consulta_vendas.getModel().getValueAt(setarVenda, 0).toString()), "Fechada");
            vendaDao.carregarVendas(tbl_consulta_vendas, this);
        } else {
            JOptionPane.showMessageDialog(null, "Só é possível pagar uma venda pendente");
        }
    }//GEN-LAST:event_btn_pagarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.receberDados(dadosUsuario);
        telaPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.receberDados(dadosUsuario);
        telaPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaVendas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_concluir;
    private javax.swing.JTextField btn_nome;
    private javax.swing.JButton btn_pagar;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tbl_clientes;
    private javax.swing.JTable tbl_consulta_produtos;
    private javax.swing.JTable tbl_consulta_vendas;
    private javax.swing.JTable tbl_itens;
    private javax.swing.JTable tbl_itens_consulta;
    private javax.swing.JTable tbl_produtos_consulta;
    // End of variables declaration//GEN-END:variables
}
