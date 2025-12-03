package dao;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Util {


    public static void habilitarAutocomplete(JComboBox comboBox) {
        comboBox.setEditable(true);
        JTextField editor = (JTextField) comboBox.getEditor().getEditorComponent();
        
        final List<Object> itensOriginais = new ArrayList<>();
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            itensOriginais.add(comboBox.getItemAt(i));
        }

        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) return;

                SwingUtilities.invokeLater(() -> {
                    String textoDigitado = editor.getText();
                    
                    List<Object> listaFiltrada = new ArrayList<>();
                    for (Object item : itensOriginais) {
                        if (item.toString().toLowerCase().contains(textoDigitado.toLowerCase())) {
                            listaFiltrada.add(item);
                        }
                    }

                    DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
                    model.removeAllElements();
                    
                    for (Object item : listaFiltrada) {
                        model.addElement(item);
                    }

                    editor.setText(textoDigitado);

                    if (!listaFiltrada.isEmpty() && !textoDigitado.isEmpty()) {
                        comboBox.showPopup();
                    } else {
                        comboBox.hidePopup();
                    }
                });
            }
        });
    }

public static String formatarDataHora(LocalDate data) {
    if (data == null) return "Sem data definida";
    
    // Correção: DateTimeFormatter em vez de DateFormatter
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
    
    return data.format(fmt);
}
    
    public static boolean validaAno(int ano){
        if(ano >= 2010 && ano  <= 2026){
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Data inválida! Informe data [2010 - 2026]");
            return false;
        }
    }
}
