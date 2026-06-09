package cafeteria;

public class CafeBebida extends cafeteria.Cafe {

    private String  temperatura;  // "caliente" | "frío"
    private String  tamano;       // "pequeño" | "mediano" | "grande"
    private boolean esSimple;     // simple = un solo espresso base

    public CafeBebida(String nombre, String descripcion,
                      TipoCafe tipoCafe, RegionCultivo region,
                      boolean esConAlcohol, double precio, Receta receta,
                      String temperatura, String tamano, boolean esSimple) {
        super(nombre, descripcion, tipoCafe, region,
              esConAlcohol, precio, receta);
        this.temperatura = temperatura;
        this.tamano      = tamano;
        this.esSimple    = esSimple;
    }

     public CafeBebida(String nombre, String descripcion,
                       TipoCafe tipoCafe, RegionCultivo region,
                       double precio, Receta receta,
                       String temperatura, String tamano, boolean esSimple) {
         this(nombre, descripcion, tipoCafe, region,
              false, precio, receta,
              temperatura, tamano, esSimple);
     }

     @Override
     public void mostrarInfo() {
         super.mostrarInfo();
         System.out.printf("   Temperatura: %-10s | Tamaño: %-8s | %s%n",
             temperatura, tamano,
             esSimple ? "Simple" : "Compuesto");
     }

     @Override
     public String preparar() {
         return String.format(
             "Preparando %s [%s] a temperatura %s en tamaño %s.",
             nombre, tipoCafe.getNombre(), temperatura, tamano);
     }

     public String  getTemperatura() { return temperatura; }
     public String  getTamano()      { return tamano; }
     public boolean isSimple()       { return esSimple; }
}
