/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import dao.ImpressoraDAO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import model.Alocacao;
import model.Impressora;
import model.Setor;

/**
 *
 * @author renahn.sebem
 */
public class CadastroAlocacao extends javax.swing.JDialog {

    ImpressoraDAO daoImpressora;
    private Alocacao alocacao;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Creates new form CadastroAlocacao
     */
    public CadastroAlocacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        daoImpressora = new ImpressoraDAO();
        loadSetor();
        loadImpressora();
        txtData.setText(LocalDateTime.now().format(formatter));
        dao.Util.habilitarAutocomplete(cmbImpressora);
        dao.Util.habilitarAutocomplete(cmbSetor);
        txtData.setText(LocalDateTime.now().format(formatter));
    }

    public void loadSetor() {
        cmbSetor.removeAllItems();
        for (Setor obj : Setor.values()) {
            cmbSetor.addItem(obj);
        }
        cmbSetor.setSelectedIndex(-1);
    }

    public void loadImpressora() {
cmbImpressora.removeAllItems();
        for (Impressora obj : daoImpressora.listaImpressora()) {
            cmbImpressora.addItem(obj);
        }
        cmbImpressora.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abe = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        cmbSetor = new javax.swing.JComboBox<>();
        cmbImpressora = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        abe.setText("Impressora");

        jLabel2.setText("Setor");

        jLabel3.setText("IP");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Data");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro Alocação");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(abe, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbImpressora, 0, 161, Short.MAX_VALUE)
                            .addComponent(cmbSetor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIP)
                            .addComponent(txtData)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abe)
                    .addComponent(cmbImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
if (alocacao == null) {
            alocacao = new Alocacao();
        }

        try {
         
            Object selSetor = cmbSetor.getSelectedItem();
            Setor setorFinal = null;

            if (selSetor == null) {
                JOptionPane.showMessageDialog(this, "Selecione um Setor!"); 
                return;
            }

            if (selSetor instanceof Setor) {
                setorFinal = (Setor) selSetor;
            } else {
                String textoDigitado = selSetor.toString();
                for (Setor s : Setor.values()) {
                    if (s.getDescricao().equalsIgnoreCase(textoDigitado)) {
                        setorFinal = s;
                        break;
                    }
                }
            }

            if (setorFinal == null) {
                JOptionPane.showMessageDialog(this, "Setor inválido ou não encontrado na lista!");
                return;
            }

           
            Object selImpressora = cmbImpressora.getSelectedItem();
            Impressora impressoraFinal = null;

            if (selImpressora == null) {
                JOptionPane.showMessageDialog(this, "Selecione uma Impressora!");
                return;
            }

            if (selImpressora instanceof Impressora) {
                impressoraFinal = (Impressora) selImpressora;
            } else {
                String textImp = selImpressora.toString();
                for (int i = 0; i < cmbImpressora.getItemCount(); i++) {
                    Object item = cmbImpressora.getItemAt(i);
                    if (item instanceof Impressora) {
                        if (item.toString().equalsIgnoreCase(textImp)) {
                            impressoraFinal = (Impressora) item;
                            break;
                        }
                    }
                }
            }

            if (impressoraFinal == null) {
                JOptionPane.showMessageDialog(this, "Impressora inválida ou não encontrada na lista!");
                return;
            }

            alocacao.setImpressora(impressoraFinal);
            
     
            impressoraFinal.setDisponivel(false); 
 
            
            alocacao.setSetor(setorFinal);
            alocacao.setIP(txtIP.getText());

            if (txtData.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "O campo Data é obrigatório!");
                return;
            }

            java.time.LocalDate data = java.time.LocalDate.parse(txtData.getText(), formatter);
            alocacao.setDataAlocacao(data);

            this.dispose();

        } catch (java.time.format.DateTimeParseException de) {
            JOptionPane.showMessageDialog(this, "Data inválida! Use o formato dia/mês/ano (ex: 25/12/2023).");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao processar dados: " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroAlocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAlocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAlocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAlocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroAlocacao dialog = new CadastroAlocacao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abe;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Object> cmbImpressora;
    private javax.swing.JComboBox<Object> cmbSetor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtIP;
    // End of variables declaration//GEN-END:variables
    public Alocacao getAlocacao() {
        return alocacao;
    }
// Renomeei para setAlocacao para ficar coerente com a tela

    public void setAlocacao(Alocacao alocacao) {
        this.alocacao = alocacao;

        // 1. Preenche o Setor
        cmbSetor.setSelectedItem(alocacao.getSetor());

        // 2. Preenche a Impressora (Lógica do Serial Number)
        Impressora impAlocada = alocacao.getImpressora();

        if (impAlocada != null) {
            for (int i = 0; i < cmbImpressora.getItemCount(); i++) {
                Object item = cmbImpressora.getItemAt(i);

                if (item instanceof Impressora) {
                    Impressora impCombo = (Impressora) item;

                    if (impCombo.getSerialNumber().equals(impAlocada.getSerialNumber())) {
                        cmbImpressora.setSelectedIndex(i);
                        break;
                    }
                }
            }
        }

        // 3. CORREÇÃO AQUI: Formata a data para dd/MM/yyyy
        if (alocacao.getDataAlocacao() != null) {
            // Usa o formatter que você criou no topo da classe
            txtData.setText(alocacao.getDataAlocacao().format(formatter));
        } else {
            txtData.setText("");
        }

        txtIP.setText(alocacao.getIP());
    }
}
