package cafeteria;

public class RegionCultivo {

    private String nombre;
    private int altitudMsnm; // metros sobre el nivel del mar
    private String aroma;
    private String sabor;
    private String textura;
    private String torrefactor; // proceso aplicado al grano

    public RegionCultivo(String nombre, int altitudMsnm, String aroma, String sabor, String textura, String torrefactor) {
        this.nombre = nombre;
        this.altitudMsnm = altitudMsnm;
        this.aroma = aroma;
        this.sabor = sabor;
        this.textura = textura;
        this.torrefactor = torrefactor;
    }

    public RegionCultivo(String nombre, int altitudMsnm, String aroma, String sabor, String textura) {
        this(nombre, altitudMsnm, aroma, sabor, textura, "Estándar");
    }

    public String getNombre() {
        return nombre;
    }

    public int getAltitud() {
        return altitudMsnm;
    }

    public String getAroma() {
        return aroma;
    }

    public String getSabor() {
        return sabor;
    }

    public String getTextura() {
        return textura;
    }

    public String getTorrefactor() {
        return torrefactor;
    }

    @Override
    public String toString() {
        return String.format("%s (%d msnm) | Aroma: %s | Sabor: %s | Textura: %s | Tosta: %s",
                nombre, altitudMsnm, aroma, sabor, textura, torrefactor);
    }
}
