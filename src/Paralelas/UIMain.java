package Paralelas;

import componentes.HiloUI;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UIMain extends javax.swing.JFrame{

    Concurrente objConcurrente;
    ArrayList<HiloUI> hilosUI;
    boolean secuencial = false;
    boolean concurrente = false;
    int tamañoMatriz, numHilos;
    int[][] matriz1;
    int[][] matriz2;
    int[][] matrizSecuencial;
    int[][] matrizConcurrente;
;
    public UIMain() throws RemoteException {
        initComponents();
        this.setLocationRelativeTo(null);
        objConcurrente = new Concurrente();
        hilosUI = new ArrayList<>();
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
                        txtAreaMatrix1.append("]\n");  //termina de acomodar los numeros aleatorios con append
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
        pnlContainer.revalidate();
        pnlContainer.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBoard = new javax.swing.JPanel();
        lblTiempo = new javax.swing.JLabel();
        lblTiempoSecuencial = new javax.swing.JLabel();
        lblTiempoConcurrente = new javax.swing.JLabel();
        lblMatrizSize = new javax.swing.JLabel();
        lblCantHilos = new javax.swing.JLabel();
        pnlMatrixAB = new javax.swing.JPanel();
        scrllPneAreaMatrix1 = new javax.swing.JScrollPane();
        txtAreaMatrix1 = new javax.swing.JTextArea();
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
        pblBtns = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
        btnSecuential = new javax.swing.JButton();
        btnConcurrent = new javax.swing.JButton();
        txtResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROYECTO FINAL 21310446");
        setMaximumSize(new java.awt.Dimension(0, 0));

        pnlBoard.setBackground(new java.awt.Color(255, 153, 153));
        pnlBoard.setMaximumSize(null);

        lblTiempo.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        lblTiempo.setForeground(new java.awt.Color(255, 255, 255));
        lblTiempo.setText("TIEMPO DE EJECUCION");

        lblTiempoSecuencial.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        lblTiempoSecuencial.setForeground(new java.awt.Color(255, 255, 255));
        lblTiempoSecuencial.setText("Secuencial : ");

        lblTiempoConcurrente.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        lblTiempoConcurrente.setForeground(new java.awt.Color(255, 255, 255));
        lblTiempoConcurrente.setText("Concurrente : ");

        lblMatrizSize.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        lblMatrizSize.setForeground(new java.awt.Color(255, 255, 255));
        lblMatrizSize.setText("Tamaño de la matriz : ");

        lblCantHilos.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        lblCantHilos.setForeground(new java.awt.Color(255, 255, 255));
        lblCantHilos.setText("Cantidad de hilos : ");

        javax.swing.GroupLayout pnlBoardLayout = new javax.swing.GroupLayout(pnlBoard);
        pnlBoard.setLayout(pnlBoardLayout);
        pnlBoardLayout.setHorizontalGroup(
            pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoardLayout.createSequentialGroup()
                .addGroup(pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBoardLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBoardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTiempoSecuencial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlBoardLayout.createSequentialGroup()
                                .addComponent(lblTiempoConcurrente, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlBoardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCantHilos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBoardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMatrizSize, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(lblMatrizSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCantHilos)
                .addGap(102, 102, 102))
        );

        pnlMatrixAB.setLayout(new javax.swing.BoxLayout(pnlMatrixAB, javax.swing.BoxLayout.LINE_AXIS));

        txtAreaMatrix1.setBackground(new java.awt.Color(204, 102, 255));
        txtAreaMatrix1.setColumns(20);
        txtAreaMatrix1.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        txtAreaMatrix1.setRows(5);
        txtAreaMatrix1.setEnabled(false);
        scrllPneAreaMatrix1.setViewportView(txtAreaMatrix1);

        pnlMatrixAB.add(scrllPneAreaMatrix1);

        txtAreaMatrix2.setBackground(new java.awt.Color(153, 255, 255));
        txtAreaMatrix2.setColumns(20);
        txtAreaMatrix2.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        txtAreaMatrix2.setRows(5);
        txtAreaMatrix2.setEnabled(false);
        scrllPneAreaMatrix2.setViewportView(txtAreaMatrix2);

        pnlMatrixAB.add(scrllPneAreaMatrix2);

        pnlInfo.setLayout(new java.awt.BorderLayout());

        scrllPneAreaInfo.setAutoscrolls(true);

        txtAreaInfo.setColumns(20);
        txtAreaInfo.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        txtAreaInfo.setRows(5);
        txtAreaInfo.setEnabled(false);
        txtAreaInfo.setMaximumSize(null);
        txtAreaInfo.setMinimumSize(null);
        txtAreaInfo.setPreferredSize(new java.awt.Dimension(156, 156));
        scrllPneAreaInfo.setViewportView(txtAreaInfo);

        pnlInfo.add(scrllPneAreaInfo, java.awt.BorderLayout.CENTER);

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

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlParallel, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlParallel, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pblBtns.setLayout(new java.awt.GridLayout(2, 0, 5, 5));

        btnStart.setBackground(new java.awt.Color(51, 255, 51));
        btnStart.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 255, 255));
        btnStart.setText("START");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        pblBtns.add(btnStart);

        btnRestart.setBackground(new java.awt.Color(153, 0, 153));
        btnRestart.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        btnRestart.setForeground(new java.awt.Color(255, 255, 255));
        btnRestart.setText("RESTART");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });
        pblBtns.add(btnRestart);

        btnSecuential.setBackground(new java.awt.Color(0, 0, 255));
        btnSecuential.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        btnSecuential.setForeground(new java.awt.Color(255, 255, 255));
        btnSecuential.setText("SECUENTIAL");
        btnSecuential.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecuentialActionPerformed(evt);
            }
        });
        pblBtns.add(btnSecuential);

        btnConcurrent.setBackground(new java.awt.Color(51, 204, 255));
        btnConcurrent.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        btnConcurrent.setForeground(new java.awt.Color(255, 255, 255));
        btnConcurrent.setText("CONCURRENT");
        btnConcurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcurrentActionPerformed(evt);
            }
        });
        pblBtns.add(btnConcurrent);

        txtResultado.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        txtResultado.setText("RESULTADO:");
        txtResultado.setToolTipText("");
        txtResultado.setAlignmentX(10.0F);
        txtResultado.setAlignmentY(2.0F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlMatrixAB, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pblBtns, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlMatrixAB, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(txtResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pblBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSecuentialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecuentialActionPerformed
        if (matriz1 != null && matriz2 != null) {
            Thread hiloSecuencial = new Secuencial(txtAreaInfo, txtASecuential, lblTiempoSecuencial, tamañoMatriz, matriz1, matriz2, matrizSecuencial);
            secuencial = true;
            hiloSecuencial.start();
            secuencial = false;
        } else {
            JOptionPane.showMessageDialog(this, "Presiona start primero para darle valores a la matriz");
        }
    }//GEN-LAST:event_btnSecuentialActionPerformed

    private void btnConcurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcurrentActionPerformed
        if (matriz1 != null && matriz2 != null) {
            int tiempoEjecucion = 0;

            concurrente = true;
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

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        cleanAll();
        iniciar();
    }//GEN-LAST:event_btnRestartActionPerformed

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
    private javax.swing.JButton btnConcurrent;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnSecuential;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel lblCantHilos;
    private javax.swing.JLabel lblMatrizSize;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTiempoConcurrente;
    private javax.swing.JLabel lblTiempoSecuencial;
    private javax.swing.JPanel pblBtns;
    private javax.swing.JPanel pnlBoard;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlMatrixAB;
    private javax.swing.JPanel pnlParallel;
    private javax.swing.JScrollPane scrllPneAreaInfo;
    private javax.swing.JScrollPane scrllPneAreaMatrix1;
    private javax.swing.JScrollPane scrllPneAreaMatrix2;
    private javax.swing.JScrollPane scrllPneConcurrent;
    private javax.swing.JScrollPane scrllPneSecuential;
    private javax.swing.JTextArea txtAConcurrent;
    private javax.swing.JTextArea txtASecuential;
    private javax.swing.JTextArea txtAreaInfo;
    private javax.swing.JTextArea txtAreaMatrix1;
    private javax.swing.JTextArea txtAreaMatrix2;
    private javax.swing.JLabel txtResultado;
    // End of variables declaration//GEN-END:variables
}
