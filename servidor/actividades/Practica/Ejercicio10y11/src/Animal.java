public class Animal {
    private int _edad;
    private String _nombre;

    public Animal(String nombre, int edad) {
        _edad = edad;
        _nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }

    @Override
    public String toString() {
        return getClass() + ": {" +
                "edad=" + _edad +
                ", nombre='" + _nombre + '\'' +
                '}';
    }
}
