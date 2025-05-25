package dunab.vista;

import java.awt.Color;
import javax.swing.*;

public class VentanaFAQ extends javax.swing.JFrame {
    private boolean modoOscuro = false;
    
    public VentanaFAQ() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(255, 153, 0));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFAQ = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnContacto = new javax.swing.JButton();
        btnCambiarTema = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFAQ.setText("Sin información, próximamente");

        btnCerrar.setBackground(new java.awt.Color(58, 220, 60));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnContacto.setBackground(new java.awt.Color(58, 220, 60));
        btnContacto.setText("Contacto");
        btnContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactoActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFAQ, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCerrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnContacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(btnCambiarTema)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFAQ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnContacto)
                    .addComponent(btnCambiarTema))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactoActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        JOptionPane.showMessageDialog(this, 
        "📧 Contacto de soporte:\n" +
        "Email: soporte@dunab.com\n" +
        "Teléfono: +57 300 000 0000", 
        "Contacto", 
        JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnContactoActionPerformed

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
    
    lblFAQ.setForeground(texto);
    btnCerrar.setBackground(fondoBoton);
    btnCerrar.setForeground(texto);
    btnContacto.setBackground(fondoBoton);
    btnContacto.setForeground(texto);
    btnCambiarTema.setBackground(fondoBoton);
    btnCambiarTema.setForeground(texto);
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
            java.util.logging.Logger.getLogger(VentanaFAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFAQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaFAQ().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarTema;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnContacto;
    private javax.swing.JLabel lblFAQ;
    // End of variables declaration//GEN-END:variables
}
