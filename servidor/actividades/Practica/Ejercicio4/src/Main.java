public class Main {
    static void main() {
        Contar(100);
        TablaMultiplicar(5);
    }
    public static void Contar(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.println(j);
        }
    }
    private static void TablaMultiplicar(int num) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num*i));
        }
    }
}
