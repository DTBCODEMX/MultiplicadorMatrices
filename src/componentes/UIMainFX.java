package componentes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIMainFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        HiloUIFX hiloUI = new HiloUIFX();
        hiloUI.start(primaryStage);

        primaryStage.setTitle("Multiplicador de matrices");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
