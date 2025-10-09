import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static void main() {
        int flag, edad;
        double notaMedia, suma, mediaTotal, mejorCalificacion;
        String nombre;
        boolean esMatriculado, encontrado;
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

        do {
            Menu.verMenu();
            flag = Funciones.pedirNumeroInt("Elige una opcion: ");

            switch (flag) {

                case 1:
                    Estudiante est = new Estudiante();
                    do {
                        try {
                            nombre = Funciones.pedirTexto("\nIntroduce nombre:");
                            est.setNombre(nombre);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(">> Nombre inválido, inténtelo de nuevo");
                        }
                    } while (true);
                    do {
                        try {
                            edad = Funciones.pedirNumeroInt("\nIntroduce edad: ");
                            est.setEdad(edad);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(">> Edad inválida, el valor debe ser superior a 0");
                        }
                    } while (true);
                    do {
                        try {
                            notaMedia = Funciones.pedirNumeroDouble("\nIntroduce nota media: ");
                            est.setNotaMedia(notaMedia);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(">> Nota Media inválida, inténtelo de nuevo");
                        }
                    } while (true);
                    do {
                        try {
                            esMatriculado = Funciones.pedirBoolean("\n¿Está matriculado? (true/false): ");
                            est.setEsMatriculado(esMatriculado);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(">> Respuesta inválida, inténtelo de nuevo");
                        }
                    } while (true);
                    try {
                        listaEstudiantes.add(est);
                        System.out.println("\n> Estudiante agregado correctamente\n");
                    } catch (Exception e) {
                        System.out.println("\n>> Estudiante NO agregado.");
                    }
                    break;
                case 2:
                    System.out.println("\n=== Lista de Estudiantes ===");
                    if (listaEstudiantes.isEmpty())
                        System.out.println(">> No hay nigún alumno en la lista");
                    else
                        for (Estudiante estudiante : listaEstudiantes) {
                            System.out.printf("Nombre: %s (%s años) - Nota Media: %s - Matriculado: %s%n",estudiante.getNombre(),estudiante.getEdad(),estudiante.getNotaMedia(),estudiante.getEsMatriculado());
                        }
                    System.out.printf("%n");
                    break;
                case 3:
                    encontrado = false;
                    if (!listaEstudiantes.isEmpty()) {
                        nombre = Funciones.pedirTexto("\nIntroduce nombre: ").toLowerCase();
                        for (Estudiante estudiante : listaEstudiantes) {
                            if (estudiante.getNombre().toLowerCase().contains(nombre)) {
                                System.out.printf("%nEstudiante encontrado%n" +
                                        "> Nombre: %s%n" +
                                        "> Edad: %s%n" +
                                        "> Nota Media: %s%n" +
                                        "> Matriculado: %s%n%n", estudiante.getNombre(),estudiante.getEdad(),estudiante.getNotaMedia(), estudiante.getEsMatriculado());
                                encontrado = true;
                            }
                        }
                        if (!encontrado)
                            System.out.println("\n>> Estudiante no encontrado\n");
                    } else
                        System.out.println("\n>> La lista está vacía\n");
                    break;

                case 4:
                    suma = 0;
                    if (!listaEstudiantes.isEmpty()) {
                        for (Estudiante estudiante : listaEstudiantes) {
                            suma += estudiante.getNotaMedia();
                        }
                        mediaTotal = suma/listaEstudiantes.size();
                            System.out.printf("%n> La media total de %s estudiante/es es: %.2f%n%n",listaEstudiantes.size(),mediaTotal);
                    } else
                        System.out.println("\n>> La lista está vacía\n");
                    break;

                case 5:
                    mejorCalificacion = Double.MIN_VALUE;
                    if (!listaEstudiantes.isEmpty()) {
                        for (Estudiante estudiante : listaEstudiantes)
                            if (estudiante.getNotaMedia() > mejorCalificacion)
                                mejorCalificacion = estudiante.getNotaMedia();
                        for (Estudiante estudiante : listaEstudiantes) {
                            if (estudiante.getNotaMedia() == mejorCalificacion)
                                System.out.printf("%nEstudiante con mejor calificación%n" +
                                        "> Nombre: %s%n" +
                                        "> Edad: %s%n" +
                                        "> Nota Media: %s%n" +
                                        "> Matriculado: %s%n%n", estudiante.getNombre(),estudiante.getEdad(),estudiante.getNotaMedia(), estudiante.getEsMatriculado());
                        }
                    } else
                        System.out.println("\n>> La lista está vacía\n");
                    break;
                case 6:
                    System.out.println("> Adiós");
                    break;
                default:
                    System.out.println("\n>> Elección fuera de rango\n");
                    break;
            }
        } while (flag != 6);
    }
    public static class Menu {
        public static void verMenu() {
            System.out.println("""
                    === Gestor de Estudiantes ===
                        1. Añadir Estudiantes
                        2. Listar Estudiantes
                        3. Buscar por nombre
                        4. Calcular nota media general
                        5. Mostar mejor estudiante
                        6. Salir
                    """);
        }
    }
    public static class Funciones {
        public static int pedirNumeroInt(String msg) {
            Scanner sc = new Scanner(System.in);
            int num = 0;
            boolean valido = false;

            while (!valido) {
                System.out.print(msg);
                if (sc.hasNextInt()) { // boolean que señala si el sc contiene un int o no
                    num = sc.nextInt();
                    valido = true;
                } else {
                    System.out.println("Entrada no válida. Intenta de nuevo.");
                    sc.next();
                }
            }
            return num;
        }
        public static double pedirNumeroDouble(String msg) {
            Scanner sc = new Scanner(System.in);
            double num = 0;
            boolean valido = false;

            while (!valido) {
                System.out.print(msg);
                if (sc.hasNextDouble()) { // boolean que señala si el sc contiene un double o no
                    num = sc.nextDouble();
                    valido = true;
                } else {
                    System.out.println("Entrada no válida. Intenta de nuevo.");
                    sc.next();
                }
            }
            return num;
        }
        public static boolean pedirBoolean(String msg) {
            Scanner sc = new Scanner(System.in);
            String respuesta = "";
            boolean valido = false, b = false;

            while (!valido) {
                System.out.print(msg);
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("true")) { // no es Case Sensitive
                    valido = true;
                    b = true;
                } else if (respuesta.equalsIgnoreCase("false")) {
                    valido = true;
                } else {
                    System.out.println("Entrada no válida. Intenta de nuevo.");
                }
            }
            return b;
        }
        public static String pedirTexto(String msg) {
            Scanner sc = new Scanner(System.in);
            String txt;
            do {
                System.out.print(msg);
                txt = sc.nextLine();
            } while (txt.isEmpty());
            return txt;
        }
    }
}
