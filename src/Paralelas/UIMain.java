package Paralelas;

import componentes.HiloUI;
import interfaz.ProgresoListener;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UIMain extends javax.swing.JFrame implements ProgresoListener {

    Concurrente objConcurrente;
    ArrayList<HiloUI> hilosUI;
    boolean secuencial = false, concurrente = false;
    int tamañoMatriz, numHilos;
    int[][] matriz1;
    int[][] matriz2;
    int[][] matrizSecuencial;
    int[][] matrizConcurrente;

    public UIMain() throws RemoteException {
        initComponents();
        this.setLocationRelativeTo(null);
        objConcurrente = new Concurrente(this);
        hilosUI = new ArrayList<>();
    }

    @Override
    public void progresoActualizado(int hilo, double porcentaje) {
        hilosUI.get(hilo).actualizarPorcentaje(porcentaje);
        pnlContenedorHilos.repaint();
        pnlContenedorHilos.revalidate();
    }

    public void setProcessBar() {
        hilosUI.removeAll(hilosUI);
        pnlContenedorHilos.removeAll();
        if (secuencial) {
            HiloUI objHiloUI = new HiloUI("" + 1);
            pnlContenedorHilos.add(objHiloUI);
            hilosUI.add(objHiloUI);

        } else if (concurrente) {
            for (int i = 0; i < numHilos; i++) {
                HiloUI objHiloUI = new HiloUI("" + 1);
                pnlContenedorHilos.add(objHiloUI);
                hilosUI.add(objHiloUI);
            }
        }
        pnlContenedorHilos.repaint();
        pnlContenedorHilos.revalidate();
    }

    private void iniciar() {
        String tamañoMatrizString = JOptionPane.showInputDialog(this, "Ingrese la dimension de la matriz:");
        tamañoMatriz = Integer.parseInt(tamañoMatrizString);
        lblMatrizSize.setText("TAMAÑO DE LA MATRIZ: (" + tamañoMatriz + "x" + tamañoMatriz + ")");

        numHilos = Runtime.getRuntime().availableProcessors();
        String numHilosString = JOptionPane.showInputDialog(this, "Ingrese la cantidad de hilos que quieres usar");
        numHilos = Integer.parseInt(numHilosString);

        lblCantHilos.setText("CANTIDAD DE HILOS: " + numHilos);

        matriz1 = new int[tamañoMatriz][tamañoMatriz];
        matriz2 = new int[tamañoMatriz][tamañoMatriz];

        matrizSecuencial = new int[tamañoMatriz][tamañoMatriz];
        matrizConcurrente = new int[tamañoMatriz][tamañoMatriz];

        int numMatriz = 1;
        ingresarValoresAleatorios(matriz1, tamañoMatriz, numMatriz);
        ingresarValoresAleatorios(matriz2, tamañoMatriz, numMatriz + 1);
    }

    public void ingresarValoresAleatorios(int[][] matriz, int tamañoMatriz, int numMatriz) {
        if (numMatriz == 1) {
            txtAreaMatrix1.append("Ingresando valores aleatorios en la matriz " + numMatriz + "... \n");
            for (int y = 0; y < tamañoMatriz; y++) {
                txtAreaMatrix1.append("[");
                for (int x = 0; x < tamañoMatriz; x++) {
                    matriz[y][x] = (int) (Math.random() * 10 + 1);
                    String info = String.valueOf(matriz[y][x]);
                    if (matriz[y][x] >= 10) {
                        txtAreaMatrix1.append(info + "   ");
                    } else {
                        txtAreaMatrix1.append(info + "    ");
                    }

                    if (x == tamañoMatriz - 1) {
                        txtAreaMatrix1.append("]\n");
                    }
                }
            }
        } else if (numMatriz == 2) {
            txtAreaMatrix2.append("Ingresando valores aleatorios en la matriz " + numMatriz + "... \n");
            for (int y = 0; y < tamañoMatriz; y++) {
                txtAreaMatrix2.append("[");
                for (int x = 0; x < tamañoMatriz; x++) {
                    matriz[y][x] = (int) (Math.random() * 10 + 1);
                    String info = String.valueOf(matriz[y][x]);
                    if (matriz[y][x] >= 10) {
                        txtAreaMatrix2.append(info + "   ");
                    } else {
                        txtAreaMatrix2.append(info + "    ");
                    }

                    if (x == tamañoMatriz - 1) {
                        txtAreaMatrix2.append("]\n");
                    }
                }
            }
        }

    }

    private void cleanAll() {
        lblTiempoSecuencial.setText("Secuencial : ");
        lblTiempoConcurrente.setText("Concurrente : ");
        lblMatrizSize.setText("Tamaño de la matriz : ");
        lblCantHilos.setText("Cantidad de hilos : ");
        txtAreaMatrix1.setText("");
        txtAreaMatrix2.setText("");
        txtAreaInfo.setText("");
        txtASecuential.setText("");
        txtAConcurrent.setText("");
    }

    public void showPnlSecuentialConcurrent() {
        pnlContainer.removeAll();
        pnlContainer.add(pnlInfo);
        pnlContainer.repaint();
        pnlContainer.revalidate();
    }

    public void showPnlBoth() {
        pnlContainer.removeAll();
        pnlContainer.add(pnlParallel);
        pnlContainer.repaint();
        pnlContainer.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBoard = new javax.swing.JPanel();
        pblBtns = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
        btnSecuential = new javax.swing.JButton();
        btnConcurrent = new javax.swing.JButton();
        btnBoth = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblTiempo = new javax.swing.JLabel();
        lblTiempoSecuencial = new javax.swing.JLabel();
        lblTiempoConcurrente = new javax.swing.JLabel();
        lblMatrizSize = new javax.swing.JLabel();
        lblCantHilos = new javax.swing.JLabel();
        lblTiempoParalelo = new javax.swing.JLabel();
        pnlMatrixAB = new javax.swing.JPanel();
        scrllPneAreaMatrix1 = new javax.swing.JScrollPane();
        txtAreaMatrix1 = new javax.swing.JTextArea();
        lblX = new javax.swing.JLabel();
        scrllPneAreaMatrix2 = new javax.swing.JScrollPane();
        txtAreaMatrix2 = new javax.swing.JTextArea();
        pnlContainer = new javax.swing.JPanel();
        pnlInfo = new javax.swing.JPanel();
        scrllPneAreaInfo = new javax.swing.JScrollPane();
        txtAreaInfo = new javax.swing.JTextArea();
        pnlParallel = new javax.swing.JPanel();
        scrllPneSecuential = new javax.swing.JScrollPane();
        txtASecuential = new javax.swing.JTextArea();
        scrllPneConcurrent = new javax.swing.JScrollPane();
        txtAConcurrent = new javax.swing.JTextArea();
        scrllPneC = new javax.swing.JScrollPane();
        pnlContenedorHilos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pblBtns.setLayout(new java.awt.GridLayout(3, 0, 5, 5));

        btnStart.setBackground(new java.awt.Color(0, 102, 204));
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        pblBtns.add(btnStart);

        btnRestart.setBackground(new java.awt.Color(0, 153, 255));
        btnRestart.setText("Restart");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });
        pblBtns.add(btnRestart);

        btnSecuential.setBackground(new java.awt.Color(0, 255, 0));
        btnSecuential.setText("Secuential");
        btnSecuential.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecuentialActionPerformed(evt);
            }
        });
        pblBtns.add(btnSecuential);

        btnConcurrent.setBackground(new java.awt.Color(255, 0, 0));
        btnConcurrent.setText("Concurrent");
        btnConcurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcurrentActionPerformed(evt);
            }
        });
        pblBtns.add(btnConcurrent);

        btnBoth.setBackground(new java.awt.Color(255, 153, 0));
        btnBoth.setText("Both");
        btnBoth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBothActionPerformed(evt);
            }
        });
        pblBtns.add(btnBoth);

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clean TextArea");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        pblBtns.add(btnClear);

        lblTiempo.setText("TIEMPO DE EJECUCION");

        lblTiempoSecuencial.setText("Secuencial : ");

        lblTiempoConcurrente.setText("Concurrente : ");

        lblMatrizSize.setText("Tamaño de la matriz : ");

        lblCantHilos.setText("Cantidad de hilos : ");

        lblTiempoParalelo.setText("Paralelo : ");

        javax.swing.GroupLayout pnlBoardLayout = new javax.swing.GroupLayout(pnlBoard);
        pnlBoard.setLayout(pnlBoardLayout);
        pnlBoardLayout.setHorizontalGroup(
            pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoardLayout.createSequentialGroup()
                .addGroup(pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBoardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBoardLayout.createSequentialGroup()
                                .addComponent(lblMatrizSize, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblTiempoParalelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlBoardLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBoardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTiempoConcurrente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTiempoSecuencial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlBoardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCantHilos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBoardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pblBtns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlBoardLayout.setVerticalGroup(
            pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTiempoSecuencial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTiempoConcurrente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTiempoParalelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMatrizSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCantHilos)
                .addGap(18, 18, 18)
                .addComponent(pblBtns, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pnlMatrixAB.setLayout(new javax.swing.BoxLayout(pnlMatrixAB, javax.swing.BoxLayout.LINE_AXIS));

        txtAreaMatrix1.setColumns(20);
        txtAreaMatrix1.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        txtAreaMatrix1.setRows(5);
        txtAreaMatrix1.setEnabled(false);
        scrllPneAreaMatrix1.setViewportView(txtAreaMatrix1);

        pnlMatrixAB.add(scrllPneAreaMatrix1);

        lblX.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblX.setText("X");
        pnlMatrixAB.add(lblX);

        txtAreaMatrix2.setColumns(20);
        txtAreaMatrix2.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        txtAreaMatrix2.setRows(5);
        txtAreaMatrix2.setEnabled(false);
        scrllPneAreaMatrix2.setViewportView(txtAreaMatrix2);

        pnlMatrixAB.add(scrllPneAreaMatrix2);

        pnlContainer.setLayout(new java.awt.CardLayout());

        txtAreaInfo.setColumns(20);
        txtAreaInfo.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        txtAreaInfo.setRows(5);
        txtAreaInfo.setEnabled(false);
        scrllPneAreaInfo.setViewportView(txtAreaInfo);

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1391, Short.MAX_VALUE)
            .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlInfoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(scrllPneAreaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 1391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
            .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlInfoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(scrllPneAreaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlContainer.add(pnlInfo, "card4");

        pnlParallel.setLayout(new javax.swing.BoxLayout(pnlParallel, javax.swing.BoxLayout.LINE_AXIS));

        txtASecuential.setColumns(20);
        txtASecuential.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        txtASecuential.setRows(5);
        txtASecuential.setEnabled(false);
        scrllPneSecuential.setViewportView(txtASecuential);

        pnlParallel.add(scrllPneSecuential);

        txtAConcurrent.setColumns(20);
        txtAConcurrent.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        txtAConcurrent.setRows(5);
        txtAConcurrent.setEnabled(false);
        scrllPneConcurrent.setViewportView(txtAConcurrent);

        pnlParallel.add(scrllPneConcurrent);

        pnlContainer.add(pnlParallel, "card3");

        pnlContenedorHilos.setBackground(new java.awt.Color(0, 0, 0));
        pnlContenedorHilos.setLayout(new javax.swing.BoxLayout(pnlContenedorHilos, javax.swing.BoxLayout.Y_AXIS));
        scrllPneC.setViewportView(pnlContenedorHilos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrllPneC, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMatrixAB, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 1391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMatrixAB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrllPneC)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSecuentialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecuentialActionPerformed
        if (matriz1 != null && matriz2 != null) {
            Thread hiloSecuencial = new Secuencial(txtAreaInfo, txtASecuential, this, lblTiempoSecuencial, tamañoMatriz, matriz1, matriz2, matrizSecuencial);
            secuencial = true;
            setProcessBar();
            hiloSecuencial.start();
            secuencial = false;
        } else {
            JOptionPane.showMessageDialog(this, "Start the program first to give values to both of the matrix");
        }
    }//GEN-LAST:event_btnSecuentialActionPerformed

    private void btnConcurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcurrentActionPerformed
        if (matriz1 != null && matriz2 != null) {
            int tiempoEjecucion = 0;

            concurrente = true;
            setProcessBar();
            objConcurrente.setNumHilos(numHilos);
            matrizConcurrente = objConcurrente.multiplicar(matriz1, matriz2);
            tiempoEjecucion = objConcurrente.getTiempoEjecucion();
            lblTiempoConcurrente.setText("Concurrente : " + tiempoEjecucion + "ms");
            for (int i = 0; i < tamañoMatriz; i++) {
                for (int j = 0; j < tamañoMatriz; j++) {
                    txtAreaInfo.append(matrizConcurrente[i][j] + " ");
                    txtAConcurrent.append(matrizConcurrente[i][j] + " ");
                }
                txtAreaInfo.append("\n");
                txtAConcurrent.append("\n");
            }

            concurrente = false;
        } else {
            JOptionPane.showMessageDialog(this, "Start the program first to give valeues to both of the matrix");
        }
    }//GEN-LAST:event_btnConcurrentActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtAreaInfo.setText("");
        txtASecuential.setText("");
        txtAConcurrent.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        cleanAll();
        iniciar();
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnBothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBothActionPerformed

    }//GEN-LAST:event_btnBothActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        btnStart.setEnabled(false);
        btnRestart.setEnabled(true);
        iniciar();
    }//GEN-LAST:event_btnStartActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UIMain().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(UIMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoth;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnConcurrent;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnSecuential;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel lblCantHilos;
    private javax.swing.JLabel lblMatrizSize;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTiempoConcurrente;
    private javax.swing.JLabel lblTiempoParalelo;
    private javax.swing.JLabel lblTiempoSecuencial;
    private javax.swing.JLabel lblX;
    private javax.swing.JPanel pblBtns;
    private javax.swing.JPanel pnlBoard;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlContenedorHilos;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlMatrixAB;
    private javax.swing.JPanel pnlParallel;
    private javax.swing.JScrollPane scrllPneAreaInfo;
    private javax.swing.JScrollPane scrllPneAreaMatrix1;
    private javax.swing.JScrollPane scrllPneAreaMatrix2;
    private javax.swing.JScrollPane scrllPneC;
    private javax.swing.JScrollPane scrllPneConcurrent;
    private javax.swing.JScrollPane scrllPneSecuential;
    private javax.swing.JTextArea txtAConcurrent;
    private javax.swing.JTextArea txtASecuential;
    private javax.swing.JTextArea txtAreaInfo;
    private javax.swing.JTextArea txtAreaMatrix1;
    private javax.swing.JTextArea txtAreaMatrix2;
    // End of variables declaration//GEN-END:variables
}
