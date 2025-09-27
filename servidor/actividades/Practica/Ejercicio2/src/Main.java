import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        double dato1 = 0, dato2 = 0;
        boolean valido = false;
        while (!valido) {
            System.out.println("Introduce el primer número: ");
            if (sc.hasNextDouble()) {
                dato1 = sc.nextDouble();
                valido = true;
            } else
                sc.next();
        }
        valido = false;
        while (!valido) {
            System.out.println("Introduce el segundo número: ");
            if (sc.hasNextDouble()) {
                dato2 = sc.nextDouble();
                valido = true;
            } else
                sc.next();
        }
        System.out.printf("Suma = %.2f%n",(dato1+dato2));
        System.out.printf("Resta = %.2f%n", (dato1 - dato2));
        System.out.printf("Multiplicación = %.2f%n", (dato1 * dato2));
        if (dato2 != 0)
            System.out.printf("División = %.2f%n", (dato1 / dato2));
        else
            System.out.println("No se puede dividir por 0");
    }
}