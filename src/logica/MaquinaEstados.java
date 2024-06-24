package logica;

/**
 * Clase que gestiona la máquina de estados de la aplicación.
 */
public class MaquinaEstados {

    private Estado estadoActual;

    /**
     * Constructor que inicializa la máquina de estados en el estado INICIO.
     */
    public MaquinaEstados() {
        estadoActual = Estado.INICIO; // Estado inicial
    }

    /**
     * Método para obtener el estado actual.
     *
     * @return El estado actual de la máquina de estados.
     */
    public Estado getEstadoActual() {
        return estadoActual;
    }

    /**
     * Método para cambiar el estado de la máquina de estados.
     *
     * @param nuevoEstado El nuevo estado al que se debe cambiar.
     */
    public void cambiarEstado(Estado nuevoEstado) {
        estadoActual = nuevoEstado;
    }
}
