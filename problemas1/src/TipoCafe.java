package cafeteria;

public enum TipoCafe {
    ARABICA("Arábica",   "Suave, acidez media, notas florales"),
    ROBUSTA("Robusta",   "Intenso, cuerpo fuerte, terroso"),
    GEISHA ("Geisha",    "Floral, cítrico, muy aromático"),
    BOURBON("Bourbon",   "Dulce, caramelo, equilibrado"),
    CATURRA("Caturra",   "Afrutado, acidez alta, ligero"),
    CATUAI ("Catuaí",    "Neutro, alto rendimiento, versátil");

    private final String nombre;
    private final String perfil;

    TipoCafe(String nombre, String perfil) {
        this.nombre  = nombre;
        this.perfil  = perfil;
    }

    public String getNombre()  { return nombre; }
    public String getPerfil()  { return perfil; }

    @Override
    public String toString() {
        return nombre + " [" + perfil + "]";
    }
}
