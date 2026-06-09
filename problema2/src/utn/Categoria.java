package utn;

/**
 * TDA Categoria
 * Enumeración de las categorías que puede tener una pregunta
 * dentro del instrumento de evaluación docente.
 */
public enum Categoria {

    PERSONAL    ("Aspectos Personales",     "Actitud, puntualidad, comunicación"),
    PROFESIONAL ("Aspectos Profesionales",  "Dominio del tema, experiencia"),
    INTELECTUAL ("Aspectos Intelectuales",  "Capacidad analítica, metodología"),
    PEDAGOGICO  ("Aspectos Pedagógicos",    "Didáctica, materiales, evaluación"),
    GENERAL     ("Aspectos Generales",      "Otros aspectos del desempeño");

    // ── Atributos privados ────────────────────────────────────────────────
    private final String etiqueta;
    private final String descripcion;

    // ── Constructor ───────────────────────────────────────────────────────
    Categoria(String etiqueta, String descripcion) {
        this.etiqueta    = etiqueta;
        this.descripcion = descripcion;
    }

    // ── Interfaz pública (TDA) ────────────────────────────────────────────
    public String getEtiqueta()    { return etiqueta; }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return etiqueta + " — " + descripcion;
    }
}
