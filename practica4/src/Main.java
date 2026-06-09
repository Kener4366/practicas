import java.util.Scanner;

public class Main {
    static Televisor[] televisor = new Televisor[5];
    static Refrigerador[] refrigerador = new Refrigerador[5];

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        televisor[0] = new Televisor("Samsung", "QLED", 150000, "Negro", 'A', 10, "4K", "16:9", 55);
        televisor[1] = new Televisor("LG", "OLED", 200000, "Gris", 'B', 8, "4K", "16:9", 65);
        refrigerador[0] = new Refrigerador("Whirlpool", "FrostFree", 120000, "Blanco", 'A', 60, (byte)  3, "Vertical", 300, "Si");
        refrigerador[1] = new Refrigerador("Electrolux", "Side-by-Side", 180000, "Gris", 'B', 70, (byte)  2, "Horizontal", 250, "No");

        byte opcion = 0;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Ver Televisores");
            System.out.println("2. Ver Refrigeradoras");
            System.out.println("3. Registrar Televisor");
            System.out.println("4. Registrar Refrigeradora");
            System.out.println("5. Salir");

            opcion = sc.nextByte();

            switch(opcion) {

                case 1:
                    mostrarTelevisores();
                    break;

                case 2:
                    mostrarRefrigeradoras();
                    break;

                case 3:
                    System.out.println("Registro de TV pendiente");
                    break;

                case 4:
                    System.out.println("Registro de Refrigeradora pendiente");
                    break;

                case 5:
                    System.out.println("Fin del programa");
                    break;
            }

        } while(opcion != 5);
    }

    static void mostrarTelevisores() {
        for(Televisor tv : televisor) {
            if(tv != null) {
                System.out.println("----------------");
                tv.mostrarDatos();
            }
        }
    }

    static void mostrarRefrigeradoras() {
        for(Refrigerador r : refrigerador) {

            if(r != null) {
                System.out.println("----------------");
                r.mostrarDatos();
            }
        }
    }
}