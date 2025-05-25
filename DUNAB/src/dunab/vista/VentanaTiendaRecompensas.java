package dunab.vista;

import dunab.modelo.Acontecimiento;
import dunab.modelo.UsuarioActivo;
import dunab.modelo.Usuario;
import dunab.modelo.ObjetoCanjeable;
import dunab.persistencia.RepositorioAcontecimientos;
import dunab.persistencia.RepositorioObjetosCanjeables;

import javax.swing.*;
import java.awt.*;

public class VentanaTiendaRecompensas extends JFrame {
    private boolean modoOscuro = false;
    private final dunab.modelo.Usuario usuario;
    private DefaultListModel<ObjetoCanjeable> modelo;
    private DefaultListModel<String> model;

    public VentanaTiendaRecompensas(Usuario usuario) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(255, 153, 0));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.usuario = usuario;
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (ObjetoCanjeable obj : RepositorioObjetosCanjeables.getObjetos()) {
            modelo.addElement(obj.getNombre());
        }
        listaObjetos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCanjear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaObjetos = new javax.swing.JList<>();
        btnCambiarTema = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCanjear.setBackground(new java.awt.Color(58, 220, 60));
        btnCanjear.setText("Canjear");
        btnCanjear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanjearActionPerformed(evt);
            }
        });

        listaObjetos.setBackground(new java.awt.Color(255, 153, 0));
        listaObjetos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaObjetos);

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
                .addGap(160, 160, 160)
                .addComponent(btnCanjear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnCambiarTema)
                .addGap(14, 14, 14))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCanjear)
                    .addComponent(btnCambiarTema))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCanjearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanjearActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        int seleccion = listaObjetos.getSelectedIndex();

    if (seleccion >= 0) {
        String nombreSeleccionado = listaObjetos.getModel().getElementAt(seleccion);

        for (ObjetoCanjeable obj : RepositorioObjetosCanjeables.getObjetos()) {
            if (obj.getNombre().equals(nombreSeleccionado)) {

                double disponibles = usuario.getDunabActual();
                if (disponibles >= obj.getCostoDunab()) {
                    usuario.setDunabActual(disponibles - obj.getCostoDunab());

                    JOptionPane.showMessageDialog(this, "¡Has canjeado: " + obj.getNombre() + " por " + obj.getCostoDunab() + " DUNABs!");

                } else {
                    JOptionPane.showMessageDialog(this, "No tienes suficientes DUNABs para canjear este objeto.");
                }
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Error: no se encontró el objeto canjeable.");
    } else {
        JOptionPane.showMessageDialog(this, "Por favor selecciona un objeto para canjear.");
    }


    }//GEN-LAST:event_btnCanjearActionPerformed

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
    
    btnCanjear.setBackground(fondoBoton);
    btnCanjear.setForeground(texto);
    btnCambiarTema.setBackground(fondoBoton);
    btnCambiarTema.setForeground(texto);
    listaObjetos.setBackground(fondoLista);
    listaObjetos.setForeground(texto);
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
            java.util.logging.Logger.getLogger(VentanaTiendaRecompensas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTiendaRecompensas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTiendaRecompensas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTiendaRecompensas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario("Andi Lin", "alin", "alin@unab.edu.co", "Estudiante");
                VentanaTiendaRecompensas tienda = new VentanaTiendaRecompensas(usuario);
                tienda.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarTema;
    private javax.swing.JButton btnCanjear;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaObjetos;
    // End of variables declaration//GEN-END:variables
}
