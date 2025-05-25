package dunab.vista;

import dunab.modelo.Acontecimiento;
import dunab.persistencia.RepositorioAcontecimientos;

import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class VentanaCRUD_Acontecimientos extends javax.swing.JFrame {
    private boolean modoOscuro = false;
    private DefaultListModel<String> model = new DefaultListModel<>();
    private List<Acontecimiento> lista = RepositorioAcontecimientos.obtenerTodos();


    public VentanaCRUD_Acontecimientos() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        model = new DefaultListModel<>();
        listaEventos.setModel(model);
        actualizarLista();
        
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

        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEventos = new javax.swing.JList<>();
        btnCambiarTema = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregar.setBackground(new java.awt.Color(58, 220, 60));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(58, 220, 60));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(58, 220, 60));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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
                .addGap(15, 15, 15)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(26, 26, 26)
                .addComponent(btnCambiarTema)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCambiarTema))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        try {
            int id = lista.size() + 1;
            String nombre = JOptionPane.showInputDialog("Nombre del evento:");
            String desc = JOptionPane.showInputDialog("Descripción:");
            String fechaStr = JOptionPane.showInputDialog("Fecha (AAAA-MM-DD):");
            String ubicacion = JOptionPane.showInputDialog("Ubicación:");
            double dunab = Double.parseDouble(JOptionPane.showInputDialog("DUNAB Asociadas:"));

            Acontecimiento nuevo = new Acontecimiento(id, nombre, desc, LocalDate.parse(fechaStr), ubicacion, dunab);
            lista.add(nuevo);
            actualizarLista();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:           
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        int index = listaEventos.getSelectedIndex();
        if (index >= 0) {
            Acontecimiento evento = lista.get(index);
            try {
                String nombre = JOptionPane.showInputDialog("Nuevo nombre:", evento.getNombre());
                String desc = JOptionPane.showInputDialog("Nueva descripción:", evento.getDescripcion());
                String fechaStr = JOptionPane.showInputDialog("Nueva fecha (AAAA-MM-DD):", evento.getFecha().toString());
                String ubicacion = JOptionPane.showInputDialog("Nueva ubicación:", evento.getUbicacion());
                double dunab = Double.parseDouble(JOptionPane.showInputDialog("Nuevas DUNAB:", evento.getDunabAsociadas()));

                Acontecimiento actualizado = new Acontecimiento(evento.getId(), nombre, desc, LocalDate.parse(fechaStr), ubicacion, dunab);
                lista.set(index, actualizado);
                actualizarLista();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al editar: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un evento para editar.");
        }


    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        int index = listaEventos.getSelectedIndex();
        if (index >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar este evento?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                lista.remove(index);
                actualizarLista();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un evento para eliminar.");
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

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
    
    btnAgregar.setBackground(fondoBoton);
    btnAgregar.setForeground(texto);
    btnEditar.setBackground(fondoBoton);
    btnEditar.setForeground(texto);
    btnEliminar.setBackground(fondoBoton);
    btnEliminar.setForeground(texto);
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
            java.util.logging.Logger.getLogger(VentanaCRUD_Acontecimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCRUD_Acontecimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCRUD_Acontecimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCRUD_Acontecimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCRUD_Acontecimientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCambiarTema;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaEventos;
    // End of variables declaration//GEN-END:variables
}
