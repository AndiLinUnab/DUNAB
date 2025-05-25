package dunab.vista;

import dunab.persistencia.RepositorioObjetosCanjeables;
import dunab.modelo.ObjetoCanjeable;
import dunab.modelo.RecompensaDiaria;
import dunab.modelo.UsuarioActivo;
import dunab.modelo.Acontecimiento;
import dunab.persistencia.RepositorioAcontecimientos;
import dunab.persistencia.RepositorioUsuarios;
import dunab.modelo.RegistroDUNAB;
import dunab.modelo.Usuario;
import dunab.vista.VentanaTiendaRecompensas;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class MenuPrincipal extends javax.swing.JFrame {

    private List<ObjetoCanjeable> objetosDisponibles;
    private javax.swing.JList<String> listaObjetos;
    private DefaultListModel<ObjetoCanjeable> modelTienda = new DefaultListModel<>();
    private DefaultListModel<ObjetoCanjeable> model;
    private List<Acontecimiento> lista;
    private boolean modoOscuro = false;
    private Usuario usuario;
    private JLabel dunabActual;
    private JTextArea areaNotificaciones;

    private Map<String, Double> calcularPromedios() {
        List<RegistroDUNAB> historial = usuario.getHistorial();
        if (historial.isEmpty()) {
            return Map.of("Semanal", 0.0, "Mensual", 0.0, "Semestral", 0.0, "Anual", 0.0);
        }

        LocalDate hoy = LocalDate.now();
        WeekFields wf = WeekFields.of(Locale.getDefault());

        Map<String, Double> promedios = new LinkedHashMap<>();
        promedios.put("Semanal", promedio(historial.stream().filter(r
                -> r.getFecha().get(wf.weekOfYear()) == hoy.get(wf.weekOfYear())
                && r.getFecha().getYear() == hoy.getYear()).toList()));

        promedios.put("Mensual", promedio(historial.stream().filter(r
                -> r.getFecha().getMonth() == hoy.getMonth()
                && r.getFecha().getYear() == hoy.getYear()).toList()));

        promedios.put("Semestral", promedio(historial.stream().filter(r
                -> getSemestre(r.getFecha()) == getSemestre(hoy)
                && r.getFecha().getYear() == hoy.getYear()).toList()));

        promedios.put("Anual", promedio(historial.stream().filter(r
                -> r.getFecha().getYear() == hoy.getYear()).toList()));

        return promedios;
    }

    private int getSemestre(LocalDate fecha) {
        return (fecha.getMonthValue() - 1) / 6 + 1;
    }

    private double promedio(List<RegistroDUNAB> lista) {
        if (lista.isEmpty()) {
            return 0.0;
        }
        return lista.stream().mapToDouble(RegistroDUNAB::getCantidad).average().orElse(0.0);
    }

    public MenuPrincipal(Usuario usuario) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(255, 153, 0));
        this.usuario = usuario;
        JPanel panel = new JPanel(new GridLayout(12, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblSaludo.setText("Bienvenido, " + usuario.getNombreCompleto());
        lblDunabActual.setText("DUNAB actual: " + usuario.getDunabActual());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnPromedios = new javax.swing.JButton();
        btnVerDunab = new javax.swing.JButton();
        btnFaltanGraduarse = new javax.swing.JButton();
        btnVerAcontecimientos = new javax.swing.JButton();
        btnCRUDAcontecimientos = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        lblSaludo = new javax.swing.JLabel();
        lblDunabActual = new javax.swing.JLabel();
        btnCambiarTema = new javax.swing.JButton();
        btnRecompensa = new javax.swing.JButton();
        btnCargar = new javax.swing.JButton();
        btnFAQ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setText("BIENVENIDO A DUNAB");

        btnAgregar.setBackground(new java.awt.Color(58, 220, 60));
        btnAgregar.setText("Agregar DUNAB");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setBackground(new java.awt.Color(58, 220, 60));
        btnQuitar.setText("Quitar DUNAB");
        btnQuitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuitarMouseClicked(evt);
            }
        });
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnPromedios.setBackground(new java.awt.Color(58, 220, 60));
        btnPromedios.setText("Ver promedios");
        btnPromedios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPromediosMouseClicked(evt);
            }
        });
        btnPromedios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromediosActionPerformed(evt);
            }
        });

        btnVerDunab.setBackground(new java.awt.Color(58, 220, 60));
        btnVerDunab.setText("¿Cuántas DUNAB tengo?");
        btnVerDunab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerDunabMouseClicked(evt);
            }
        });
        btnVerDunab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDunabActionPerformed(evt);
            }
        });

        btnFaltanGraduarse.setBackground(new java.awt.Color(58, 220, 60));
        btnFaltanGraduarse.setText("¿Cuántas me faltan para graduarme?");
        btnFaltanGraduarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFaltanGraduarseMouseClicked(evt);
            }
        });
        btnFaltanGraduarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaltanGraduarseActionPerformed(evt);
            }
        });

        btnVerAcontecimientos.setBackground(new java.awt.Color(58, 220, 60));
        btnVerAcontecimientos.setText("Ver Acontecimientos");
        btnVerAcontecimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerAcontecimientosMouseClicked(evt);
            }
        });
        btnVerAcontecimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerAcontecimientosActionPerformed(evt);
            }
        });

        btnCRUDAcontecimientos.setBackground(new java.awt.Color(58, 220, 60));
        btnCRUDAcontecimientos.setText("CRUD Acontecimientos");
        btnCRUDAcontecimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCRUDAcontecimientosMouseClicked(evt);
            }
        });
        btnCRUDAcontecimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCRUDAcontecimientosActionPerformed(evt);
            }
        });

        btnPerfil.setBackground(new java.awt.Color(58, 220, 60));
        btnPerfil.setText("Ver perfil");
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
        });
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        lblSaludo.setText("Bienvenido,");

        lblDunabActual.setText("DUNAB actual:");

        btnCambiarTema.setBackground(new java.awt.Color(58, 220, 60));
        btnCambiarTema.setText("Modo Oscuro");
        btnCambiarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarTemaActionPerformed(evt);
            }
        });

        btnRecompensa.setBackground(new java.awt.Color(58, 220, 60));
        btnRecompensa.setText("Recompensas Diarias");
        btnRecompensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecompensaActionPerformed(evt);
            }
        });

        btnCargar.setBackground(new java.awt.Color(58, 220, 60));
        btnCargar.setText("Tienda de Recompensas");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnFAQ.setBackground(new java.awt.Color(58, 220, 60));
        btnFAQ.setText("Sección FAQ");
        btnFAQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFAQActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCRUDAcontecimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerAcontecimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFaltanGraduarse, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerDunab, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPromedios, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFAQ)
                                    .addComponent(btnCargar)
                                    .addComponent(btnRecompensa))))
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(64, 64, 64)
                        .addComponent(btnCambiarTema)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDunabActual, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblSaludo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(btnCambiarTema))
                .addGap(22, 22, 22)
                .addComponent(lblSaludo)
                .addGap(18, 18, 18)
                .addComponent(lblDunabActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnRecompensa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitar)
                    .addComponent(btnCargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPromedios)
                    .addComponent(btnFAQ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerDunab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFaltanGraduarse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerAcontecimientos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCRUDAcontecimientos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPerfil)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnQuitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuitarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuitarMouseClicked

    private void btnPromediosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromediosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPromediosMouseClicked

    private void btnVerDunabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerDunabMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerDunabMouseClicked

    private void btnFaltanGraduarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFaltanGraduarseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFaltanGraduarseMouseClicked

    private void btnVerAcontecimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerAcontecimientosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerAcontecimientosMouseClicked

    private void btnCRUDAcontecimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCRUDAcontecimientosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCRUDAcontecimientosMouseClicked

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
            UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        String input = JOptionPane.showInputDialog(this, "¿Cuántos DUNAB deseas agregar?");
        try {
            double cantidad = Double.parseDouble(input);
            usuario.setDunabActual(usuario.getDunabActual() + cantidad);
            usuario.getHistorial().add(new RegistroDUNAB(LocalDate.now(), cantidad));
            lblDunabActual.setText("DUNAB actual: " + usuario.getDunabActual());
            
            JOptionPane.showMessageDialog(this, "Actualización exitosa.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Entrada inválida.");
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        String input = JOptionPane.showInputDialog(this, "¿Cuántos DUNAB deseas quitar?");
        try {
            double cantidad = Double.parseDouble(input);
            usuario.setDunabActual(usuario.getDunabActual() - cantidad);
            usuario.getHistorial().add(new RegistroDUNAB(LocalDate.now(), -cantidad));
            lblDunabActual.setText("DUNAB actual: " + usuario.getDunabActual());
            JOptionPane.showMessageDialog(this, "Actualización exitosa.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Entrada inválida.");
        }

    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnPromediosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromediosActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        Map<String, Double> promedios = calcularPromedios();
        StringBuilder mensaje = new StringBuilder("📊 Promedios de DUNAB:\n\n");
        for (Map.Entry<String, Double> entry : promedios.entrySet()) {
            mensaje.append(entry.getKey()).append(": ").append(String.format("%.2f", entry.getValue())).append(" DUNAB\n");
        }
        JOptionPane.showMessageDialog(this, mensaje.toString());

    }//GEN-LAST:event_btnPromediosActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        JOptionPane.showMessageDialog(this,
                "Perfil:\n"
                + "Nombre Completo: " + usuario.getNombreCompleto() + "\n"
                + "Nombre de Usuario: " + usuario.getNombreUsuario() + "\n"
                + "Correo: " + usuario.getCorreo());
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnVerDunabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDunabActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        JOptionPane.showMessageDialog(this, "Tienes actualmente " + usuario.getDunabActual() + " DUNAB.");
    }//GEN-LAST:event_btnVerDunabActionPerformed

    private void btnFaltanGraduarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaltanGraduarseActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        double meta = 120.0;
        double faltantes = meta - usuario.getDunabActual();
        if (faltantes <= 0) {
            JOptionPane.showMessageDialog(this, "🎓 ¡Ya tienes suficientes DUNAB para graduarte!");
        } else {
            JOptionPane.showMessageDialog(this, "Te faltan " + faltantes + " DUNAB para graduarte.");
        }
    }//GEN-LAST:event_btnFaltanGraduarseActionPerformed

    private void btnVerAcontecimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAcontecimientosActionPerformed
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
        VentanaAcontecimientos va  = new VentanaAcontecimientos();
        va.setVisible(true);
    }//GEN-LAST:event_btnVerAcontecimientosActionPerformed

    private void btnCRUDAcontecimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCRUDAcontecimientosActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
        UIManager.put("List.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        VentanaCRUD_Acontecimientos vc = new VentanaCRUD_Acontecimientos();
        vc.setVisible(true);
    }//GEN-LAST:event_btnCRUDAcontecimientosActionPerformed

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
        btnQuitar.setBackground(fondoBoton);
        btnQuitar.setForeground(texto);
        btnPromedios.setBackground(fondoBoton);
        btnPromedios.setForeground(texto);
        btnVerDunab.setBackground(fondoBoton);
        btnVerDunab.setForeground(texto);
        btnFaltanGraduarse.setBackground(fondoBoton);
        btnFaltanGraduarse.setForeground(texto);
        btnVerAcontecimientos.setBackground(fondoBoton);
        btnVerAcontecimientos.setForeground(texto);
        btnCRUDAcontecimientos.setBackground(fondoBoton);
        btnCRUDAcontecimientos.setForeground(texto);
        btnPerfil.setBackground(fondoBoton);
        btnPerfil.setForeground(texto);
        btnCambiarTema.setBackground(fondoBoton);
        btnCambiarTema.setForeground(texto);
        lblTitulo.setForeground(texto);
        lblSaludo.setForeground(texto);
        lblDunabActual.setForeground(texto);
        btnRecompensa.setBackground(fondoBoton);
        btnRecompensa.setForeground(texto);
        btnCargar.setBackground(fondoBoton);
        btnCargar.setForeground(texto);
        btnFAQ.setBackground(fondoBoton);
        btnFAQ.setForeground(texto);
    }//GEN-LAST:event_btnCambiarTemaActionPerformed

    private void btnRecompensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecompensaActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        Usuario usuario = UsuarioActivo.get();

        LocalDate hoy = LocalDate.now();
        RecompensaDiaria recompensa = usuario.getRecompensa();

        if (hoy.isEqual(recompensa.getUltimaRecompensa())) {
            JOptionPane.showMessageDialog(this, "Ya reclamaste tu recompensa de hoy.\nRacha: " + recompensa.getRacha());
        } else {
            if (hoy.minusDays(1).isEqual(recompensa.getUltimaRecompensa())) {
                recompensa.incrementarRacha();
            } else {
                recompensa.reiniciarRacha();
            }

            recompensa.setUltimaRecompensa(hoy);
            JOptionPane.showMessageDialog(this, "¡Recompensa diaria reclamada!\nRacha actual: " + recompensa.getRacha());
        }
    }//GEN-LAST:event_btnRecompensaActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
        UIManager.put("List.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        VentanaTiendaRecompensas ventana = new VentanaTiendaRecompensas(usuario);
        ventana.setVisible(true);   

    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnFAQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFAQActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.background", new Color(255, 153, 0));
            UIManager.put("Panel.background", new Color(255, 153, 0));     
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("Button.background", new Color(58,220,60));       
            UIManager.put("Button.foreground", Color.BLACK);
        VentanaFAQ ventanaFAQ = new VentanaFAQ();
        ventanaFAQ.setVisible(true);
    }//GEN-LAST:event_btnFAQActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario("Andi Lin", "alin", "alin@unab.edu.co", "Estudiante");
                new MenuPrincipal(usuario).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCRUDAcontecimientos;
    private javax.swing.JButton btnCambiarTema;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnFAQ;
    private javax.swing.JButton btnFaltanGraduarse;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnPromedios;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRecompensa;
    private javax.swing.JButton btnVerAcontecimientos;
    private javax.swing.JButton btnVerDunab;
    private javax.swing.JLabel lblDunabActual;
    private javax.swing.JLabel lblSaludo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
