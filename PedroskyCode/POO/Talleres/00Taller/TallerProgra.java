package TallerPOO;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * TallerProgra - Sistema de gestión de actividades con autenticación de usuarios.
 *
 * Autores:
 *   Pedro Segovia      - 21672694-4 - ITI
 *   Valentina Castillo - 15.166.692-2 - ITI
 */
public class TallerProgra {

    // =========================================================================
    // PUNTO DE ENTRADA
    // =========================================================================

    // Inicia la aplicación
    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

    // =========================================================================
    // MENÚS Y NAVEGACIÓN
    // =========================================================================

    // Muestra el menú principal y redirige según la opción elegida
    public static void mostrarMenuPrincipal() {
        System.out.println("1) Menu de Usuarios");
        System.out.println("2) Menu de Analisis");
        System.out.println("3) Salir");

        int seleccion = capturarOpcion(1, 3);
        redirigirMenuPrincipal(seleccion);
    }

    // Redirige a Usuarios, Análisis o Salida según la opción
    public static void redirigirMenuPrincipal(int opcion) {
        switch (opcion) {
            case 1:
                try {
                    mostrarMenuUsuarios();
                } catch (FileNotFoundException e) {
                    System.out.println("Error: No se encontró el archivo de usuarios.");
                    e.printStackTrace();
                }
                break;
            case 2:
                mostrarMenuAnalisis();
                break;
            case 3:
                salir();
                break;
        }
    }

    // Solicita credenciales, valida acceso y muestra submenú de operaciones
    public static void mostrarMenuUsuarios() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Menu de Usuarios ---");
        System.out.print("Ingrese nombre: ");
        String nombreIngresado = sc.nextLine();
        System.out.print("Contraseña: ");
        String contraseñaIngresada = sc.nextLine();

        String nombreValidado = validarCredenciales(nombreIngresado, contraseñaIngresada);

        if (nombreValidado.isEmpty()) {
            System.out.println("Credenciales incorrectas. Volviendo al menú principal.");
            sc.close();
            mostrarMenuPrincipal();
            return;
        }

        System.out.println("Bienvenido, " + nombreValidado + "!");
        System.out.println("\n¿Qué deseas realizar?");
        System.out.println("1) Registrar actividad");
        System.out.println("2) Modificar actividad");
        System.out.println("3) Eliminar actividad");
        System.out.println("4) Cambiar contraseña");
        System.out.println("5) Salir");

        int opcion = capturarOpcion(1, 5);
        sc.close();

        switch (opcion) {
            case 1: registrarActividad();          break;
            case 2: modificarActividad();          break;
            case 3: /* TODO: eliminar actividad */ break;
            case 4: /* TODO: cambiar contraseña */ break;
            case 5: mostrarMenuPrincipal();        break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
        }
    }

    // Muestra el menú de análisis (en construcción)
    public static void mostrarMenuAnalisis() {
        System.out.println("\n--- Menu de Análisis ---");
        System.out.println("Bienvenido al menú de análisis.");
        // TODO: implementar opciones de análisis
    }

    // =========================================================================
    // OPERACIONES DE ACTIVIDAD
    // =========================================================================

    // Registra una nueva actividad en el archivo (en construcción)
    private static void registrarActividad() {
        System.out.println("Función de registro en construcción.");
        // TODO: implementar registro de actividad
    }

    // Muestra registros existentes y solicita el ID a modificar (en construcción)
    private static void modificarActividad() throws FileNotFoundException {
        System.out.println("¿Cuál actividad deseas modificar?");
        buscarRegistros();

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID a modificar: ");
        int idModificar = sc.nextInt();
        sc.close();

        // TODO: implementar lógica de modificación con idModificar
    }

    // =========================================================================
    // LECTURA DE ARCHIVOS
    // =========================================================================

    // Lee Registros.txt, imprime cada línea y retorna el total de registros
    private static int buscarRegistros() throws FileNotFoundException {
        File archivo = new File("Registros.txt");
        Scanner sc = new Scanner(archivo);

        String[] listaID        = new String[200];
        String[] listaFecha     = new String[200];
        String[] listaHoras     = new String[200];
        String[] listaActividad = new String[200];
        int conteo = 0;

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            String[] partes = linea.split(";");

            listaID[conteo]         = partes[0];
            listaFecha[conteo]      = partes[1];
            listaHoras[conteo]      = partes[2];
            listaActividad[conteo]  = partes[3];

            System.out.println(linea);
            conteo++;
        }

        sc.close();
        return conteo;
    }

    // Lee Usuarios.txt y retorna el nombre si las credenciales son correctas
    public static String validarCredenciales(String usuarioIngresado, String contraseñaIngresada) {
        String[] usuarios    = new String[100];
        String[] contraseñas = new String[100];
        int cont = 0;

        try {
            File file = new File("Usuarios.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String[] partes = sc.nextLine().split(";");
                usuarios[cont]    = partes[0];
                contraseñas[cont] = partes[1];
                cont++;
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró 'Usuarios.txt'.");
            e.printStackTrace();
        }

        for (int i = 0; i < cont; i++) {
            if (usuarios[i].equals(usuarioIngresado) && contraseñas[i].equals(contraseñaIngresada)) {
                System.out.println("Acceso correcto.");
                return usuarios[i];
            }
        }

        System.out.println("Credenciales incorrectas.");
        return "";
    }

    // =========================================================================
    // UTILIDADES
    // =========================================================================

    // Captura y valida un número entre min y max, repite si el input es inválido
    public static int capturarOpcion(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (true) {
            try {
                System.out.print("Seleccione una opción (" + min + "-" + max + "): ");
                opcion = Integer.parseInt(sc.nextLine());

                if (opcion >= min && opcion <= max) {
                    break;
                } else {
                    System.out.println("Error: Debe elegir entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número.");
            }
        }

        sc.close();
        return opcion;
    }

    // Imprime despedida y cierra el programa
    public static void salir() {
        System.out.println("Hasta luego. ¡Nos vemos!");
        System.exit(0);
    }
}