import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interface remota para la multiplicación de matrices.
 */
public class MatrixMultiplicationImpl extends UnicastRemoteObject implements MatrixMultiplication {
    private List<ClientCallback> clients;

    protected MatrixMultiplicationImpl() throws RemoteException {
        super();
        clients = new ArrayList<>();
    }

    @Override
    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) throws RemoteException {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        notifyClients("Multiplicación realizada en el servidor RMI.");
        return result;
    }

    @Override
    public void registerClient(ClientCallback client) throws RemoteException {
        clients.add(client);
        notifyClients("Nuevo cliente registrado en el servidor RMI.");
    }

    private void notifyClients(String message) throws RemoteException {
        for (ClientCallback client : clients) {
            client.notifyClient(message);
        }
    }
}
