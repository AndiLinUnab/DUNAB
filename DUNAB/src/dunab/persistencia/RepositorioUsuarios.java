package dunab.persistencia;

import dunab.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {

    private static List<Usuario> usuarios = new ArrayList<>();

    public static void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null; 
    }

    public static Usuario buscarPorCredenciales(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)
                    && usuario.getPassword().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

}
