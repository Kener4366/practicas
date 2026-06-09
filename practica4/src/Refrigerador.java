public class Refrigerador extends Electrodomestico{

    private byte cantPuertas;
    private String diseno;
    private int capacidadlitros;
    private String congelador;

    public Refrigerador(){
        super();
        cantPuertas = 1;
        diseno = "Vertical";
        capacidadlitros = 150;
        congelador = "Si";
    }

    public Refrigerador(String marca, String modelo,
                      double precioBase, String color,
                      char consumoEnergetico, double peso,
                      byte cantPuertas,
                      String diseno,
                      int capacidadlitros,
                      String congelador) {

        super(marca, modelo, precioBase, color,
                consumoEnergetico, peso);

        this.cantPuertas = cantPuertas;
        this.diseno = diseno;
        this.capacidadlitros = capacidadlitros;
        this.congelador = congelador;
    }

    @Override
    public void mostrarDatos() {

        super.mostrarDatos();

        System.out.println("Cantidad de Puertas: " + cantPuertas);
        System.out.println("Diseño: " + diseno);
        System.out.println("Capacidad en Litros: " + capacidadlitros);
        System.out.println("Congelador: " + congelador);
    }


}
