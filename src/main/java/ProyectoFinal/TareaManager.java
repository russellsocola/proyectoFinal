package ProyectoFinal;

import java.util.*;

class TareaManager {
    private Stack<Tarea> deshacerPila;
    private Queue<Tarea> tareasConFechaLimite;
    //Creo una lista donde se almacenaran las tareas
    private List<Tarea> tareas;

    public TareaManager() {
        deshacerPila = new Stack<>();
        tareasConFechaLimite = new LinkedList<>();
        tareas = new ArrayList<>();
    }

    public void agregarTarea(String titulo, String descripcion, int prioridad) {
        Tarea tarea = new Tarea(titulo, descripcion, prioridad);
        tareas.add(tarea);

        if (prioridad > 0) {
            tareasConFechaLimite.offer(tarea);
        }
    }

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
        if (!deshacerPila.isEmpty()) {
            Tarea tarea = deshacerPila.pop();
            tareas.add(tarea);
            if (tarea.getPrioridad() > 0) {
                tareasConFechaLimite.offer(tarea);
            }
            System.out.println("Deshacer completado: " + tarea.getTitulo());
        } else {
            System.out.println("No hay acciones para deshacer");
        }
    }

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

    public void mostrarTareasConFechaLimite() {
        System.out.println("Tareas con fecha límite:");
        for (Tarea tarea : tareasConFechaLimite) {
            System.out.println("Título: " + tarea.getTitulo());
            System.out.println("Descripción: " + tarea.getDescripcion());
            System.out.println("Prioridad: " + tarea.getPrioridad());
        }
    }

    public void mostrarTodasLasTareas() {
        System.out.println("Todas las tareas:");
        for (Tarea tarea : tareas) {
            System.out.println("Título: " + tarea.getTitulo());
            System.out.println("Descripción: " + tarea.getDescripcion());
            System.out.println("Prioridad: " + tarea.getPrioridad());
        }
    }
}
