public class Ejercicio12 {
    public static void main(String[] args) {
        cuentaAtras(10, 1);
    }

    static void cuentaAtras(int inicio, int segundos) {
        if (inicio < 0 || segundos < 0) return;
        try {
            for (int i = inicio; i >= 0; i--) {
                System.out.println(i);
                Thread.sleep(segundos * 1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Error en el temporizador.");
        }
    }
}
