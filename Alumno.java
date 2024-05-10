// Clase abstracta para representar a un alumno
abstract class Alumno {
    private String nombre;
    private int edad;

    // Constructor
    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos abstractos que deben ser implementados por las clases hijas
    public abstract void matricular();

    public abstract void mostrarInformacion();

    // Getters y setters para encapsulamiento
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}