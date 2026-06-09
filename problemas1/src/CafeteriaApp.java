package cafeteria;;

public class CafeteriaApp {
    public static cafeteria.CafeBebida crearProducto1() {
      cafeteria.RegionCultivo Terrazu = new cafeteria.RegionCultivo(
              "Terrazú", 1800,
              "Intenso a chocolate y nuez",
              "Acidez brillante, cuerpo pleno",
              "Aterciopelado",
              "Tostado medio-oscuro artesanal"
      );

        cafeteria.Receta receta = new cafeteria.Receta(
                "Cappuccino Geisha Terrazú",
                "Extraer doble espresso en 25 seg. Vaporizar leche a 60 °C. " +
                        "Verter en movimiento circular. Decorar con cacao.",
                7
        );
        receta.agregarIngrediente(new cafeteria.Ingrediente("Café Geisha Tarrazú molido", 18.0, "g"));
        receta.agregarIngrediente(new cafeteria.Ingrediente("Agua filtrada",              60.0, "ml"));
        receta.agregarIngrediente(new cafeteria.Ingrediente("Leche entera",              120.0, "ml"));
        receta.agregarIngrediente(new cafeteria.Ingrediente("Cacao en polvo",              2.0, "g"));

        return new cafeteria.CafeBebida(
                "Cappuccino Geisha Tarrazú",
                "Espresso doble con leche vaporizada y cacao",
                cafeteria.TipoCafe.GEISHA,
                Terrazu,
                false, 3800.0, receta,
                "caliente", "mediano", false
        );


    }

    public static cafeteria.CafePostre crearProducto2() {
        cafeteria.RegionCultivo naranjo = new cafeteria.RegionCultivo(
                "Naranjo", 1400,
                "Frutal, notas de miel",
                "Dulce y equilibrado",
                "Suave"
        );

        cafeteria.Receta receta = new cafeteria.Receta(
                "Tiramisú de Bourbon Naranjo",
                "Mezclar café con licor. Bañar bizcochos. Alternar capas con crema de mascarpone. Refrigerar 4 horas.",
                5
        );
        receta.agregarIngrediente(new cafeteria.Ingrediente("Café Bourbon Naranjo molido", 20.0, "g"));
        receta.agregarIngrediente(new cafeteria.Ingrediente("Licor Amaretto",              30.0, "ml"));
        receta.agregarIngrediente(new cafeteria.Ingrediente("Bizcochos de soletilla",      100.0, "g"));
        receta.agregarIngrediente(new cafeteria.Ingrediente("Mascarpone",                 150.0, "g"));
        receta.agregarIngrediente(new cafeteria.Ingrediente("Azúcar",                     20.0, "g"));

        return new cafeteria.CafePostre(
                "Tiramisú de Bourbon Naranjo",
                "Postre frío con café infusionado en licor y crema de mascarpone",
                cafeteria.TipoCafe.BOURBON,
                naranjo,
                false, 4500.0, receta,
                "cremoso", "dulce", true
        );
    }

  public static void main(String[] args) {

    System.out.println("===========================================");
    System.out.println("   SISTEMA DE CAFETERÍA — COSTA RICA       ");
    System.out.println("===========================================\n");

    cafeteria.CafeBebida cappuccino  = crearProducto1();
    cafeteria.CafePostre tiramisu    = crearProducto2();

    cafeteria.RegionCultivo poasTres = new cafeteria.RegionCultivo(
            "Poás", 1600, "Cítrico", "Acidez alta", "Ligero");

    cafeteria.Receta recetaCold = new cafeteria.Receta(
            "Cold Brew Caturra Poás",
            "Moler grueso 80 g de café. Mezclar con 1 L de agua fría. " +
                    "Reposar 18 h en refrigerador. Filtrar lentamente. Servir sobre hielo.");
    recetaCold.agregarIngrediente(new cafeteria.Ingrediente("Café Caturra Poás molido grueso", 80.0,  "g"));
    recetaCold.agregarIngrediente(new cafeteria.Ingrediente("Agua filtrada fría",            1000.0, "ml"));
    recetaCold.agregarIngrediente(new cafeteria.Ingrediente("Hielo",                          200.0, "g"));
    recetaCold.agregarIngrediente(new cafeteria.Ingrediente("Leche de avena (opcional)",       60.0, "ml"));

    cafeteria.CafeBebida coldBrew = new cafeteria.CafeBebida(
            "Cold Brew Caturra Poás",
            "Infusión en frío 18 horas — suave y sin acidez",
            cafeteria.TipoCafe.CATURRA, poasTres,
            false, 3200.0, recetaCold,
            "frío", "grande", true);

    System.out.println("► Registrando productos en el menú...\n");
    cafeteria.Menu menu = new cafeteria.Menu(5);

    menu.agregarProducto(cappuccino);   // Mecanismo 1 (objeto ya creado)
    menu.agregarProducto(tiramisu);     // Mecanismo 1
    menu.agregarProducto(coldBrew);     // Mecanismo 1

    cafeteria.RegionCultivo brunca = new cafeteria.RegionCultivo(
            "Brunca", 1200, "Achocolatado", "Amargo suave", "Denso");
    cafeteria.Receta recetaMacchiato = new cafeteria.Receta(
            "Macchiato Arábica Brunca",
            "Extraer espresso simple. Añadir solo una cucharada de leche espumada.");
    recetaMacchiato.agregarIngrediente(new cafeteria.Ingrediente("Café Arábica Brunca", 9.0, "g"));
    recetaMacchiato.agregarIngrediente(new cafeteria.Ingrediente("Agua",               30.0, "ml"));
    recetaMacchiato.agregarIngrediente(new cafeteria.Ingrediente("Leche espumada",     15.0, "ml"));

    menu.agregarBebida(
            "Macchiato Arábica Brunca",
            "Espresso manchado con espuma mínima",
            cafeteria.TipoCafe.ARABICA, brunca,
            2600.0, recetaMacchiato,
            "caliente", "pequeño"
    );

    menu.mostrarMenu();

    System.out.println("► Información detallada de cada producto:\n");
    menu.mostrarDetalle();

    System.out.println("► Búsqueda: 'tiramisu'");
    cafeteria.Cafe encontrado = menu.buscarProducto("tiramisu");
    if (encontrado != null) {
      System.out.println("  Encontrado: " + encontrado.getNombre());
      System.out.println("  → " + encontrado.preparar());
    } else {
      System.out.println("  No encontrado.");
    }

    System.out.println("\n► Instrucción de preparación (polimorfismo):");
    cafeteria.Cafe[] todos = { cappuccino, tiramisu, coldBrew };
    for (cafeteria.Cafe c : todos) {
      System.out.println("  • " + c.preparar());
    }

    System.out.println("\n► Liberando menú (destructor)...");
    menu = null;
    System.gc();
    try { Thread.sleep(200); } catch (InterruptedException ignored) {}

    System.out.println("\n===========================================");
    System.out.println("   FIN DEL PROGRAMA                        ");
    System.out.println("===========================================");
  }
}