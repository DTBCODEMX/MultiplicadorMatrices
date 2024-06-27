import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Cliente RMI con interfaz gráfica que se conecta al servidor RMI para realizar la multiplicación de matrices.
 */
public class ClientGUI extends Application {

    private TextArea logArea;
    private MatrixMultiplication service;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            service = (MatrixMultiplication) Naming.lookup("rmi://<server_ip>/MatrixMultiplicationService");
            service.registerClient(new ClientCallbackImpl());

            BorderPane root = new BorderPane();
            logArea = new TextArea();
            logArea.setEditable(false);
            root.setCenter(logArea);

            Scene scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Cliente RMI - Multiplicación de Matrices");
            primaryStage.show();

            log("Cliente RMI iniciado.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo conectar al servidor RMI.");
        }
    }

    /**
     * Agrega un mensaje al área de registro.
     * @param message El mensaje a agregar.
     */
    private void log(String message) {
        logArea.appendText(message + "\n");
    }

    /**
     * Muestra una alerta de error.
     * @param title Título de la alerta.
     * @param message Mensaje de la alerta.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Implementación de la interfaz de callback del cliente.
     */
    private class ClientCallbackImpl extends UnicastRemoteObject implements ClientCallback {
        protected ClientCallbackImpl() throws RemoteException {
            super();
        }

        @Override
        public void notifyClient(String message) throws RemoteException {
            log(message);
        }
    }
}
