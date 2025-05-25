package dunab.controlador;

import dunab.modelo.Usuario;
import dunab.persistencia.RepositorioUsuarios;
import dunab.vista.MenuPrincipal;
import dunab.vista.LoginFrame;

import javax.swing.*;

public class ControladorUsuario {

    public static void login(String nombreUsuario, String contraseña, LoginFrame loginFrame) {
        Usuario usuario = RepositorioUsuarios.buscarUsuario(nombreUsuario);
        if (usuario != null && usuario.getPassword().equals(contraseña)) {
            JOptionPane.showMessageDialog(null, "¡Inicio de sesión exitoso!");
            
            loginFrame.dispose();
            
            new MenuPrincipal(usuario).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
        }
    }

public static void registrarUsuario(String nombre, String usuario, String correo, String contrasena) {
    if (nombre.isEmpty() || usuario.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
        return;
    }

    if (!correo.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
        JOptionPane.showMessageDialog(null, "El correo no tiene un formato válido.");
        return;
    }

    Usuario usuarioExistente = RepositorioUsuarios.buscarUsuario(usuario);
    if (usuarioExistente != null) {
        JOptionPane.showMessageDialog(null, "El usuario ya existe.");
        return;
    }

    Usuario nuevoUsuario = new Usuario(nombre, usuario, correo, contrasena);

    RepositorioUsuarios.registrarUsuario(nuevoUsuario);

    JOptionPane.showMessageDialog(null, "¡Usuario registrado exitosamente!");
    }
}








