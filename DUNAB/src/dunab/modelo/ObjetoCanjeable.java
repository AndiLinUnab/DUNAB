package dunab.modelo;

public class ObjetoCanjeable {

    private String nombre;
    private String descripcion;
    private double costoDunab;

    public ObjetoCanjeable(String nombre, String descripcion, double costoDunab) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoDunab = costoDunab;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCostoDunab() {
        return costoDunab;
    }

    @Override
    public String toString() {
        return nombre + " (" + costoDunab + " DUNABs)";
    }

}
