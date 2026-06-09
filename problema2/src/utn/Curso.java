package utn;

/**
 * TDA Curso
 * ═══════════════════════════════════════════════════════════════
 * Representa la materia que el docente imparte en un período
 * lectivo específico. Permite ver el rendimiento del docente
 * a lo largo del tiempo (año + período).
 * ═══════════════════════════════════════════════════════════════
 */
public class Curso {

    private final String codigo;
    private final String nombre;
    private final int    anio;
    private final String periodo;    // "I Semestre", "II Semestre", "Verano"
    private final String carrera;

    // ── Constructores (sobrecarga) ────────────────────────────────────────
    public Curso(String codigo, String nombre, int anio,
                 String periodo, String carrera) {
        this.codigo  = codigo;
        this.nombre  = nombre;
        this.anio    = anio;
        this.periodo = periodo;
        this.carrera = carrera;
    }

    public Curso(String codigo, String nombre, int anio, String periodo) {
        this(codigo, nombre, anio, periodo, "Ingeniería en Sistemas");
    }

    // ── Interfaz pública ──────────────────────────────────────────────────
    public String getCodigo()  { return codigo; }
    public String getNombre()  { return nombre; }
    public int    getAnio()    { return anio; }
    public String getPeriodo() { return periodo; }
    public String getCarrera() { return carrera; }

    /** Identificador de período lectivo para comparaciones históricas. */
    public String getPeriodoCompleto() {
        return anio + " — " + periodo;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | %s", codigo, nombre,
                             getPeriodoCompleto(), carrera);
    }
}
