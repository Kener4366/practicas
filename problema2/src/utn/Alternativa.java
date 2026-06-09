package utn;

/**
 * TDA Alternativa
 * ═══════════════════════════════════════════════════════════════
 * Representa una opción de selección dentro de una pregunta cerrada.
 * Cada alternativa almacena su texto visible y su VALOR PUNTUAL,
 * que es el que se usa para calcular la nota final del docente.
 *
 * Principios TDA aplicados:
 *  - Encapsulamiento total (todos los campos privados)
 *  - Interfaz mínima y suficiente
 *  - Inmutabilidad (valor fijado en construcción, sin setter)
 * ═══════════════════════════════════════════════════════════════
 */
public class Alternativa {

    // ── Atributos privados (encapsulamiento TDA) ──────────────────────────
    private final String texto;    // etiqueta visible al estudiante
    private final double valor;    // puntaje que aporta a la nota del docente

    // ── Constructor ───────────────────────────────────────────────────────
    /**
     * @param texto  Texto de la alternativa (ej: "Muy de acuerdo")
     * @param valor  Valor numérico en escala [0..10]
     *               La validación del rango la realiza PreguntaCerrada.
     */
    public Alternativa(String texto, double valor) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("El texto de la alternativa no puede estar vacío.");
        }
        this.texto = texto;
        this.valor = valor;
    }

    // ── Interfaz pública (TDA: sólo lo necesario) ─────────────────────────
    public String getTexto() { return texto; }
    public double getValor() { return valor; }

    @Override
    public String toString() {
        return String.format("[ ] %-20s  (valor: %.1f)", texto, valor);
    }
}
