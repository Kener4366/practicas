package cafeteria;

public class CafePostre extends cafeteria.Cafe {
     private String textura; // "cremoso", "ligero", "denso"
     private String sabor;   // "dulce", "amargo", "afrutado"
     private boolean esGourmet;

        public CafePostre(String nombre, String descripcion,
                        TipoCafe tipoCafe, RegionCultivo region,
                        boolean esConAlcohol, double precio, Receta receta,
                        String textura, String sabor, boolean esGourmet) {
            super(nombre, descripcion, tipoCafe, region,
                esConAlcohol, precio, receta);
            this.textura = textura;
            this.sabor = sabor;
            this.esGourmet = esGourmet;
        }

        public CafePostre(String nombre, String descripcion,
                        TipoCafe tipoCafe, RegionCultivo region,
                        double precio, Receta receta,
                        String textura, String sabor, boolean esGourmet) {
            this(nombre, descripcion, tipoCafe, region,
                false, precio, receta,
                textura, sabor, esGourmet);
        }

        @Override
    public String preparar() {
        return String.format(
            "Preparando postre %s con base %s. Textura %s, sabor %s.%s",
            nombre, tipoCafe.getNombre(), textura, sabor,
            esGourmet ? " [Presentación gourmet]" : "");
    }

    public String getTextura() { return textura; }
    public String getSabor() { return sabor; }
    public boolean isGourmet() { return esGourmet; }
}
