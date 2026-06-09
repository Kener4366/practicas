import java.util.ArrayList;
public class PiezaDental {
    private  int numeroPieza;
    private ArrayList<TratamientoDental>historial;
    public PiezaDental(int numeroPieza){
        this.numeroPieza = numeroPieza;
        historial = new ArrayList<>();


    }
    public void registrarTratamiento(TratamientoDental tratamiento) {
        historial.add(tratamiento);
        System.out.println("Tratamiento registrado correctamente.");
    }

    public void agregarTratamiento(TratamientoDental tratamiento) {
        historial.add(tratamiento);
    }
    public void mostrarHistorial() {

        System.out.println("Pieza Dental: " + numeroPieza);

        if(historial.isEmpty()) {
            System.out.println("Sin tratamientos registrados");
        } else {
            for(TratamientoDental t : historial) {
                System.out.println("---------------------");
                System.out.println(t);
            }
        }
    }
    public int getNumeroPieza() {
        return numeroPieza;
    }
    public ArrayList<TratamientoDental> getHistorial() {
        return historial;
    }
}


