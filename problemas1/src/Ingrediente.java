package cafeteria;

public class Ingrediente {

    private String nombre;
    private double cantidad;
    private String unidad;

    public Ingrediente(String nombre, double cantidad, String unidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }

    public Ingrediente(String nombre, double cantidad) {
        this(nombre, cantidad, "unidad");
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    @Override
    public String toString() {
        return String.format("  • %-22s %6.1f %s", nombre, cantidad, unidad);
    }
}
