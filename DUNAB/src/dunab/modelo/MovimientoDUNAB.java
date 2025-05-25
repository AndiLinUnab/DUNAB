package dunab.modelo;

import java.time.LocalDate;

public class MovimientoDUNAB {
    private LocalDate fecha;
    private double cantidad;

    public MovimientoDUNAB(LocalDate fecha, double cantidad) {
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getCantidad() {
        return cantidad;
    }
}
