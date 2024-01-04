package componentes;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class HiloUI extends javax.swing.JPanel {
    private String numHilo;
    private BarraPorcentaje progreso;
    
    public HiloUI(String numHilo) {
        initComponents();
        this.numHilo = numHilo;
        this.progreso = new BarraPorcentaje();
        
        add(progreso, new AbsoluteConstraints(10, 35, 250, 25));
        lblThread.setText("Hilo: " + numHilo);
    }
    
    public void actualizarPorcentaje(double porcentaje) {
        int ancho = (int) ((porcentaje * 250) / 100);
        
        String textoEstado = String.format("%d", (int)porcentaje);
        lblThread.setText("Hilo: " + numHilo + "        " + textoEstado + "%");
        
        progreso.setAnchoPorcentaje(ancho);
        progreso.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblThread = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblThread.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThread.setForeground(new java.awt.Color(255, 255, 255));
        lblThread.setText("Hilo 1");
        add(lblThread, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));
    }// </editor-fold>//GEN-END:initComponents

    class BarraPorcentaje extends JPanel {
        
        private double anchoPorcentaje;
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, (int) anchoPorcentaje, (int) getHeight());
        }
        
        public void setAnchoPorcentaje(double anchoPorcentaje) {
            this.anchoPorcentaje = anchoPorcentaje;
        }
        
        public double getAnchoPorcentaje() {
            return this.anchoPorcentaje;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblThread;
    // End of variables declaration//GEN-END:variables
}
