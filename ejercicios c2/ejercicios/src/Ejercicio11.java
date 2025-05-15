import java.util.*;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] konami = {"arriba", "arriba", "abajo", "abajo", "izquierda", "derecha", "izquierda", "derecha", "b", "a"};
        List<String> entrada = new ArrayList<>();

        System.out.println("Introduce el código (una palabra por línea):");

        while (true) {
            String input = sc.nextLine().toLowerCase();
            entrada.add(input);
            if (entrada.size() > konami.length) entrada.remove(0);

            if (Arrays.equals(entrada.toArray(), konami)) {
                System.out.println("¡Código Konami detectado!");
                break;
            }
        }
    }
}
