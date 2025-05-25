package dunab.modelo;

import java.time.LocalDate;

public class Acontecimiento {
    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private String ubicacion;
    private double dunabAsociadas;

    public Acontecimiento(int id, String nombre, String descripcion, LocalDate fecha, String ubicacion, double dunabAsociadas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.dunabAsociadas = dunabAsociadas;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getDunabAsociadas() {
        return dunabAsociadas;
    }

    @Override
    public String toString() {
        return nombre + " - " + fecha + " - " + ubicacion + " (" + dunabAsociadas + " DUNAB)";
    }
}
