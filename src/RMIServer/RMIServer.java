import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Servidor RMI que registra la implementación de MatrixMultiplication.
 */
public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Iniciar el registro RMI en el puerto 1099
            MatrixMultiplicationImpl obj = new MatrixMultiplicationImpl();
            Naming.rebind("MatrixMultiplicationService", obj);
            System.out.println("Matrix Multiplication Service is ready.");
        } catch (Exception e) {
            System.out.println("Server failed: " + e);
        }
    }
}
