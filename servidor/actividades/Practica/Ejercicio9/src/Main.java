public class Main {
    static void main() {
        Coche c1 = new Coche("Citroen", "Berlingo");
        Coche c2 = new Coche("Seat", "Arona", 120);

        Coche[] coches = {c1,c2};

        for (Coche coche : coches)
            System.out.println(coche);

        for (int i = 0; i < 10; i++)
            c1.acelerar();
        System.out.println(c1);

        c1.acelerar(20);
        System.out.println(c1);

        for (int i = 0; i < 20; i++)
            c2.frenar();
        System.out.println(c2);

        c2.frenar(50);
        System.out.println(c2);

    }
}
