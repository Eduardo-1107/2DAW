public class Main {
    static void main() {
        Persona p1 = new Persona("Eduardo",21);
        Persona p2 = new Persona("Javier",15);
        Persona p3 = new Persona("Felipe",33);

        Persona[] personas = {p1,p2,p3};

        for (Persona persona : personas) {
            persona.saludar();
        }
        for (Persona persona : personas) {
            System.out.println(persona.toString());
        }
    }
}