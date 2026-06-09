package utn;

/**
 * TDA PreguntaAbierta
 * ═══════════════════════════════════════════════════════════════
 * Pregunta de respuesta libre. Por normativa UTN no aplica
 * valoración cuantitativa y se usa para capturar comentarios
 * y resúmenes cualitativos sobre el docente.
 *
 * Decisión de diseño TDA:
 *  - No posee alternativas ni escala (simplificación coherente)
 *  - La respuesta puede ser modificada (es dinámica, a diferencia
 *    del enunciado que es inmutable)
 *  - getTipo() retorna "ABIERTA" para que Instrumento pueda
 *    distinguir los dos tipos sin downcasting
 * ═══════════════════════════════════════════════════════════════
 */
public class PreguntaAbierta extends Pregunta {

    // ── Atributos privados ────────────────────────────────────────────────
    private String respuesta;
    private final int longMaxima;   // caracteres máximos permitidos

    // ── Constructores (sobrecarga) ────────────────────────────────────────
    public PreguntaAbierta(int codigo, String enunciado,
                           Categoria categoria, int longMaxima) {
        super(codigo, enunciado, categoria);
        this.longMaxima = longMaxima;
        this.respuesta  = "";
    }

    /** Longitud máxima por defecto: 500 caracteres. */
    public PreguntaAbierta(int codigo, String enunciado, Categoria categoria) {
        this(codigo, enunciado, categoria, 500);
    }

    // ── Operaciones de escritura con validación ───────────────────────────
    public void setRespuesta(String respuesta) {
        if (respuesta == null) respuesta = "";
        if (respuesta.length() > longMaxima) {
            throw new IllegalArgumentException(
                String.format("La respuesta supera el límite de %d caracteres.", longMaxima));
        }
        this.respuesta = respuesta;
    }

    // ── Interfaz pública (TDA) ────────────────────────────────────────────
    public String getRespuesta()  { return respuesta; }
    public int    getLongMaxima() { return longMaxima; }
    public boolean tieneRespuesta() { return !respuesta.isBlank(); }

    @Override
    public String getTipo() { return "ABIERTA"; }

    @Override
    public void mostrar() {
        System.out.printf("  [%d] %s  (%s | ABIERTA — no cuantitativa)%n",
            codigo, enunciado, categoria.getEtiqueta());
        System.out.printf("       Respuesta: %s%n",
            respuesta.isBlank() ? "(sin respuesta)" : respuesta);
    }
}
