package cafeteria;


public abstract class Cafe {

    protected String        nombre;
    protected String        descripcion;
    protected cafeteria.TipoCafe tipoCafe;
    protected cafeteria.RegionCultivo region;
    protected boolean       esConAlcohol;
    protected double        precio;

    protected cafeteria.Receta receta;

    public Cafe(String nombre, String descripcion,
                cafeteria.TipoCafe tipoCafe, cafeteria.RegionCultivo region,
                boolean esConAlcohol, double precio, cafeteria.Receta receta) {
        this.nombre       = nombre;
        this.descripcion  = descripcion;
        this.tipoCafe     = tipoCafe;
        this.region       = region;
        this.esConAlcohol = esConAlcohol;
        this.precio       = precio;
        this.receta       = receta;
    }

    public Cafe(String nombre, String descripcion,
                cafeteria.TipoCafe tipoCafe, cafeteria.RegionCultivo region, cafeteria.Receta receta) {
        this(nombre, descripcion, tipoCafe, region, false, 0.0, receta);
    }

    public abstract String preparar();

    public void mostrarInfo() {
        System.out.println("======================================");
        System.out.printf ("  %-35s│%n", nombre.toUpperCase());
        System.out.println("─────────────────────────────────────");
        System.out.printf ("  Descripción : %-22s│%n", descripcion);
        System.out.printf ("  Tipo de café: %-22s│%n", tipoCafe.getNombre());
        System.out.printf ("  Región      : %-22s│%n", region.getNombre());
        System.out.printf ("  Precio      : ₡%-21.0f│%n", precio);
        System.out.printf ("  Con alcohol : %-22s│%n", esConAlcohol ? "Sí" : "No");
        System.out.println("======================================");
    }

    public String        getNombre()       { return nombre; }
    public String        getDescripcion()  { return descripcion; }
    public cafeteria.TipoCafe getTipoCafe()     { return tipoCafe; }
    public cafeteria.RegionCultivo getRegion()       { return region; }
    public boolean       isConAlcohol()    { return esConAlcohol; }
    public double        getPrecio()       { return precio; }
    public cafeteria.Receta getReceta()       { return receta; }

    public void setPrecio(double precio)   { this.precio = precio; }
    public void setReceta(cafeteria.Receta receta)   { this.receta = receta; }
}
