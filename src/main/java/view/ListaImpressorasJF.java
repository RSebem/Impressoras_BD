package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Impressora;
import dao.ImpressoraDAO;
import dao.ManutencaoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.CadastroImpressoraJD;

/**
 *
 * @author renahn.sebem
 */
public class ListaImpressorasJF extends javax.swing.JFrame {

    ImpressoraDAO dao;

    public ListaImpressorasJF() {
        initComponents();
        dao = new ImpressoraDAO();
        configurarTabela();
        loadTabelaImpressoras();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblImpressoras = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnInfo.setText("Mais Informacões");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        tblImpressoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Serial Number", "Disponivel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblImpressoras.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblImpressoras);
        tblImpressoras.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addComponent(btnInfo))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover)
                    .addComponent(btnInfo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configurarTabela() {
        // Define as colunas e os Tipos
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Impressora", "SN", "Disponível"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };

        tblImpressoras.setModel(model);


        tblImpressoras.getColumnModel().getColumn(0).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (value instanceof Impressora) {
                    Impressora imp = (Impressora) value;
                    if (imp.getModelo() != null) {
                        setText(imp.getModelo().getDescricao());
                    } else {
                        setText("Modelo Desconhecido");
                    }
                }
                return this;
            }
        });

        // --- 2. EVENTO DE CLIQUE NO CHECKBOX ---
        model.addTableModelListener(e -> {
            if (e.getType() == javax.swing.event.TableModelEvent.UPDATE && e.getColumn() == 2) {

                int row = e.getFirstRow();
                Impressora imp = (Impressora) model.getValueAt(row, 0);
                Boolean novoStatus = (Boolean) model.getValueAt(row, 2);

                if (novoStatus) {
                    try {
                        tratarRetornoImpressora(imp);
                    } catch (Exception ex) {
                        Logger.getLogger(ListaImpressorasJF.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    imp.setDisponivel(false);
                    try {
                        dao.persist(imp);
                    } catch (Exception ex) {
                        Logger.getLogger(ListaImpressorasJF.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    private void tratarRetornoImpressora(Impressora imp) throws Exception {
        int confirm = JOptionPane.showConfirmDialog(this,
                "Deseja marcar a impressora " + imp.getModelo().getDescricao() + " como disponível?\n"
                + "Isso finalizará manutenções em aberto.",
                "Confirmar Disponibilidade", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {

            imp.setDisponivel(true);
            dao.persist(imp); // Salva no banco


            new ManutencaoDAO().finalizarManutencao(imp);


            JOptionPane.showMessageDialog(this, "Impressora disponível e data de retorno atualizada!");
        } else {

            loadTabelaImpressoras();
        }
    }
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CadastroImpressoraJD telaCadastro = new CadastroImpressoraJD(this, rootPaneCheckingEnabled);
        telaCadastro.setVisible(true);

        Impressora novo = telaCadastro.getImpressora();
        if (novo != null) {
            try {
                dao.persist(novo);
                loadTabelaImpressoras();
            } catch (Exception ex) {
                System.err.println("Erro ao adicionar Impressora: " + ex);
            }

        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblImpressoras.getSelectedRow() != -1) {
            Impressora obj_impressora = (Impressora) tblImpressoras.getValueAt(tblImpressoras.getSelectedRow(), 0);

            CadastroImpressoraJD telaEdicao = new CadastroImpressoraJD(this, true);
            telaEdicao.setImpressora(obj_impressora);
            telaEdicao.setVisible(true);

            Impressora obj_retorno = telaEdicao.getImpressora();
            if (obj_retorno != null) {
                try {
                    dao.persist(obj_retorno);
                    loadTabelaImpressoras();
                } catch (Exception ex) {
                    System.out.println("Erro ao editar impressora: " + ex);
                }
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma impressora");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (tblImpressoras.getSelectedRow() != -1) {
            Impressora obj_impressora = (Impressora) tblImpressoras.getModel().getValueAt(tblImpressoras.getSelectedRow(), 0);

            int op_remover = JOptionPane.showConfirmDialog(rootPane,
                    "ATENÇÃO: Tem certeza que deseja excluir " + obj_impressora.getSerialNumber() + "?\n"
                    + "O sistema apagará AUTOMATICAMENTE a alocação e todas as manutenções.",
                    "Exclusão Total", JOptionPane.YES_NO_OPTION);

            if (op_remover == JOptionPane.YES_OPTION) {
                try {
                    dao.remover(obj_impressora);

                    loadTabelaImpressoras();
                    JOptionPane.showMessageDialog(rootPane, "Impressora e dados associados excluídos com sucesso!");

                } catch (Exception ex) {
                    System.err.println("Erro ao remover: " + ex);
                    JOptionPane.showMessageDialog(rootPane, "Erro ao remover: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma impressora");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        if (tblImpressoras.getSelectedRow() != -1) {
            Impressora obj = (Impressora) tblImpressoras.getModel().getValueAt(tblImpressoras.getSelectedRow(), 0);
            JOptionPane.showMessageDialog(rootPane, obj.exibirDados());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }
    }//GEN-LAST:event_btnInfoActionPerformed

    public void loadTabelaImpressoras() {
        DefaultTableModel model = (DefaultTableModel) tblImpressoras.getModel();
        model.setNumRows(0);

        for (Impressora obj : dao.listaImpressora()) {
            Object[] linha = {
                obj,
                obj.getSerialNumber(), 
                obj.getDisponivel() 
            };
            model.addRow(linha);
        }

    }

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
            java.util.logging.Logger.getLogger(ListaImpressorasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaImpressorasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaImpressorasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaImpressorasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaImpressorasJF().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblImpressoras;
    // End of variables declaration//GEN-END:variables
}
