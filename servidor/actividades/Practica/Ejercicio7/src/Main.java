public class Main {
    static void main() {
        String nombre = "Eduardo";
        nombre = nombre.toLowerCase();
        char letra;
        int vA = 0,vE = 0,vI = 0,vO = 0,vU = 0, cont = 0;
        char[] vocales = {'a','e','i','o','u'};
        for (int i = 0; i < nombre.length(); i++) {
            letra = nombre.charAt(i);
            for (int j = 0; j < vocales.length; j++) {
                if (letra == vocales[j]);
                cont++;
            }
        }
        System.out.println("Existen " + cont + " vocales");
    }
}