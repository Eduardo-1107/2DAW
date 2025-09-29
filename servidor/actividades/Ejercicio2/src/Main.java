import java.util.Scanner;

public class Main {
    static void main() {
        int num = 0;
        String nombre = "";

        Scanner sc = new Scanner(System.in);

        System.out.println("Numero del 1 al 10");
        num = sc.nextInt();

        if (num < 1 || num > 10)
            throw new RuntimeException("El valor debe estar entre el 1 y el 10");
        else {
            System.out.println("¿Cual es tu nombre?");
            sc.nextLine();
            nombre = sc.nextLine();
            for (int i = 0; i < num; i++)
                System.out.println("Hola " + nombre);
            System.out.println("Tu nombre tiene " + nombre.length() + " carácteres.");
        }
        sc.close();
    }
}