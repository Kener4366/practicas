
public class Electrodomestico {

    private String marca;
    private String modelo;
    private double precioBase;
    private String color;
    private char consumoElectrico;
    private double pesoKg;

    public Electrodomestico() {
        marca = "";
        modelo = "";
        precioBase = 0;
        color = "";
        consumoElectrico = 'F';
        pesoKg = 1;
    }

public Electrodomestico(String marca, String modelo, double precioBase, String color, char consumoElectrico, double pesoKg){
    this.consumoElectrico = consumoElectrico;
    this.pesoKg = pesoKg;
    this.marca = marca;
    this.modelo = modelo;
    this.precioBase = precioBase;
    this.color = color;
    }


    public double calcularPrecioFinal() {

        double aumento = 0;

        switch(consumoElectrico) {
            case 'A': aumento += 61500; break;
            case 'B': aumento += 49200; break;
            case 'C': aumento += 36900; break;
            case 'D': aumento += 30750; break;
            case 'E': aumento += 18450; break;
            default: aumento += 6150;
        }

        if(pesoKg <= 19)
            aumento += 6150;
        else if(pesoKg <= 49)
            aumento += 30750;
        else if(pesoKg <= 79)
            aumento += 49200;
        else
            aumento += 61500;

        return precioBase + aumento;
    }
    public void mostrarDatos() {

        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Precio Base: " + precioBase);
        System.out.println("Color: " + color);
        System.out.println("Consumo Energético: " + consumoElectrico);
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Precio Final: " + calcularPrecioFinal());
    }

}


