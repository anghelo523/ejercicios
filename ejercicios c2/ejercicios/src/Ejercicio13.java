public class Ejercicio13 {
    public static void main(String[] args) {
        System.out.println(expresionCorrecta("5 + 6 / 7 - 4")); // true
        System.out.println(expresionCorrecta("5 a 6"));         // false
    }

    static boolean expresionCorrecta(String expr) {
        String[] partes = expr.split(" ");
        if (partes.length < 3 || partes.length % 2 == 0) return false;

        for (int i = 0; i < partes.length; i++) {
            if (i % 2 == 0) {
                if (!esNumero(partes[i])) return false;
            } else {
                if (!esOperador(partes[i])) return false;
            }
        }
        return true;
    }

    static boolean esNumero(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean esOperador(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
