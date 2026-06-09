package utn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TDA Instrumento
 * ═══════════════════════════════════════════════════════════════
 * Requerimiento 4: clase que simula el DOCUMENTO de evaluación
 * docente. Agrega preguntas de ambos tipos y provee operaciones
 * para consultar su estructura y calcular el puntaje máximo posible.
 *
 * Relación de agregación con Pregunta:
 *   el instrumento REFERENCIA preguntas que pueden existir de forma
 *   independiente (a diferencia de la composición en PreguntaCerrada).
 *
 * Principios TDA:
 *  - Los detalles de almacenamiento (ArrayList) son invisibles desde
 *    el exterior; se exponen sólo vistas inmutables.
 *  - Las operaciones de consulta nunca exponen el estado interno mutable.
 * ═══════════════════════════════════════════════════════════════
 */
public class Instrumento {

    // ── Atributos privados ────────────────────────────────────────────────
    private final int    codigo;
    private final String titulo;
    private final String descripcion;
    private final List<Pregunta> preguntas;

    // ── Constructor ───────────────────────────────────────────────────────
    public Instrumento(int codigo, String titulo, String descripcion) {
        this.codigo      = codigo;
        this.titulo      = titulo;
        this.descripcion = descripcion;
        this.preguntas   = new ArrayList<>();
    }

    // ── Operación de construcción ─────────────────────────────────────────
    /**
     * Agrega una pregunta (cerrada o abierta) al instrumento.
     * No se admiten códigos duplicados.
     */
    public void agregarPregunta(Pregunta pregunta) {
        boolean duplicado = preguntas.stream()
            .anyMatch(p -> p.getCodigo() == pregunta.getCodigo());
        if (duplicado) {
            throw new IllegalArgumentException(
                "Ya existe una pregunta con código " + pregunta.getCodigo());
        }
        preguntas.add(pregunta);
    }

    // ── Operaciones de consulta (TDA) ─────────────────────────────────────

    /** Lista inmutable de TODAS las preguntas del instrumento. */
    public List<Pregunta> getPreguntas() { return List.copyOf(preguntas); }

    /** Sólo las preguntas cerradas (las que aportan a la nota). */
    public List<PreguntaCerrada> getPreguntasCerradas() {
        return preguntas.stream()
            .filter(p -> p instanceof PreguntaCerrada)
            .map(p -> (PreguntaCerrada) p)
            .collect(Collectors.toList());
    }

    /** Sólo las preguntas abiertas. */
    public List<PreguntaAbierta> getPreguntasAbiertas() {
        return preguntas.stream()
            .filter(p -> p instanceof PreguntaAbierta)
            .map(p -> (PreguntaAbierta) p)
            .collect(Collectors.toList());
    }

    /** Suma de los valores máximos de todas las preguntas cerradas. */
    public double calcularPuntajeMaximo() {
        return getPreguntasCerradas().stream()
            .mapToDouble(PreguntaCerrada::getValorMaximo)
            .sum();
    }

    /** Busca una pregunta cerrada por su código. Retorna null si no existe. */
    public PreguntaCerrada buscarCerrada(int codigo) {
        return getPreguntasCerradas().stream()
            .filter(p -> p.getCodigo() == codigo)
            .findFirst()
            .orElse(null);
    }

    public int    getCodigo()      { return codigo; }
    public String getTitulo()      { return titulo; }
    public String getDescripcion() { return descripcion; }
    public int    cantPreguntas()  { return preguntas.size(); }

    // ── Operación de visualización ────────────────────────────────────────
    public void mostrarInstrumento() {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.printf ("║  INSTRUMENTO #%d: %-32s║%n", codigo, titulo);
        System.out.println("║  " + descripcion);
        System.out.printf ("║  Total preguntas: %d  |  Puntaje máximo: %.1f%n",
            preguntas.size(), calcularPuntajeMaximo());
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("  [PREGUNTAS CERRADAS]");
        getPreguntasCerradas().forEach(Pregunta::mostrar);
        System.out.println("  [PREGUNTAS ABIERTAS]");
        getPreguntasAbiertas().forEach(Pregunta::mostrar);
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
}
