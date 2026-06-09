package utn;

/**
 * ════════════════════════════════════════════════════════════════════
 *  SistemaEvaluacionApp — Aplicación principal UTN
 * ════════════════════════════════════════════════════════════════════
 *
 * Requerimiento 5: conjunto de datos de prueba que demuestra que
 *   la estructura cumple todos los requerimientos.
 *
 * Requerimiento 6: salida con nombre del profesor, materia evaluada
 *   y rendimiento de por lo menos dos preguntas cerradas.
 */
public class SistemaEvaluacionApp {

    public static void main(String[] args) {

        separador("SISTEMA DE EVALUACIÓN DOCENTE — UTN");

        // ════════════════════════════════════════════════════════════
        //  1. Crear el instrumento de evaluación
        // ════════════════════════════════════════════════════════════
        Instrumento instrumento = new Instrumento(
            1,
            "Evaluación Docente General 2025",
            "Instrumento aplicado a toda la población estudiantil por período."
        );

        // ── Pregunta cerrada 1: Escala ACUERDO (4 opciones) ──────────────
        PreguntaCerrada p1 = new PreguntaCerrada(
            1,
            "El docente explica los temas con claridad",
            Categoria.PEDAGOGICO,
            TipoEscala.ACUERDO
        );
        p1.agregarAlternativa("Muy de acuerdo",   10.0);
        p1.agregarAlternativa("De acuerdo",         7.5);
        p1.agregarAlternativa("Poco de acuerdo",    5.0);
        p1.agregarAlternativa("En desacuerdo",       0.0);

        // ── Pregunta cerrada 2: Escala CALIDAD (6 opciones) ──────────────
        PreguntaCerrada p2 = new PreguntaCerrada(
            2,
            "Valore el dominio del contenido del docente",
            Categoria.PROFESIONAL,
            TipoEscala.CALIDAD
        );
        p2.agregarAlternativa("Excelente",  10.0);
        p2.agregarAlternativa("Muy Bueno",   8.0);
        p2.agregarAlternativa("Bueno",       6.0);
        p2.agregarAlternativa("Regular",     4.0);
        p2.agregarAlternativa("Malo",        2.0);
        p2.agregarAlternativa("Muy malo",    0.0);

        // ── Pregunta cerrada 3: Escala BINARIA (Sí/No) ───────────────────
        PreguntaCerrada p3 = new PreguntaCerrada(
            3,
            "El docente cumple con el horario de la clase",
            Categoria.PERSONAL,
            TipoEscala.BINARIA
        );
        p3.agregarAlternativa("Sí.", 10.0);
        p3.agregarAlternativa("No.",  0.0);

        // ── Pregunta cerrada 4: Aspectos intelectuales ───────────────────
        PreguntaCerrada p4 = new PreguntaCerrada(
            4,
            "El docente fomenta el pensamiento crítico",
            Categoria.INTELECTUAL,
            TipoEscala.ACUERDO
        );
        p4.agregarAlternativa("Muy de acuerdo",   10.0);
        p4.agregarAlternativa("De acuerdo",         7.5);
        p4.agregarAlternativa("Poco de acuerdo",    5.0);
        p4.agregarAlternativa("En desacuerdo",       0.0);

        // ── Pregunta abierta 5 ────────────────────────────────────────────
        PreguntaAbierta p5 = new PreguntaAbierta(
            5,
            "Indique aspectos positivos y áreas de mejora del docente",
            Categoria.GENERAL,
            400
        );

        // Agregar todas al instrumento
        instrumento.agregarPregunta(p1);
        instrumento.agregarPregunta(p2);
        instrumento.agregarPregunta(p3);
        instrumento.agregarPregunta(p4);
        instrumento.agregarPregunta(p5);

        // ── Mostrar el instrumento ─────────────────────────────────────────
        System.out.println("\n>>> INSTRUMENTO CONSTRUIDO:\n");
        instrumento.mostrarInstrumento();

        // ════════════════════════════════════════════════════════════
        //  2. Demostrar validación de escala (Requerimiento 3)
        // ════════════════════════════════════════════════════════════
        separador("DEMOSTRACIÓN DE VALIDACIÓN DE ESCALA (REQ. 3)");

        try {
            PreguntaCerrada pInvalida = new PreguntaCerrada(
                99, "Prueba inválida", Categoria.GENERAL, TipoEscala.ACUERDO);
            pInvalida.agregarAlternativa("Opción fuera de rango", 15.0); // DEBE fallar
            System.out.println("ERROR: No se lanzó excepción (fallo del sistema)");
        } catch (IllegalArgumentException e) {
            System.out.println("  Validacion OK: " + e.getMessage());
        }

        try {
            PreguntaCerrada pExceso = new PreguntaCerrada(
                98, "Prueba exceso", Categoria.GENERAL, TipoEscala.BINARIA);
            pExceso.agregarAlternativa("Sí.",  10.0);
            pExceso.agregarAlternativa("No.",   0.0);
            pExceso.agregarAlternativa("Tal vez", 5.0); // excede 2 opciones → DEBE fallar
            System.out.println("ERROR: No se lanzó excepción");
        } catch (IllegalArgumentException e) {
            System.out.println("  Validacion OK: " + e.getMessage());
        }

        // ════════════════════════════════════════════════════════════
        //  3. Docentes y cursos de prueba
        // ════════════════════════════════════════════════════════════
        separador("EVALUACIONES APLICADAS");

        // Docente 1
        Docente docente1 = new Docente(
            "1-1234-5678",
            "Dr. Marco Vargas Solano",
            "mvargas@utn.ac.cr",
            "Computación e Informática"
        );
        Curso curso1 = new Curso(
            "IC-1101",
            "Programación Orientada a Objetos",
            2025,
            "I Semestre",
            "Ingeniería en Computación"
        );

        // Docente 2
        Docente docente2 = new Docente(
            "2-9876-5432",
            "MSc. Adriana Rojas Mora",
            "arojas@utn.ac.cr",
            "Ciencias Básicas"
        );
        Curso curso2 = new Curso(
            "MA-0101",
            "Cálculo Diferencial e Integral",
            2025,
            "I Semestre"
        );

        // ════════════════════════════════════════════════════════════
        //  4. Evaluación 1 — Dr. Vargas (rendimiento bueno)
        // ════════════════════════════════════════════════════════════
        EvaluacionDocente eval1 = new EvaluacionDocente(
            instrumento, docente1, curso1, "15/05/2025");

        // Respuestas del estudiante (índice 0-based de la alternativa):
        eval1.registrarRespuesta(1, 0);  // P1: "Muy de acuerdo"  → 10.0
        eval1.registrarRespuesta(2, 1);  // P2: "Muy Bueno"       →  8.0
        eval1.registrarRespuesta(3, 0);  // P3: "Sí."             → 10.0
        eval1.registrarRespuesta(4, 1);  // P4: "De acuerdo"      →  7.5

        p5.setRespuesta("Excelente manejo del tema, con ejemplos prácticos. " +
                        "Podría mejorar la puntualidad en la devolución de trabajos.");

        eval1.generarReporte();

        // ════════════════════════════════════════════════════════════
        //  5. Evaluación 2 — MSc. Rojas (rendimiento regular)
        // ════════════════════════════════════════════════════════════
        PreguntaAbierta p5b = new PreguntaAbierta(
            5, "Indique aspectos positivos y áreas de mejora del docente",
            Categoria.GENERAL);
        p5b.setRespuesta("Las clases son un poco rápidas. Se recomienda más práctica.");

        EvaluacionDocente eval2 = new EvaluacionDocente(
            instrumento, docente2, curso2, "16/05/2025");

        eval2.registrarRespuesta(1, 2);  // P1: "Poco de acuerdo"  → 5.0
        eval2.registrarRespuesta(2, 3);  // P2: "Regular"          → 4.0
        eval2.registrarRespuesta(3, 0);  // P3: "Sí."              → 10.0
        eval2.registrarRespuesta(4, 2);  // P4: "Poco de acuerdo"  → 5.0

        eval2.generarReporte();

        // ════════════════════════════════════════════════════════════
        //  6. Comparación rápida de dos preguntas (Req. 6 explícito)
        // ════════════════════════════════════════════════════════════
        separador("COMPARACIÓN DE RENDIMIENTO POR PREGUNTA (REQ. 6)");

        System.out.printf("%-40s %12s %12s%n",
            "Pregunta", docente1.getNombre().split(" ")[1],
            docente2.getNombre().split(" ")[1]);
        System.out.println("-".repeat(66));

        int[] preguntasAComparar = {1, 2};
        for (int cod : preguntasAComparar) {
            PreguntaCerrada pc = instrumento.buscarCerrada(cod);
            System.out.printf("P%d: %-37s %10.1f%%  %10.1f%%%n",
                cod,
                truncar(pc.getEnunciado(), 37),
                eval1.getRendimientoPregunta(cod),
                eval2.getRendimientoPregunta(cod));
        }

        System.out.println("-".repeat(66));
        System.out.printf("%-40s %10.2f%%  %10.2f%%%n",
            "NOTA FINAL",
            eval1.calcularNota(),
            eval2.calcularNota());
        System.out.println();
    }

    // ── Auxiliares de salida ──────────────────────────────────────────────
    private static void separador(String titulo) {
        System.out.println("\n" + "=".repeat(62));
        System.out.println("  " + titulo);
        System.out.println("=".repeat(62));
    }

    private static String truncar(String s, int max) {
        return s.length() <= max ? s : s.substring(0, max - 1) + "…";
    }
}
