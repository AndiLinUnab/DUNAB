package dunab.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private int id;
    private String nombreCompleto;
    private String nombreUsuario;
    private String correo;
    private String password;
    private double dunabActual;
    private List<RegistroDUNAB> historial;
    private RecompensaDiaria recompensa = new RecompensaDiaria();
    private double objeto;
    private double dunab;

    private static List<Usuario> usuariosRegistrados = new ArrayList<>();

    public Usuario(String nombreCompleto, String nombreUsuario, String correo, String password) {
        this.id = usuariosRegistrados.size() + 1;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.password = password;
        this.dunabActual = 0.0;
        this.historial = new ArrayList<>();
    }

    public double getDunab() {
        return dunab;
    }

    public void setDunab(double dunab) {
        this.dunab = dunab;
    }

    public double getObjeto() {
        return objeto;
    }

    public void setObjeto(double objeto) {
        this.objeto = objeto;
    }

    public RecompensaDiaria getRecompensa() {
        return recompensa;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public double getDunabActual() {
        return dunabActual;
    }

    public void setDunabActual(double dunabActual) {
        this.dunabActual = dunabActual;
    }

    public List<RegistroDUNAB> getHistorial() {
        return historial;
    }

    public static void agregarUsuario(String nombreCompleto, String nombreUsuario, String correo, String password) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                System.out.println("El nombre de usuario ya está registrado.");
                return;
            }
        }

        Usuario nuevoUsuario = new Usuario(nombreCompleto, nombreUsuario, correo, password);

        usuariosRegistrados.add(nuevoUsuario);
        System.out.println("Nuevo usuario registrado con éxito.");
    }

    public static List<Usuario> obtenerUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public static Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;  
    }
}
