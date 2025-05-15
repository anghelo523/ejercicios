import java.util.*;

public class Ejercicio9 {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        String[] palabras = {"murcielago", "programador", "universidad", "teclado", "java", "computadora"};
        String palabra = palabras[rand.nextInt(palabras.length)];
        int intentos = 7;

        String oculta = ocultarLetras(palabra);
        char[] progreso = oculta.toCharArray();

        while (intentos > 0 && !String.valueOf(progreso).equals(palabra)) {
            System.out.println("Palabra: " + String.valueOf(progreso));
            System.out.println("Intentos restantes: " + intentos);
            System.out.print("Ingresa una letra o la palabra completa: ");
            String entrada = sc.nextLine().toLowerCase();

            if (entrada.length() == 1) {
                char letra = entrada.charAt(0);
                boolean acierto = false;
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == letra && progreso[i] == '_') {
                        progreso[i] = letra;
                        acierto = true;
                    }
                }
                if (!acierto) intentos--;
            } else if (entrada.length() == palabra.length()) {
                if (entrada.equals(palabra)) {
                    progreso = palabra.toCharArray();
                } else {
                    intentos--;
                }
            } else {
                System.out.println("Entrada inválida.");
            }
        }

        if (String.valueOf(progreso).equals(palabra)) {
            System.out.println("¡Ganaste! La palabra era: " + palabra);
        } else {
            System.out.println("Perdiste. La palabra era: " + palabra);
        }
    }

    static String ocultarLetras(String palabra) {
        int maxOcultas = (int)(palabra.length() * 0.6);
        Set<Integer> posiciones = new HashSet<>();
        while (posiciones.size() < maxOcultas) {
            posiciones.add(rand.nextInt(palabra.length()));
        }
        char[] resultado = palabra.toCharArray();
        for (int pos : posiciones) resultado[pos] = '_';
        return new String(resultado);
    }
}
