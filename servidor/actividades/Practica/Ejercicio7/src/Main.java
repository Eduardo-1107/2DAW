public class Main {
    static void main() {
        Funciones.contarVocales("Eduardo");
        Funciones.ponerMayus("Hola soy Eduardo");
    }
    public class Funciones {
        public static void contarVocales(String s) {
        String nombre = s;
        nombre = nombre.toLowerCase();
        char letra;
        int cont = 0;
        char[] vocales = {'a','e','i','o','u'};
        for (int i = 0; i < nombre.length(); i++) {
            letra = nombre.charAt(i);
            for (char vocal : vocales) {
                if (letra == vocal)
                    cont++;
            }
        }
        System.out.println("Existen " + cont + " vocales");
        }
        public static void ponerMayus(String str) {
            String resultado = "";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    c = (char)(c - 32);
                }
                resultado += c;
            }
            System.out.println("Original: " + str);
            System.out.println("Mayúsculas: " + resultado);
        }
    }

}