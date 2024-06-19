package Paralelas;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Secuencial extends Thread {
    
    private final JTextArea txtAreaInfo;
    private final JTextArea txtASecuential;
    private final JLabel lblTiempoSecuencial;
    private final int tamañoMatriz;
    private int[][] matriz1;
    private int[][] matriz2;
    private int[][] matrizSecuencial;
    private volatile boolean running = true;

    public Secuencial(JTextArea txtAreaInfo, JTextArea txtASecuential, JLabel lblTiempoSecuencial, int tamañoMatriz, int[][] matriz1, int[][] matriz2, int[][] matrizSecuencial) {
        this.txtAreaInfo = txtAreaInfo;
        this.txtASecuential = txtASecuential;
        this.lblTiempoSecuencial = lblTiempoSecuencial;
        this.tamañoMatriz = tamañoMatriz;
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.matrizSecuencial = matrizSecuencial;
    }

    public void stopThread() {
        running = false;
    }

    public void setTimeSecuencial(String tiempoSecuencial) {
        lblTiempoSecuencial.setText("Secuencial : " + tiempoSecuencial + "ms");
    }

    @Override
    public void run() {
        try {
            long time_start, time_end;
            time_start = System.currentTimeMillis();
            txtAreaInfo.append("RESULTADO DE LA MULTIPLICACION DE MATRICES SECUENCIAL: \n");
            txtASecuential.append("RESULTADO DE LA MULTIPLICACION DE MATRICES SECUENCIAL PARALELO: \n");
            
            int filas = matriz1.length;
            int progresoHilo = 0;
            for (int i = 0; i < tamañoMatriz && running; i++) {
                txtAreaInfo.append("[");
                txtASecuential.append("[");
                for (int j = 0; j < tamañoMatriz; j++) {
                    matrizSecuencial[i][j] = 0;
                    for (int k = 0; k < tamañoMatriz; k++) {
                        matrizSecuencial[i][j] += matriz1[i][k] * matriz2[k][j];
                    }
                    txtAreaInfo.append(matrizSecuencial[i][j] + " ");
                    txtASecuential.append(matrizSecuencial[i][j] + " ");
                    if (j == tamañoMatriz - 1) {
                        txtAreaInfo.append("]\n");
                        txtASecuential.append("]\n");
                    }
                }
                progresoHilo++;
                double porcentaje = ((i + 1) * 100.0) / filas;
            }

            time_end = System.currentTimeMillis();
            int resultadoMS = (int) (time_end - time_start);
            String resMS = String.valueOf(resultadoMS);
            setTimeSecuencial(resMS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
