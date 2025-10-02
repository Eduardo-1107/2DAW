//Usa un HashMap<String, String> para guardar nombre → teléfono.
//Permite añadir, buscar y eliminar contactos.

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static void main() {
        HashMap<String,Integer> listaContactos = new HashMap<>();
        int flag = 0;
        Funciones.menu();
        flag = Funciones.pedirNumero("Introduzca el número del menú: ");
        while (flag != 0) {
            switch (flag) {
                case 1:
                    Funciones.añadirContacto(listaContactos);
                    Funciones.menu();
                    flag = Funciones.pedirNumero("Qué desea hacer ahora --> ");
                    break;
                case 2:
                    Funciones.buscarContacto(listaContactos);
                    Funciones.menu();
                    flag = Funciones.pedirNumero("Qué desea hacer ahora --> ");
                    break;
                case 3:
                    Funciones.borrarContacto(listaContactos);
                    Funciones.menu();
                    flag = Funciones.pedirNumero("Qué desea hacer ahora --> ");
                case 4:
                    Funciones.listarContactos(listaContactos);
                    Funciones.menu();
                    flag = Funciones.pedirNumero("Qué desea hacer ahora --> ");
                    break;
            }
        }
        System.out.println("Adios");
    }
}
