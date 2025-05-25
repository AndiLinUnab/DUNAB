package dunab.vista;

import dunab.modelo.Acontecimiento;
import dunab.modelo.Usuario;
import dunab.persistencia.RepositorioAcontecimientos;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaAcontecimientos extends javax.swing.JFrame {
    private boolean modoOscuro = false;
    private DefaultListModel<String> model;
    private List<Acontecimiento> lista;
    private Usuario usuario;

    public VentanaAcontecimientos() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(255, 153, 0));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        model = new DefaultListModel<>();
        listaEventos.setModel(model);

        for (Acontecimiento a : RepositorioAcontecimientos.obtenerTodos()) {
            model.addElement(a.toString());
        }

    }
    private void actualizarLista() {
        model.clear();
        for (Acontecimiento a : lista) {
            model.addElement(a.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIncribirse = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEventos = new javax.swing.JList<>();
        btnCambiarTema = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(58, 220, 60));

        btnIncribirse.setBackground(new java.awt.Color(58, 220, 60));
        btnIncribirse.setText("Inscribirse");
        btnIncribirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncribirseActionPerformed(evt);
            }
        });

        btnBaja.setBackground(new java.awt.Color(58, 220, 60));
        btnBaja.setText("Darse de baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        listaEventos.setBackground(new java.awt.Color(255, 153, 0));
        listaEventos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaEventos);

        btnCambiarTema.setBackground(new java.awt.Color(58, 220, 60));
        btnCambiarTema.setText("Modo Oscuro");
        btnCambiarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarTemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnIncribirse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnBaja)
                .addGap(35, 35, 35)
                .addComponent(btnCambiarTema)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncribirse)
                    .addComponent(btnBaja)
                    .addComponent(btnCambiarTema))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncribirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncribirseActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        int index = listaEventos.getSelectedIndex();
        if (index >= 0) {
            String seleccionado = listaEventos.getSelectedValue();
            JOptionPane.showMessageDialog(this, "Te has inscrito a: " + seleccionado);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un acontecimiento primero.");
        }

    }//GEN-LAST:event_btnIncribirseActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        int index = listaEventos.getSelectedIndex();
        if (index >= 0) {
            String seleccionado = listaEventos.getSelectedValue();
            JOptionPane.showMessageDialog(this, "Te has dado de baja de: " + seleccionado);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un acontecimiento primero.");
        }

    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnCambiarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarTemaActionPerformed
        // TODO add your handling code here:
        modoOscuro = !modoOscuro;

    Color fondo, texto, fondoLista, fondoBoton;

    if (modoOscuro) {
            fondo = new Color(30, 30, 30);
            texto = Color.WHITE;
            fondoLista = new Color(40, 40, 40);
            fondoBoton = new Color(50, 50, 50);
        } else {
            fondo = new Color(255, 153, 0);
            texto = Color.BLACK;
            fondoLista = new Color(255, 153, 0);
            fondoBoton = new Color(58, 220, 60);
        }

    getContentPane().setBackground(fondo);
    
    btnIncribirse.setBackground(fondoBoton);
    btnIncribirse.setForeground(texto);
    btnBaja.setBackground(fondoBoton);
    btnBaja.setForeground(texto);
    btnCambiarTema.setBackground(fondoBoton);
    btnCambiarTema.setForeground(texto);
    listaEventos.setBackground(fondoLista);
    listaEventos.setForeground(texto);
    }//GEN-LAST:event_btnCambiarTemaActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAcontecimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAcontecimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAcontecimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAcontecimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAcontecimientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnCambiarTema;
    private javax.swing.JButton btnIncribirse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaEventos;
    // End of variables declaration//GEN-END:variables
}
