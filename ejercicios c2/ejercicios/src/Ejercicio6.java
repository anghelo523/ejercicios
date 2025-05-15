import java.util.Map;

public class Ejercicio6 {
    public static double calcularDanio(String tipoAtacante, String tipoDefensor, int ataque, int defensa) {
        Map<String, Map<String, Double>> efectividad = Map.of(
                "Agua", Map.of("Fuego", 2.0, "Planta", 0.5, "Eléctrico", 1.0, "Agua", 0.5),
                "Fuego", Map.of("Planta", 2.0, "Agua", 0.5, "Fuego", 0.5, "Eléctrico", 1.0),
                "Planta", Map.of("Agua", 2.0, "Fuego", 0.5, "Planta", 0.5, "Eléctrico", 1.0),
                "Eléctrico", Map.of("Agua", 2.0, "Planta", 1.0, "Fuego", 1.0, "Eléctrico", 0.5)
        );

        double factor = efectividad.get(tipoAtacante).getOrDefault(tipoDefensor, 1.0);
        return 50 * ((double) ataque / defensa) * factor;
    }

    public static void main(String[] args) {
        System.out.println("Daño: " + calcularDanio("Agua", "Fuego", 80, 60));
    }
}
