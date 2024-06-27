import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface remota para la multiplicación de matrices y registro de clientes.
 */
public interface MatrixMultiplication extends Remote {
    int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) throws RemoteException;
    void registerClient(ClientCallback client) throws RemoteException;
}
