// Clase que representa a un alumno de primaria
class AlumnoPrimaria extends Alumno {
    private int grado;

    // Constructor
    public AlumnoPrimaria(String nombre, int edad, int grado) {
        super(nombre, edad);
        this.grado = grado;
    }

    // Implementación del método matricular
    @Override
    public void matricular() {
        System.out.println("Matriculando a " + getNombre() + " en " + grado + " grado de primaria.");
    }

    // Implementación del método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre() + ", Edad: " + getEdad() + ", Grado: " + grado);
    }
}