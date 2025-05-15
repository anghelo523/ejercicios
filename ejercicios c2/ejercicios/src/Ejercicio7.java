import java.util.Map;

public class Ejercicio7 {
    static Map<String, Integer> bien = Map.of(
            "Peloso", 1, "SureñoBueno", 2, "Enano", 3, "Númenóreano", 4, "Elfo", 5
    );
    static Map<String, Integer> mal = Map.of(
            "SureñoMalo", 2, "Orco", 2, "Goblin", 2, "Huargo", 3, "Troll", 5
    );

    public static String batalla(Map<String, Integer> ejercitoBien, Map<String, Integer> ejercitoMal) {
        int totalBien = ejercitoBien.entrySet().stream().mapToInt(e -> bien.get(e.getKey()) * e.getValue()).sum();
        int totalMal = ejercitoMal.entrySet().stream().mapToInt(e -> mal.get(e.getKey()) * e.getValue()).sum();

        if (totalBien > totalMal) return "Gana el bien";
        else if (totalBien < totalMal) return "Gana el mal";
        else return "Empate";
    }

    public static void main(String[] args) {
        Map<String, Integer> bien = Map.of("Peloso", 2);
        Map<String, Integer> mal = Map.of("Orco", 1);
        System.out.println(batalla(bien, mal));
    }
}
