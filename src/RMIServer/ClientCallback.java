import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface remota para callbacks de cliente.
 */
public interface ClientCallback extends Remote {
    void notifyClient(String message) throws RemoteException;
}
