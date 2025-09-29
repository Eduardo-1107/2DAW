public class Main {
    static void main() {
        Animal a1 = new Perro("Toby",2);
        Animal a2 = new Perro("Jon", 1);
        Animal a3 = new Gato("Pelusa", 4);

        Animal[] animales = {a1,a2,a3};

        for (Animal animal : animales) {
            System.out.println(animal);
            animal.hacerSonido();
        }
    }
}