package Paralelas;

import interfaz.ProgresoListener;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Concurrente {

    final ProgresoListener progresoListener;
    private int numHilos;
    private int tiempoEjecucion;

    public Concurrente(ProgresoListener progresoListener) {
        this.progresoListener = progresoListener;
        this.tiempoEjecucion = 0;
    }
    
    public int[][] multiplicar(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null || matrix2 == null) {
            return null;
        }
        ExecutorService pilaHilos = Executors.newFixedThreadPool(numHilos);
        List<Future> res = new ArrayList<>();
        int filas = matrix1.length;
        int columnasA = matrix1[0].length;
        int columnasB = matrix2[0].length;
        int[][] resultante = new int[filas][columnasB];
        int seccion = filas / numHilos;
        
        long tiempoInicio = System.currentTimeMillis();
        try {
            for (int hilo = 0; hilo < numHilos; hilo++) {
                final int hiloFinal = hilo; //copia final de la variable hilo
                final int filaInicio = hilo * seccion;
                final int filaFin = (hilo == numHilos - 1) ? filas : (hilo + 1) * seccion;
                
                res.add(pilaHilos.submit(() -> {
                    int progresoHilo = 0;
                    for (int i = filaInicio; i < filaFin; i++) {
                        for (int j = 0; j < columnasB; j++) {
                            for (int k = 0; k < columnasA; k++) {
                                resultante[i][j] += matrix1[i][k] * matrix2[k][j];
                            }
                        }
                        progresoHilo++;
                        double porcentaje = (progresoHilo * 100.0) / (filaFin - filaInicio);
                        progresoListener.progresoActualizado(hiloFinal, porcentaje);
                    }
                    return null;
                }));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pilaHilos.shutdown();
        }
        
        long tiempoFinal = System.currentTimeMillis();
        tiempoEjecucion = (int) (tiempoFinal - tiempoInicio);
        return resultante;
    }
    
    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }
    
    public void setNumHilos(int numHilos) {
        this.numHilos = numHilos;
    }
    
}
