package ProyectoFinal;

import java.util.*;
//Mi clase manejador
class TareaManager {
    //Declaro la pila la cual se ira eliminando con su metodo de pila segunla prioridad de las tareas.
    private Stack<Tarea> deshacerPila;
    private Queue<Tarea> tareasConFechaLimite;
    //Creo una lista donde se almacenaran las tareas
    private List<Tarea> tareas;


    /*Este es el constructor */
    public TareaManager() {
        deshacerPila = new Stack<>();
        tareasConFechaLimite = new LinkedList<>();
        tareas = new ArrayList<>();
    }

    /*Agrega una nueva tarea a mi Lista<Tarea>*/
    public void agregarTarea(String titulo, String descripcion, int prioridad) {
        Tarea tarea = new Tarea(titulo, descripcion, prioridad);
        tareas.add(tarea);

        if (prioridad > 0) {
            tareasConFechaLimite.offer(tarea);
        }
    }
    //Segun como el usuario marque que va completando la tarea este metodo ira Eliminando las tareas que se terminan

    public void completarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.remove(indice);
            deshacerPila.push(tarea);
            tareasConFechaLimite.remove(tarea);
            System.out.println("Tarea completada: " + tarea.getTitulo());
        } else {
            System.out.println("Índice inválido");
        }
    }

    public void deshacer() {
        //Verifico si mi pila tiene elementos en ella
        if (!deshacerPila.isEmpty()) {
            Tarea tarea = deshacerPila.pop();//Si los tiene eliminoel ultimo
            tareas.add(tarea);
            if (tarea.getPrioridad() > 0) {
                tareasConFechaLimite.offer(tarea);
            }
            System.out.println("Deshacer completado: " + tarea.getTitulo());
        } else {
            System.out.println("No hay acciones para deshacer");
        }
    }
    /*Este metodo realiza un recorrido por toda mi lista
    y mostrara la tarea que buscaba exponiendo su descripcion y el orden de prioridad que tiene*/
    public void buscarTarea(String titulo, int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            if (tarea.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Tarea encontrada:");
                System.out.println("Título: " + tarea.getTitulo());
                System.out.println("Descripción: " + tarea.getDescripcion());
                System.out.println("Prioridad: " + tarea.getPrioridad());
                return;
            }
        }

        System.out.println("Tarea no encontrada");
    }
    /*El metodo para exponer el orden de prioridades segunla fecha*/
        public void mostrarTareasConFechaLimite() {
            System.out.println("Tareas con fecha límite:");
            for (Tarea tarea : tareasConFechaLimite) {
                System.out.println("Título: " + tarea.getTitulo());
                System.out.println("Descripción: " + tarea.getDescripcion());
                System.out.println("Prioridad: " + tarea.getPrioridad());
            }
        }
    /*Este metodo Recorrera mi lista de tareas y
     buscara si hay alguna conincidencia con mi busqueda*/
    public void mostrarTodasLasTareas() {
        System.out.println("Todas las tareas:");
        for (Tarea tarea : tareas) {
            System.out.println("Título: " + tarea.getTitulo());
            System.out.println("Descripción: " + tarea.getDescripcion());
            System.out.println("Prioridad: " + tarea.getPrioridad());
        }
    }
}
