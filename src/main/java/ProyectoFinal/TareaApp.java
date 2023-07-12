package ProyectoFinal;

import ProyectoFinal.TareaManager;

import java.util.*;

public class TareaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TareaManager tareaManager = new TareaManager();

        while (true) {
            System.out.println("===== Menú =====");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Completar tarea");
            System.out.println("3. Deshacer");
            System.out.println("4. Buscar tarea");
            System.out.println("5. Mostrar tareas con fecha límite");
            System.out.println("6. Mostrar todas las tareas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Consumir nueva línea pendiente
                    System.out.print("Título de la tarea: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Prioridad de la tarea (0-9): ");
                    int prioridad = scanner.nextInt();
                    tareaManager.agregarTarea(titulo, descripcion, prioridad);
                    System.out.println("Tarea agregada exitosamente.");
                    break;

                case 2:
                    System.out.print("Índice de la tarea a completar: ");
                    int indice = scanner.nextInt();
                    tareaManager.completarTarea(indice);
                    break;

                case 3:
                    tareaManager.deshacer();
                    break;

                case 4:
                    scanner.nextLine(); // Consumir nueva línea pendiente
                    System.out.print("Título de la tarea a buscar: ");
                    String tituloABuscar = scanner.nextLine();
                    System.out.print("Índice de inicio de la búsqueda: ");
                    int indiceInicio = scanner.nextInt();
                    tareaManager.buscarTarea(tituloABuscar, indiceInicio);
                    break;

                case 5:
                    tareaManager.mostrarTareasConFechaLimite();
                    break;

                case 6:
                    tareaManager.mostrarTodasLasTareas();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);

                default:
                    System.out.println("Opción inválida");
                    break;
            }

            System.out.println();
        }
    }
}
