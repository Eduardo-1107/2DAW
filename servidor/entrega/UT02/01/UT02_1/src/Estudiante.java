public class Estudiante {
    private String nombre;
    private int edad;
    private double notaMedia;
    private boolean esMatriculado;

    public Estudiante() { }
    public Estudiante(String nombre, int edad, double notaMedia, boolean esMatriculado) {
        setNombre(nombre);
        setEdad(edad);
        setNotaMedia(notaMedia);
        setEsMatriculado(esMatriculado);
    }

     public String getNombre() {
        return this.nombre;
     }
     public int getEdad() {
        return this.edad;
     }
     public double getNotaMedia() {
        return this.notaMedia;
     }
     public boolean getEsMatriculado() {
        return this.esMatriculado;
     }
     public void setNombre(String nombre) {
        this.nombre = nombre;
     }
     public void setEdad(int edad) {
        this.edad = edad;
     }
     public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
     }
     public void setEsMatriculado(boolean esMatriculado) {
        this.esMatriculado = esMatriculado;
     }

}
