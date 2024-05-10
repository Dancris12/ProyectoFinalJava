// Clase que representa a un alumno de secundaria
class AlumnoSecundaria extends Alumno {
    private String nivel;

    // Constructor
    public AlumnoSecundaria(String nombre, int edad, String nivel) {
        super(nombre, edad);
        this.nivel = nivel;
    }

    // Implementación del método matricular
    @Override
    public void matricular() {
        System.out.println("Matriculando a " + getNombre() + " en " + nivel + " de secundaria.");
    }

    // Implementación del método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre() + ", Edad: " + getEdad() + ", Nivel: " + nivel);
    }
}