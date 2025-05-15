import java.util.*;

public class Ejercicio5 {
    static Map<Integer, String> productos = Map.of(
            1, "Galleta", 2, "Agua", 3, "Chocolate"
    );

    static Map<Integer, Integer> precios = Map.of(
            1, 120, 2, 100, 3, 150
    );

    static int[] monedas = {200, 100, 50, 10, 5};

    public static Object[] comprar(int[] dinero, int producto) {
        int total = 0;
        for (int m : dinero) {
            if (Arrays.stream(monedas).noneMatch(x -> x == m)) {
                return new Object[]{"Moneda inválida", dinero};
            }
            total += m;
        }

        if (!productos.containsKey(producto)) return new Object[]{"Producto no existe", dinero};

        int precio = precios.get(producto);
        if (total < precio) return new Object[]{"Dinero insuficiente", dinero};

        int vuelto = total - precio;
        List<Integer> devuelta = new ArrayList<>();

        for (int m : monedas) {
            while (vuelto >= m) {
                devuelta.add(m);
                vuelto -= m;
            }
        }

        return new Object[]{productos.get(producto), devuelta.toArray(new Integer[0])};
    }

    public static void main(String[] args) {
        int[] dinero = {100, 50, 10};
        Object[] resultado = comprar(dinero, 3);
        System.out.println("Producto: " + resultado[0]);
        System.out.println("Vuelto: " + Arrays.toString((Object[]) resultado[1]));
    }
}
