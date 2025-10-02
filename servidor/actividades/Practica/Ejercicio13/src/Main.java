import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dic = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String entrada = "", clave = "", traduccion = "", respuesta = "", nueva = "";

        dic.put("perro", "dog");
        dic.put("gato", "cat");
        dic.put("casa", "house");
        dic.put("mesa", "table");
        dic.put("silla", "chair");

        System.out.println("Diccionario español→inglés. Escribe 'salir' para terminar.");

        while (true) {
            System.out.print("\nIntroduce palabra en español: ");
            entrada = sc.nextLine().trim();
            if (entrada.equalsIgnoreCase("salir")) {
                System.out.println("Adiós.");
                break;
            } else if (entrada.isEmpty()) {
                System.out.println("No has escrito nada. Intenta otra vez.");
                continue;
            }

            clave = entrada.toLowerCase();
            traduccion = dic.get(clave);

            if (traduccion != null) {
                System.out.printf("%s → %s%n", entrada, traduccion);
            } else {
                System.out.println("No encontrada la traducción para \"" + entrada + "\".");
                System.out.print("¿Quieres añadir una traducción para esta palabra? (s/n): ");
                respuesta = sc.nextLine().trim();
                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.print("Introduce la traducción en inglés: ");
                    nueva = sc.nextLine().trim();
                    if (!nueva.isEmpty()) {
                        dic.put(clave, nueva);
                        System.out.println("Añadida: " + entrada + " → " + nueva);
                    } else {
                        System.out.println("No se añadió ninguna traducción (entrada vacía).");
                    }
                }
            }
        }
        sc.close();
    }
}

