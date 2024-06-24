package logica;

/**
 * Clase que representa la multiplicación secuencial de matrices.
 */
public class Secuencial {
    private int[][] matriz1;
    private int[][] matriz2;
    private int[][] resultado;

    /**
     * Constructor para inicializar las matrices.
     *
     * @param matriz1 La primera matriz a multiplicar.
     * @param matriz2 La segunda matriz a multiplicar.
     */
    public Secuencial(int[][] matriz1, int[][] matriz2) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.resultado = new int[matriz1.length][matriz2[0].length]; // Inicializa la matriz resultado
    }

    /**
     * Método para multiplicar las matrices de forma secuencial.
     *
     * @return La matriz resultado de la multiplicación.
     */
    public int[][] multiplicar() {
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < matriz1[0].length; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return resultado; // Devuelve la matriz resultado
    }
}
