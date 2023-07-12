package ProyectoFinal;

class Tarea {
    private String titulo;
    private String descripcion;
    private int prioridad;

    /*Este es el constructor de la clase */
    public Tarea(String titulo, String descripcion, int prioridad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }
    //Mediante estos metodos se le pasan los valores a los atributos
    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }
}
