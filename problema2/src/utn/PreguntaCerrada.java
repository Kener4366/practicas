package utn;

import java.util.ArrayList;
import java.util.List;

/**
 * TDA PreguntaCerrada
 * ═══════════════════════════════════════════════════════════════
 * Pregunta de selección única con alternativas de valor puntual.
 * Implementa la normativa UTN para los tres tipos de escala:
 *
 *   Ejemplo 1 — ACUERDO (4 opciones):
 *     [ ] Muy de acuerdo  [ ] De acuerdo
 *     [ ] Poco de acuerdo [ ] En desacuerdo
 *
 *   Ejemplo 2 — CALIDAD (6 opciones):
 *     [ ] Excelente  [ ] Muy Bueno  [ ] Bueno
 *     [ ] Regular    [ ] Malo       [ ] Muy malo
 *
 *   Ejemplo 3 — BINARIA (2 opciones):
 *     [ ] Sí.  [ ] No.
 *
 * Requerimiento 3:  los valores de cada alternativa son validados
 * contra la escala antes de ser aceptados (excepción si invalido).
 *
 * Composición: PreguntaCerrada POSEE sus Alternativas.
 * ═══════════════════════════════════════════════════════════════
 */
public class PreguntaCerrada extends Pregunta {

    // ── Atributos privados ────────────────────────────────────────────────
    private final List<Alternativa> alternativas;
    private final TipoEscala        escala;

    // ── Constructor ───────────────────────────────────────────────────────
    public PreguntaCerrada(int codigo, String enunciado,
                           Categoria categoria, TipoEscala escala) {
        super(codigo, enunciado, categoria);
        this.escala       = escala;
        this.alternativas = new ArrayList<>();
    }

    // ── Operación de construcción con validación (Requerimiento 3) ────────
    /**
     * Agrega una alternativa validando que su valor esté dentro de la
     * escala permitida [0..valorMax].
     *
     * @throws IllegalArgumentException si el valor está fuera del rango
     *         o si la escala ya tiene el número máximo de opciones.
     */
    public void agregarAlternativa(String texto, double valor) {

        // Validar rango numérico
        if (!escala.esValorValido(valor)) {
            throw new IllegalArgumentException(
                String.format(
                    "Valor %.1f inválido para la escala %s (rango 0..%.1f).",
                    valor, escala.getDescripcion(), escala.getValorMaximo()));
        }

        // Validar cantidad de opciones (si la escala es fija)
        int maxOpc = escala.getCantidadOpciones();
        if (maxOpc > 0 && alternativas.size() >= maxOpc) {
            throw new IllegalArgumentException(
                String.format(
                    "La escala %s solo admite %d alternativas.",
                    escala.getDescripcion(), maxOpc));
        }

        alternativas.add(new Alternativa(texto, valor));
    }

    // ── Consulta de valor máximo posible ─────────────────────────────────
    /**
     * Retorna el valor de la alternativa con mayor puntaje.
     * Usado por Instrumento para calcular el puntaje máximo total.
     */
    public double getValorMaximo() {
        return alternativas.stream()
                           .mapToDouble(Alternativa::getValor)
                           .max()
                           .orElse(0.0);
    }

    /**
     * Retorna el valor de una alternativa específica según su índice (0-based).
     * Usado por EvaluacionDocente para registrar la respuesta elegida.
     */
    public double getValorAlternativa(int indice) {
        if (indice < 0 || indice >= alternativas.size()) {
            throw new IndexOutOfBoundsException(
                "Índice de alternativa inválido: " + indice);
        }
        return alternativas.get(indice).getValor();
    }

    // ── Interfaz pública (TDA) ────────────────────────────────────────────
    public TipoEscala        getEscala()       { return escala; }
    public List<Alternativa> getAlternativas() { return List.copyOf(alternativas); }
    public int               cantAlternativas(){ return alternativas.size(); }

    @Override
    public String getTipo() { return "CERRADA"; }

    @Override
    public void mostrar() {
        System.out.printf("  [%d] %s  (%s | %s)%n",
            codigo, enunciado, categoria.getEtiqueta(), escala.getDescripcion());
        for (int i = 0; i < alternativas.size(); i++) {
            System.out.printf("       %d) %s%n", i + 1, alternativas.get(i));
        }
    }
}
