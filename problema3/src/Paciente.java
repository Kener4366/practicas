public class Paciente {
    private String identificacion;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;

    private RegistroDental registroDental;

    public Paciente(String identificacion,
                    String nombre,
                    String apellidos,
                    String telefono,
                    String email) {

        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;

        registroDental = new RegistroDental();
    }
    public RegistroDental getRegistroDental() {
        return registroDental;
    }

    public String getNombre() {
        return nombre;
    }

}
