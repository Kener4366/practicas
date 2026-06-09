package utn;

/**
 * TDA Pregunta (clase abstracta)
 * ═══════════════════════════════════════════════════════════════
 * Tipo de dato abstracto base de la jerarquía de preguntas.
 * Define el contrato que toda pregunta del instrumento debe cumplir.
 *
 * Principios TDA aplicados:
 *  - Abstracción: oculta el tipo concreto (abierta vs cerrada)
 *  - Operación abstracta getTipo() obliga a cada subclase a
 *    identificarse (patrón Template Method)
 *  - Los atributos son protected para permitir herencia sin
 *    romper encapsulamiento hacia el exterior
 * ═══════════════════════════════════════════════════════════════
 */
public abstract class Pregunta {

    // ── Atributos protegidos ──────────────────────────────────────────────
    protected final int       codigo;
    protected final String    enunciado;
    protected final Categoria categoria;

    // ── Constructor ───────────────────────────────────────────────────────
    public Pregunta(int codigo, String enunciado, Categoria categoria) {
        if (enunciado == null || enunciado.isBlank()) {
            throw new IllegalArgumentException("El enunciado no puede estar vacío.");
        }
        this.codigo     = codigo;
        this.enunciado  = enunciado;
        this.categoria  = categoria;
    }

    // ── Operaciones concretas ─────────────────────────────────────────────
    public int       getCodigo()    { return codigo; }
    public String    getEnunciado() { return enunciado; }
    public Categoria getCategoria() { return categoria; }

    // ── Operación abstracta (contrato del TDA) ────────────────────────────
    /** Retorna "CERRADA" o "ABIERTA" según la subclase. */
    public abstract String getTipo();

    /** Muestra la pregunta en pantalla con su formato específico. */
    public abstract void mostrar();
}
