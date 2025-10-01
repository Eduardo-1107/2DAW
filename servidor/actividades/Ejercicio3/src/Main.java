import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String nombreProducto = "", aux = "";
        StringBuilder listaProductos = new StringBuilder();
        double precioProducto = 0, precioTotal = 0;
        boolean fin = false;

        while(!fin) {
            System.out.println("Introduce producto: ");
            nombreProducto = sc.nextLine();
            aux = nombreProducto.toLowerCase();

            if (aux.equals("fin")) {
                fin = true;
            } else {
                System.out.println("Introduce precio del producto: ");
                precioProducto = sc.nextDouble();
                sc.nextLine();
                listaProductos.append(nombreProducto).append(" ").append(precioProducto).append(" € \n");
                precioTotal += precioProducto;
            }
        }
        System.out.println(listaProductos + "Precio total = " + precioTotal + " €");
    }
}

