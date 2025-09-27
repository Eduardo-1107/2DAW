public class Main {
    static void main() {
        int valorMayor = Integer.MIN_VALUE, suma = 0;
        double media = 0;
        int[] numeros = {10,5,3,4,1};
        for (int n : numeros) {
            if (n > valorMayor)
                valorMayor = n;
            suma += n;
        }
        media = (double) suma / numeros.length;
        System.out.println("El número mayor es: " + valorMayor);
        System.out.println("La media es: " + media);
    }
}