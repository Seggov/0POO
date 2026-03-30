import java.util.Scanner;

public class MainNotas {
    // Declaramos el Scanner como estático para usarlo en todo el programa sin errores.  Podemos declararlo aqui sin problemas.
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Iniciamos el flujo principal
        clasificador();
    }

    // Aqui inicia el bucle
    public static void clasificador() {
        int seleccion = 0;
        // Ciclo para que el programa se repita hasta que el usuario decida salir (opción 4)
        while (seleccion != 4) {
            seleccion = opcionessistem(); // Retorna la opción elegida
            yendoopcion(seleccion);
        }
    }

    
    public static void yendoopcion(int seleccions) {
        if (seleccions == 1) {
            System.out.println("--- Primera Opcion ---");
            opcionuno();
        } else if (seleccions == 2) {
            System.out.println("--- Segunda Opcion ---");
            // Aquí iría la lógica de la opción 2
        } else if (seleccions == 3) {
            System.out.println("--- Tercera Opcion ---");
            // Aquí iría la lógica de la opción 3
        } else if (seleccions == 4) {
            System.out.println("Saliendo del sistema...");
        } else {
            System.out.println("Opción no válida, intente de nuevo.");
        }
    }
    // Aqui Finaliza el Bucle

    
    // Muestra el menú y captura la opción del usuario
    public static int opcionessistem() {
        espacioVacio();
        System.out.println("Hola Bienvenidos al Calculador de Notas para POO");
        String opcionesmenu = " 1) Calcular promedio de Notas \n 2) Calcular Nota en Curso Especifico \n 3) Calcular Totales \n 4) Salir (OUT)";
        System.out.println(opcionesmenu);
        espacioVacio();

        // Leemos el entero y limpiamos el salto de línea para evitar errores en el siguiente input
        int menu = scanner.nextInt();
        scanner.nextLine(); 
        return menu;
    }

    public static void opcionuno() {
    System.out.println("Ingrese su Nombre Completo:");
    String nombreEntrada = scanner.nextLine();

    System.out.println("Ingrese la cantidad de notas:");
    int cantidadnotas = scanner.nextInt();
    scanner.nextLine(); 

    // Validación de la cantidad de notas
    System.out.println("¿Es correcto " + cantidadnotas + "? 1) Sí 2) No");
    int isreal = Integer.parseInt(scanner.nextLine());

    while (isreal == 2) {
        System.out.println("Reingrese la cantidad de notas:");
        cantidadnotas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("¿Es correcto ahora? 1) Sí 2) No");
        isreal = Integer.parseInt(scanner.nextLine());
    }

    // Ciclo para ingresar las notas dinámicamente
    double suma = 0;
    for (int i = 0; i < cantidadnotas; i++) {
        System.out.println("Ingrese la nota " + (i + 1) + ":");
        double nota = Double.parseDouble(scanner.nextLine());
        suma = suma + nota;
    }

    // Cálculo y resultado final
    double promedio = suma / cantidadnotas;
    System.out.println("Excelente trabajo " + nombreEntrada);
    System.out.println("Su promedio final es: " + promedio);
}

    public static void espacioVacio() {
        System.out.println("    ");
    }

}