package dunab.modelo;

public class UsuarioActivo {
    private static Usuario usuario;

    public static void set(Usuario u) {
        usuario = u;
    }

    public static Usuario get() {
        return usuario;
    }
}

