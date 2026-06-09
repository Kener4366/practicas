package utn;

/**
 * TDA Docente
 * ═══════════════════════════════════════════════════════════════
 * Representa al profesor que es sujeto de evaluación.
 * Encapsula los datos de identidad; no expone referencias mutables.
 * ═══════════════════════════════════════════════════════════════
 */
public class Docente {

    private final String cedula;
    private final String nombre;
    private final String correo;
    private final String departamento;

    // ── Constructores (sobrecarga) ────────────────────────────────────────
    public Docente(String cedula, String nombre, String correo, String departamento) {
        this.cedula       = cedula;
        this.nombre       = nombre;
        this.correo       = correo;
        this.departamento = departamento;
    }

    public Docente(String cedula, String nombre, String correo) {
        this(cedula, nombre, correo, "Sin asignar");
    }

    // ── Interfaz pública ──────────────────────────────────────────────────
    public String getCedula()       { return cedula; }
    public String getNombre()       { return nombre; }
    public String getCorreo()       { return correo; }
    public String getDepartamento() { return departamento; }

    @Override
    public String toString() {
        return String.format("Docente[%s] %s (%s)", cedula, nombre, departamento);
    }
}
