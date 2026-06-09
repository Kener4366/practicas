import java.time.LocalDateTime;
public class main {
    public static void main(String[] args) {


        Paciente paciente = new Paciente(
                "123456789",
                "Juan",
                "Perez",
                "88888888",
                "juan@gmail.com"
        );
        Dentista dentista = new Dentista(
                "D01",
                "aarona Rodríguez"
        );


        PiezaDental pieza5 = paciente.getRegistroDental().buscarPieza(10);


        TratamientoDental tratamiento = new TratamientoDental(
                LocalDateTime.now(),
                "Extracción de muela",
                "Tomar antibióticos durante 7 días"
        );


        pieza5.registrarTratamiento(tratamiento);



        for (TratamientoDental t : pieza5.getHistorial()) {

            System.out.println("Fecha: " + t.getFechaHora());
            System.out.println("Descripción: " + t.getDescripcion());
            System.out.println("Recomendación: " + t.getRecomendacion());
        }
    }
}

