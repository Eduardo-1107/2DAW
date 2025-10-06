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
        if (nombre.isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        this.nombre = nombre;
     }
     public void setEdad(int edad) {
         if (edad <= 0)
             throw new IllegalArgumentException("La edad debe ser positiva");
         this.edad = edad;
     }
     public void setNotaMedia(double notaMedia) {
         if (notaMedia < 0 || notaMedia > 10)
             throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
         this.notaMedia = notaMedia;
     }
     public void setEsMatriculado(boolean esMatriculado) {
        this.esMatriculado = esMatriculado;
     }

}
