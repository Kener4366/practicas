package utn;

/**
 * TDA TipoEscala
 * Define el tipo de escala de selección que usa una pregunta cerrada.
 * El sistema valida que los valores de las alternativas sean coherentes
 * con la escala elegida.
 *
 * Por normativa institucional UTN:
 *   ACUERDO → 4 alternativas  (Muy de acuerdo … En desacuerdo)
 *   CALIDAD → 6 alternativas  (Excelente … Muy malo)
 *   BINARIA → 2 alternativas  (Sí / No)
 */
public enum TipoEscala {

    ACUERDO     (4, 10.0, "Escala de acuerdo (4 opciones)"),
    CALIDAD     (6, 10.0, "Escala de calidad (6 opciones)"),
    BINARIA     (2, 10.0, "Escala binaria   (2 opciones)"),
    PERSONALIZADA(0, 10.0, "Escala personalizada");

    // ── Atributos privados ────────────────────────────────────────────────
    private final int    cantidadOpciones;   // 0 = sin restricción
    private final double valorMaximo;
    private final String descripcion;

    // ── Constructor ───────────────────────────────────────────────────────
    TipoEscala(int cantidadOpciones, double valorMaximo, String descripcion) {
        this.cantidadOpciones = cantidadOpciones;
        this.valorMaximo      = valorMaximo;
        this.descripcion      = descripcion;
    }

    // ── Interfaz pública (TDA) ────────────────────────────────────────────
    public int    getCantidadOpciones() { return cantidadOpciones; }
    public double getValorMaximo()      { return valorMaximo; }
    public String getDescripcion()      { return descripcion; }

    /**
     * Valida que un valor propuesto esté dentro del rango permitido [0, valorMaximo].
     * Requerimiento 3: las preguntas cerradas no pueden tener valores
     * fuera de la escala permitida.
     */
    public boolean esValorValido(double valor) {
        return valor >= 0.0 && valor <= valorMaximo;
    }

    @Override
    public String toString() { return descripcion; }
}
