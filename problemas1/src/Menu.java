package cafeteria;


public class Menu {

    private cafeteria.Cafe[] productos;
    private int    capacidad;
    private int    total;

    public Menu(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new cafeteria.Cafe[capacidad];
        this.total     = 0;
    }

    public boolean agregarProducto(cafeteria.Cafe producto) {
        if (total >= capacidad) {
            System.out.println("  Menú lleno. No se puede agregar: " + producto.getNombre());
            return false;
        }
        productos[total++] = producto;
        System.out.println("  Agregado al menú: " + producto.getNombre());
        return true;
    }

    public boolean agregarBebida(String nombre, String descripcion,
                                 cafeteria.TipoCafe tipo, cafeteria.RegionCultivo region,
                                 double precio, cafeteria.Receta receta,
                                 String temperatura, String tamano) {
        cafeteria.CafeBebida b = new cafeteria.CafeBebida(
                nombre, descripcion, tipo, region,
                precio, receta, temperatura, tamano, true);
        return agregarProducto(b);
    }

    public boolean agregarPostre(String nombre, String descripcion,
                                 cafeteria.TipoCafe tipo, cafeteria.RegionCultivo region,
                                 double precio, cafeteria.Receta receta,
                                 String textura) {
        cafeteria.CafePostre p = new cafeteria.CafePostre(
                nombre, descripcion, tipo, region,
                precio, receta, textura, "frío", false);
        return agregarProducto(p);
    }

    public void mostrarMenu() {
        System.out.println("\n=======================================");
        System.out.println("       MENÚ DE LA CAFETERÍA           ");
        System.out.println("=======================================");
        if (total == 0) {
            System.out.println("  (sin productos registrados)");
        } else {
            for (int i = 0; i < total; i++) {
                System.out.printf("  %d. %-28s ₡%.0f%n",
                        i + 1,
                        productos[i].getNombre(),
                        productos[i].getPrecio());
            }
        }
        System.out.println("=====================================\n");
    }

    public void mostrarDetalle() {
        System.out.println("\n=== DETALLE COMPLETO DEL MENÚ ===\n");
        for (int i = 0; i < total; i++) {
            productos[i].mostrarInfo();
            System.out.println("  → " + productos[i].preparar());
            System.out.println("  [Receta disponible]");
            productos[i].getReceta().mostrar();
            System.out.println();
        }
    }

    public cafeteria.Cafe buscarProducto(String nombre) {
        for (int i = 0; i < total; i++) {
            if (productos[i].getNombre()
                    .toLowerCase()
                    .contains(nombre.toLowerCase())) {
                return productos[i];
            }
        }
        return null;
    }

    public int  getTotal()     { return total; }
    public int  getCapacidad() { return capacidad; }
    public cafeteria.Cafe getProducto(int i) {
        return (i >= 0 && i < total) ? productos[i] : null;
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void finalize() throws Throwable {
        try {
            System.out.println("Sacando receta del menú");
        } finally {
            super.finalize();
        }
    }
}




