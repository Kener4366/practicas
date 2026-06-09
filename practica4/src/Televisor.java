public class Televisor extends Electrodomestico{

    private String resolucion;
    private String aspecto;
    private String tamano;

public Televisor(){
    super();
    resolucion = "720p";
    aspecto = "16:9";
    tamano = "21 pulgadas";
    }

    public Televisor(String marca, String modelo,
                     double precioBase, String color,
                     char consumoEnergetico, double peso,
                     String resolucion,
                     String aspecto,
                     int tamanoPantalla) {

        super(marca, modelo, precioBase, color,
                consumoEnergetico, peso);

        this.resolucion = resolucion;
        this.aspecto = aspecto;
        this.tamano = String.valueOf(tamanoPantalla);
    }


    @Override
    public void mostrarDatos() {

        super.mostrarDatos();

        System.out.println("Resolución: " + resolucion);
        System.out.println("Aspecto: " + aspecto);
        System.out.println("Tamaño: " + tamano);
    }

}



// private String marca;
//    private String modelo;
//    private float precioBase;
//    private String color;
//    private char consumoElectrico;
//    private float pesoKg;