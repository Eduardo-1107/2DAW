public class Main {
    static void main() {
        if (Funciones.esPrimo(7))
            System.out.println("Es primo");
        else
            System.out.println("No es primo ");
        System.out.println(Funciones.factorial(0));
    }
}

class Funciones {
    static boolean esPrimo(int num) {
        int i = 2;
        if (num <= 1 )
            return false;
        else {
            while ( i <= Math.sqrt(num) ) { // Búsqueda lineal
               if (num % i == 0)
                   return false;
               i++;
            }
        }
        return true;
    }
    static long factorial(int num) {
        long resultado = 1;
        if (num > 20)
            throw new RuntimeException("Overflow Exception");
        else if (num < 0)
            throw new RuntimeException("No puedes hacer factorial de un número negativo");
        for (int i = 1; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }

}