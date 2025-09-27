import java.util.Scanner;

public class Main {
    static void main() {
        int edad = 0;
        boolean valido = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba su edad (en números exclusivamente)");
        while(!valido) {
            if (sc.hasNextInt()) {
                edad = sc.nextInt();
                valido = true;
            }
        }
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad no puede ser igual o inferior a 0");
        } else if (edad < 18)
            System.out.println("Eres menor de edad");
        else
            System.out.println("Eres mayor de edad");
        if (edad%2 == 0)
            System.out.println("Tu edad es par");
        else
            System.out.println("Tu edad es impar");
    }
}