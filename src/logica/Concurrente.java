package logica;

/**
 * Clase que representa un hilo para la multiplicación concurrente de matrices.
 */
public class Concurrente extends Thread {
    private int[][] matriz1;
    private int[][] matriz2;
    private int[][] resultado;
    private int fila;

    /**
     * Constructor para inicializar los valores necesarios para la multiplicación concurrente.
     *
     * @param matriz1 La primera matriz a multiplicar.
     * @param matriz2 La segunda matriz a multiplicar.
     * @param resultado La matriz donde se almacenará el resultado.
     * @param fila La fila de la matriz resultado que este hilo debe calcular.
     */
    public Concurrente(int[][] matriz1, int[][] matriz2, int[][] resultado, int fila) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.resultado = resultado;
        this.fila = fila;
    }

    /**
     * Método que ejecuta el hilo para multiplicar una fila de la matriz.
     */
    @Override
    public void run() {
        for (int j = 0; j < matriz2[0].length; j++) {
            resultado[fila][j] = 0;
            for (int k = 0; k < matriz1[0].length; k++) {
                resultado[fila][j] += matriz1[fila][k] * matriz2[k][j];
            }
        }
    }
}
