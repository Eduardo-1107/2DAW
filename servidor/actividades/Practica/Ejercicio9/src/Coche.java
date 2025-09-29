public class Coche {
    private String _marca;
    private String _modelo;
    private int _velocidad;

    public Coche(String marca, String modelo) {
        _marca = marca;
        _modelo = modelo;
        _velocidad = 0;
    }
    public Coche(String marca, String modelo, int velocidad) {
        this(marca, modelo);
        _velocidad = velocidad;
    }

    public void acelerar() {
        _velocidad++;
    }
    public void acelerar(int i) {
        _velocidad += i;
    }
    public void frenar() {
        _velocidad--;
    }
    public void frenar(int i) {
        _velocidad -= i;
    }

    @Override
    public String toString() {
        return "Coche: { marca = " + _marca + " | modelo = " + _modelo + " | velocidad = " + _velocidad + " }";
    }
}
