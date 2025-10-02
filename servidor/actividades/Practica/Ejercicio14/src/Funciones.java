import java.util.HashMap;
import java.util.Scanner;

public class Funciones {
    public static void menu() {
        System.out.print("""
                Bienvenido/a a la lista de contactos:
                ¿Qué desea hacer?
                \t[0] Salir
                \t[1] Añadir contacto
                \t[2] Buscar contacto
                \t[3] Eliminar contacto
                \t[4] Listar contactos\n""");
    }
    public static int pedirNumero(String msg) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                valido = true;
            } else {
                System.out.println("Entrada no válida. Intenta de nuevo.");
                sc.next();
            }
        }
        return num;
    }
    public static String pedirTexto(String msg) {
        Scanner sc = new Scanner(System.in);
        String txt = "";
        do {
            System.out.print(msg);
            txt = sc.nextLine();
        } while (txt.isEmpty());
        return txt;
    }
    public static void añadirContacto(HashMap<String,Integer> dic) {
        String cNombre = "";
        int vTelefono = 0;

        cNombre = Funciones.pedirTexto("Introduzca el nombre del contacto: ");
        vTelefono =  Funciones.pedirNumero("Introduzca el número de Teléfono del contacto: ");
        dic.put(cNombre,vTelefono);
        System.out.printf("%s --> %s%n",cNombre,vTelefono);
    }
    public static void buscarContacto(HashMap<String,Integer> dic) {
        String cNombre = "";
        cNombre = Funciones.pedirTexto("Introduce el nombre del contacto que desea saber su número: ");
        System.out.printf("%s --> %s%n",cNombre,dic.get(cNombre));
    }
    public static void borrarContacto(HashMap<String,Integer> dic) {
        String cNombre = "";
        cNombre = Funciones.pedirTexto("Indique que contacto desea eliminar: ");
        System.out.printf("%s --> %s%n",cNombre,dic.get(cNombre));
        dic.remove(cNombre);
    }
    public static void listarContactos(HashMap<String,Integer> dic) {
        for (String contacto : dic.keySet())
            System.out.printf("%s --> %s%n", contacto,dic.get(contacto));
    }
}
