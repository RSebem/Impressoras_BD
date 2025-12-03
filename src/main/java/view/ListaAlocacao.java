package view;

import javax.swing.table.DefaultTableModel;
import model.Alocacao;
import dao.AlocacaoDAO;
import dao.ImpressoraDAO;
import javax.swing.JOptionPane;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import model.Impressora;

/**
 *
 * @author renahn.sebem
 */
public class ListaAlocacao extends javax.swing.JFrame {

    AlocacaoDAO dao;

    public ListaAlocacao() {
        initComponents();

        dao = new AlocacaoDAO();
        configurarTabela();
        loadTabelaAlocacao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlocacao = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblAlocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Impressora", "Setor", "IP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAlocacao);

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

        btnInfo.setText("Mais Informações");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(btnInfo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover)
                    .addComponent(btnInfo))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
CadastroAlocacao telaAlocacao = new CadastroAlocacao(this, rootPaneCheckingEnabled);
        telaAlocacao.setVisible(true);

        Alocacao novoObj = telaAlocacao.getAlocacao();

        if (novoObj != null) {

            try {

                dao.persist(novoObj); 
                
                loadTabelaAlocacao();
                
            } catch (Exception ex) {
                if(ex.getMessage() != null && ex.getMessage().contains("chave duplicada")) {
                     JOptionPane.showMessageDialog(this, "Erro: Esta impressora já possui uma alocação ativa!");
                } else if(ex.getCause() != null && ex.getCause().getMessage().contains("chave duplicada")) {
                     JOptionPane.showMessageDialog(this, "Erro: Esta impressora já possui uma alocação ativa!");
                } else {
                     System.err.println("Erro ao salvar: " + ex);
                     JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblAlocacao.getSelectedRow() != -1) {
            Alocacao objSelecionado = (Alocacao) tblAlocacao.getValueAt(tblAlocacao.getSelectedRow(), 0);

            CadastroAlocacao telaEdicao = new CadastroAlocacao(this, true);
            telaEdicao.setAlocacao(objSelecionado);
            telaEdicao.setVisible(true);

            Alocacao objRetorno = telaEdicao.getAlocacao();

            if (objRetorno != null) {
                try {
                    dao.persist(objRetorno); // ou merge
                    loadTabelaAlocacao();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao editar: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma alocação para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
if (tblAlocacao.getSelectedRow() != -1) {
            Alocacao obj = (Alocacao) tblAlocacao.getModel().getValueAt(tblAlocacao.getSelectedRow(), 0);
            
            String descImpressora = (obj.getImpressora() != null && obj.getImpressora().getModelo() != null) 
                    ? obj.getImpressora().getModelo().getDescricao() 
                    : "Desconhecida";

            String txtAlocacao = "Alocação: " + descImpressora + " no setor " + obj.getSetor();
            
            int op_remover = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover: " + txtAlocacao + "?\nA impressora ficará disponível novamente.");
            
            if (op_remover == JOptionPane.YES_OPTION) {
                try {
                    Impressora imp = obj.getImpressora();
                    
                    if (imp != null) {
                        imp.setDisponivel(true);
                        imp.setAlocacao(null); 
                    }
                    
                    obj.setImpressora(null); 

                    dao.remover(obj);
                    
                    if (imp != null) {
                        new ImpressoraDAO().merge(imp);
                    }

                    loadTabelaAlocacao();
                    JOptionPane.showMessageDialog(rootPane, "Alocação removida e impressora liberada.");
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao remover: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        if (tblAlocacao.getSelectedRow() != -1) {
            Alocacao obj = (Alocacao) tblAlocacao.getModel().getValueAt(tblAlocacao.getSelectedRow(), 0);
            JOptionPane.showMessageDialog(rootPane, obj.exibirDados());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }
    }//GEN-LAST:event_btnInfoActionPerformed

    private void configurarTabela() {
 var colunaModelo = tblAlocacao.getColumnModel().getColumn(0);

        colunaModelo.setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value instanceof Alocacao) {
                    Alocacao aloc = (Alocacao) value;
                    if (aloc.getImpressora() != null && aloc.getImpressora().getModelo() != null) {
                        setText(aloc.getImpressora().getModelo().getDescricao());
                    }
                }
                return this;
            }
        });
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAlocacao().setVisible(true);
            }
        });
    }

    public void loadTabelaAlocacao() {
        DefaultTableModel modelo = (DefaultTableModel) tblAlocacao.getModel();
        modelo.setNumRows(0);

        for (Alocacao obj : dao.listaAlocacao()) {

            Object[] linha = {
                obj,
                obj.getSetor(),
                obj.getIP()
            };
            modelo.addRow(linha);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlocacao;
    // End of variables declaration//GEN-END:variables

}
