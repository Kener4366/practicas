import java.util.ArrayList;

public class RegistroDental {

    private ArrayList<PiezaDental> piezas;

    public RegistroDental() {

        piezas = new ArrayList<>();

        for (int i = 1; i <= 32; i++) {
            piezas.add(new PiezaDental(i));
        }
    }

    public PiezaDental buscarPieza(int numero) {

        for (PiezaDental pieza : piezas) {
            if (pieza.getNumeroPieza() == numero) {
                return pieza;
            }
        }

        return null;
    }

    public ArrayList<PiezaDental> getPiezas() {
        return piezas;
    }
}
