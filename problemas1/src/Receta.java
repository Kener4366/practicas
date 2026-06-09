package cafeteria;

import java.util.ArrayList;
import java.util.List;

public class Receta {

    private String            nombre;
    private List<Ingrediente> ingredientes;
    private String            instrucciones;
    private int               tiempoMinutos;

    public Receta(String nombre, String instrucciones, int tiempoMinutos) {
        this.nombre = nombre;
        this.instrucciones = instrucciones;
        this.tiempoMinutos = tiempoMinutos;
        this.ingredientes  = new ArrayList<>();
    }
    public Receta(String nombre, String instrucciones) {
        this(nombre, instrucciones, 5);
    }

    public void agregarIngrediente(cafeteria.Ingrediente i) {
        ingredientes.add(i);
    }
    public void mostrar() {
        System.out.println("====================================");
        System.out.println("  RECETA: " + nombre.toUpperCase());
        System.out.println("  Tiempo estimado: " + tiempoMinutos + " min");
        System.out.println("──────────────────────────────────");
        System.out.println("  INGREDIENTES:");
        for (Ingrediente ing : ingredientes) {
            System.out.println(ing);
        }
        System.out.println("──────────────────────────────────");
        System.out.println("  PREPARACIÓN:");
        System.out.println("  " + instrucciones);
        System.out.println("====================================");
    }
     public String getNombre()       { return nombre; }
     public List<Ingrediente> getIngredientes() { return ingredientes; }
     public String getInstrucciones(){ return instrucciones; }
     public int getTiempo()       { return tiempoMinutos; }


    @Override    public String toString() {
        return String.format("Receta: %s (%d min)", nombre, tiempoMinutos);
    }


}

