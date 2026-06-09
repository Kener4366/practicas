package utn;

import java.util.HashMap;
import java.util.Map;

/**
 * TDA EvaluacionDocente
 * ═══════════════════════════════════════════════════════════════
 * Requerimiento 4: clase principal que SIMULA el documento de
 * evaluación docente aplicado por los estudiantes.
 *
 * Responsabilidades:
 *  1. Asociar un Instrumento a un Docente y un Curso.
 *  2. Registrar las respuestas de los estudiantes (valor puntual
 *     de la alternativa elegida para cada pregunta cerrada).
 *  3. Calcular la nota final normalizada a escala 0–100.
 *  4. Generar el reporte de rendimiento (Requerimiento 6).
 *
 * Principios TDA:
 *  - El Map de respuestas es opaco; sólo se accede vía operaciones.
 *  - calcularNota() nunca lanza excepción; retorna 0 si no hay datos.
 *  - Las preguntas abiertas NO afectan el cálculo cuantitativo.
 * ═══════════════════════════════════════════════════════════════
 */
public class EvaluacionDocente {

    // ── Atributos privados ────────────────────────────────────────────────
    private final Instrumento instrumento;
    private final Docente     docente;
    private final Curso       curso;
    private final String      fecha;

    /**
     * Mapa: código de pregunta cerrada → valor puntual de la alternativa elegida.
     * Una sola evaluación representa UN estudiante respondiendo UNA vez.
     */
    private final Map<Integer, Double> respuestas;

    // ── Constructor ───────────────────────────────────────────────────────
    public EvaluacionDocente(Instrumento instrumento,
                             Docente     docente,
                             Curso       curso,
                             String      fecha) {
        this.instrumento = instrumento;
        this.docente     = docente;
        this.curso       = curso;
        this.fecha       = fecha;
        this.respuestas  = new HashMap<>();
    }

    // ── Operación de registro de respuesta ───────────────────────────────
    /**
     * Registra la respuesta de un estudiante para una pregunta cerrada.
     *
     * @param codigoPregunta  Código de la PreguntaCerrada en el instrumento.
     * @param indiceAlternativa  Índice 0-based de la alternativa elegida.
     * @throws IllegalArgumentException si la pregunta no existe o el índice es inválido.
     */
    public void registrarRespuesta(int codigoPregunta, int indiceAlternativa) {
        PreguntaCerrada pc = instrumento.buscarCerrada(codigoPregunta);
        if (pc == null) {
            throw new IllegalArgumentException(
                "No existe pregunta cerrada con código " + codigoPregunta);
        }
        double valor = pc.getValorAlternativa(indiceAlternativa);
        respuestas.put(codigoPregunta, valor);
    }

    // ── Operación de cálculo de nota ──────────────────────────────────────
    /**
     * Calcula la nota del docente normalizada a escala 0–100.
     * Solo considera preguntas cerradas respondidas.
     * Formula: (suma de valores elegidos / puntaje máximo posible) × 100
     */
    public double calcularNota() {
        double puntajeMax = instrumento.calcularPuntajeMaximo();
        if (puntajeMax == 0) return 0.0;

        double sumaObtenida = respuestas.values()
                                        .stream()
                                        .mapToDouble(Double::doubleValue)
                                        .sum();
        return (sumaObtenida / puntajeMax) * 100.0;
    }

    // ── Consulta de rendimiento por pregunta (Requerimiento 6) ───────────
    /**
     * Retorna el rendimiento porcentual obtenido en UNA pregunta cerrada.
     * (valor elegido / valor máximo de esa pregunta) × 100
     */
    public double getRendimientoPregunta(int codigoPregunta) {
        PreguntaCerrada pc = instrumento.buscarCerrada(codigoPregunta);
        if (pc == null || !respuestas.containsKey(codigoPregunta)) return 0.0;

        double valorElegido = respuestas.get(codigoPregunta);
        double valorMax     = pc.getValorMaximo();
        return valorMax == 0 ? 0.0 : (valorElegido / valorMax) * 100.0;
    }

    /**
     * Retorna el valor puntual registrado para una pregunta cerrada.
     */
    public double getValorRespuesta(int codigoPregunta) {
        return respuestas.getOrDefault(codigoPregunta, 0.0);
    }

    // ── Operación de visualización (Requerimiento 6) ──────────────────────
    /**
     * Genera el reporte completo de la evaluación:
     *  - Nombre del profesor
     *  - Nombre de la materia evaluada
     *  - Rendimiento de al menos dos preguntas cerradas
     *  - Nota final
     */
    public void generarReporte() {
        double nota = calcularNota();
        String calificacion = clasificarNota(nota);

        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║         REPORTE DE EVALUACIÓN DOCENTE — UTN              ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.printf ("║  Profesor  : %-44s║%n", docente.getNombre());
        System.out.printf ("║  Materia   : %-44s║%n", curso.getNombre());
        System.out.printf ("║  Período   : %-44s║%n", curso.getPeriodoCompleto());
        System.out.printf ("║  Fecha     : %-44s║%n", fecha);
        System.out.printf ("║  Instrumento: %-43s║%n", instrumento.getTitulo());
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║  RENDIMIENTO POR PREGUNTA CERRADA                        ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");

        for (PreguntaCerrada pc : instrumento.getPreguntasCerradas()) {
            int    cod        = pc.getCodigo();
            double valObtenido = respuestas.getOrDefault(cod, -1.0);
            double valMax      = pc.getValorMaximo();
            double rendimiento = getRendimientoPregunta(cod);

            if (valObtenido < 0) {
                System.out.printf("║  [%2d] %-30s Sin respuesta         ║%n",
                    cod, truncar(pc.getEnunciado(), 30));
            } else {
                System.out.printf("║  [%2d] %-30s %4.1f / %4.1f  (%5.1f%%)  ║%n",
                    cod, truncar(pc.getEnunciado(), 30),
                    valObtenido, valMax, rendimiento);
            }
        }

        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.printf ("║  NOTA FINAL: %5.2f / 100   →  %-27s║%n",
            nota, calificacion);
        System.out.println("╠══════════════════════════════════════════════════════════╣");

        // Respuestas abiertas
        boolean tieneAbiertas = instrumento.getPreguntasAbiertas()
                                           .stream()
                                           .anyMatch(PreguntaAbierta::tieneRespuesta);
        if (tieneAbiertas) {
            System.out.println("║  COMENTARIOS CUALITATIVOS (no cuantitativos)             ║");
            System.out.println("╠══════════════════════════════════════════════════════════╣");
            for (PreguntaAbierta pa : instrumento.getPreguntasAbiertas()) {
                if (pa.tieneRespuesta()) {
                    System.out.printf("║  P%d: %s%n", pa.getCodigo(), pa.getRespuesta());
                }
            }
        }

        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }

    // ── Auxiliares privados ───────────────────────────────────────────────
    private String clasificarNota(double nota) {
        if (nota >= 90) return "EXCELENTE";
        if (nota >= 80) return "MUY BUENO";
        if (nota >= 70) return "BUENO";
        if (nota >= 60) return "REGULAR";
        if (nota >= 50) return "NECESITA MEJORA";
        return "INSUFICIENTE";
    }

    private String truncar(String s, int max) {
        return s.length() <= max ? s : s.substring(0, max - 1) + "…";
    }

    // ── Getters ───────────────────────────────────────────────────────────
    public Instrumento getInstrumento() { return instrumento; }
    public Docente     getDocente()     { return docente; }
    public Curso       getCurso()       { return curso; }
    public String      getFecha()       { return fecha; }
}
