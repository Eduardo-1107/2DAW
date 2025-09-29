public class Persona {
    private final String _nombre;
    private  int _edad;

    public Persona(String nombre, int edad) {
        _nombre = nombre;
        _edad = edad;
    }
    public void saludar() {
        System.out.println("Hola soy " + _nombre + " y tengo " + _edad + " años");
    }

    @Override
    public String toString() {
        return "Persona: { nombre = " + _nombre + ", edad = " + _edad + " }";
    }
}
