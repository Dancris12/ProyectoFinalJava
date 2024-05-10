import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProyectoFinal {
    public static void main(String[] args) {
        // Crear una lista de alumnos
        List<Alumno> listaAlumnos = new ArrayList<>();

        // Crear un objeto Scanner para entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la cantidad de alumnos a registrar
        System.out.print("Ingrese la cantidad de alumnos a registrar: ");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Expresión regular para validar el nombre (solo letras y espacios)
        String regexNombre = "^[a-zA-Z ]+$";
        // Expresión regular para validar la edad (número entero positivo)
        String regexEdad = "^[1-9]\\d*$";

        // Solicitar al usuario los datos de cada alumno y agregarlos a la lista
        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese los datos del alumno " + (i + 1) + ":");
            String nombre = pedirNombre(scanner, regexNombre);
            int edad = pedirEdad(scanner, regexEdad);
            String tipoAlumno = pedirTipoAlumno(scanner);

            if (tipoAlumno.equals("P")) {
                int grado = pedirGrado(scanner);
                listaAlumnos.add(new AlumnoPrimaria(nombre, edad, grado));
            } else if (tipoAlumno.equals("S")) {
                String nivel = pedirNivel(scanner);
                listaAlumnos.add(new AlumnoSecundaria(nombre, edad, nivel));
            } else {
                System.out.println("Opción inválida. Ingrese P para primaria o S para secundaria.");
                i--; // Volver a solicitar los datos del mismo alumno
            }
        }

        // Matricular a todos los alumnos e imprimir su información
        for (Alumno alumno : listaAlumnos) {
            alumno.matricular();
            alumno.mostrarInformacion();
            System.out.println();
        }

        // Cerrar el objeto Scanner
        scanner.close();
    }

    // Método para validar una entrada con una expresión regular
    public static boolean validarEntrada(String entrada, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entrada);
        return matcher.matches();
    }

    // Método estático para solicitar y validar el nombre del alumno
    public static String pedirNombre(Scanner scanner, String regexNombre) {
        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();
            if (!validarEntrada(nombre, regexNombre)) {
                System.out.println("Error: Nombre inválido. Debe contener solo letras y espacios.");
            }
        } while (!validarEntrada(nombre, regexNombre));
        return nombre;
    }

    // Método estático para solicitar y validar la edad del alumno
    public static int pedirEdad(Scanner scanner, String regexEdad) {
        String edadStr;
        do {
            System.out.print("Edad: ");
            edadStr = scanner.nextLine();
            if (!validarEntrada(edadStr, regexEdad)) {
                System.out.println("Error: Edad inválida. Debe ser un número entero positivo.");
            }
        } while (!validarEntrada(edadStr, regexEdad));
        return Integer.parseInt(edadStr);
    }

    // Método estático para solicitar el tipo de alumno (primaria o secundaria)
    public static String pedirTipoAlumno(Scanner scanner) {
        String tipoAlumno;
        do {
            System.out.print("¿Es alumno de primaria o secundaria? (P/S): ");
            tipoAlumno = scanner.nextLine().toUpperCase();
        } while (!tipoAlumno.equals("P") && !tipoAlumno.equals("S"));
        return tipoAlumno;
    }

    // Método estático para solicitar y validar el grado del alumno de primaria
    public static int pedirGrado(Scanner scanner) {
        int grado;
        do {
            System.out.print("Grado: ");
            grado = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
        } while (grado <= 0);
        return grado;
    }

    // Método estático para solicitar y validar el nivel del alumno de secundaria
    public static String pedirNivel(Scanner scanner) {
        System.out.print("Nivel: ");
        return scanner.nextLine();
    }
}
