import java.util.ArrayList;

public class Main {
    static void main() {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Ana");
        lista.add("Javier");
        lista.add("Fernando");
        lista.add("Isabel");
        lista.add("Mario");
        lista.add("Eduardo");

        for (String nombre : lista) {
            String str = nombre.toLowerCase();
            if (str.startsWith("a") || str.startsWith("e") || str.startsWith("i") || str.startsWith("o") || str.startsWith("u"))
                System.out.println(nombre);
        }
    }
}
