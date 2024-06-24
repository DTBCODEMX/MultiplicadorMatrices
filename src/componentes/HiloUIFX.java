package componentes;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import logica.Estado;
import logica.MaquinaEstados;
import logica.Secuencial;
import logica.Concurrente;

import java.util.Random;

public class HiloUIFX extends Application {

    private GridPane inputPane;
    private HBox buttonPane;
    private GridPane resultPane;
    private VBox mainPane;
    private Label lblTiempoSecuencial, lblTiempoConcurrente;
    private TextField txtMatrizFilas, txtMatrizColumnas, txtCantHilos;
    private TextArea txtAreaMatrix1, txtAreaMatrix2, txtASecuential, txtAConcurrent;
    private Button btnStart, btnRestart, btnSecuential, btnConcurrent;

    private MaquinaEstados maquinaEstados;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        maquinaEstados = new MaquinaEstados(); // Inicializa la máquina de estados
        initComponents(); // Inicializa los componentes de la interfaz

        mainPane = new VBox(10, inputPane, buttonPane, resultPane);
        mainPane.setPadding(new Insets(10));

        // Efecto de deslizamiento al cargar la interfaz
        TranslateTransition slideIn = new TranslateTransition(Duration.millis(500), mainPane);
        slideIn.setFromX(-1000);
        slideIn.setToX(0);
        slideIn.play();

        // Efecto de entrada para los componentes individuales
        for (Node node : mainPane.getChildren()) {
            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), node);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();
        }

        Scene scene = new Scene(mainPane, 800, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Multiplicador Matricial");
        primaryStage.show();
    }

    private void initComponents() {
        inputPane = new GridPane();
        inputPane.setPadding(new Insets(10));
        inputPane.setHgap(10);
        inputPane.setVgap(10);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHgrow(Priority.ALWAYS);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setHgrow(Priority.ALWAYS);
        inputPane.getColumnConstraints().addAll(col1, col2, col3, col4);

        Label lblMatrizFilas = crearEtiqueta("Filas de Matriz:");
        txtMatrizFilas = crearCampoTexto();

        Label lblMatrizColumnas = crearEtiqueta("Columnas de Matriz:");
        txtMatrizColumnas = crearCampoTexto();

        Label lblCantHilosTexto = crearEtiqueta("Cantidad de Hilos:");
        txtCantHilos = crearCampoTexto();

        inputPane.add(lblMatrizFilas, 0, 0);
        inputPane.add(txtMatrizFilas, 1, 0);
        inputPane.add(lblMatrizColumnas, 2, 0);
        inputPane.add(txtMatrizColumnas, 3, 0);
        inputPane.add(lblCantHilosTexto, 0, 1);
        inputPane.add(txtCantHilos, 1, 1);

        btnStart = crearBoton("Iniciar");
        btnRestart = crearBoton("Reiniciar");
        btnSecuential = crearBoton("Secuencial");
        btnConcurrent = crearBoton("Concurrente");

        agregarAnimacionBoton(btnStart, 2, 1.05);
        agregarAnimacionBoton(btnRestart, -2, 1.05);
        agregarAnimacionBoton(btnSecuential, 2, 1.05);
        agregarAnimacionBoton(btnConcurrent, -2, 1.05);

        buttonPane = new HBox(10, btnStart, btnRestart, btnSecuential, btnConcurrent);
        buttonPane.setPadding(new Insets(10));
        buttonPane.setStyle("-fx-alignment: center;");

        txtAreaMatrix1 = crearAreaTexto("Matriz 1");
        txtAreaMatrix2 = crearAreaTexto("Matriz 2");
        txtASecuential = crearAreaTexto("Resultado Secuencial");
        txtAConcurrent = crearAreaTexto("Resultado Concurrente");

        resultPane = new GridPane();
        resultPane.setPadding(new Insets(10));
        resultPane.setHgap(10);
        resultPane.setVgap(10);
        resultPane.add(crearScrollPane(txtAreaMatrix1), 0, 0);
        resultPane.add(crearScrollPane(txtAreaMatrix2), 1, 0);
        resultPane.add(crearScrollPane(txtASecuential), 0, 1);
        resultPane.add(crearScrollPane(txtAConcurrent), 1, 1);

        lblTiempoSecuencial = crearEtiqueta("Tiempo Secuencial");
        lblTiempoConcurrente = crearEtiqueta("Tiempo Concurrente");

        resultPane.add(lblTiempoSecuencial, 0, 2);
        resultPane.add(lblTiempoConcurrente, 1, 2);

        btnStart.setOnAction(e -> {
            if (maquinaEstados.getEstadoActual() == Estado.INICIO) {
                configurarMatricesDesdeCampos();
            }
        });

        btnRestart.setOnAction(e -> reiniciarInterfaz());

        btnSecuential.setOnAction(e -> {
            if (maquinaEstados.getEstadoActual() == Estado.MULTIPLICAR) {
                ejecutarMultiplicacionSecuencial();
            }
        });

        btnConcurrent.setOnAction(e -> {
            if (maquinaEstados.getEstadoActual() == Estado.MULTIPLICAR) {
                ejecutarMultiplicacionConcurrente();
            }
        });
    }

    private Label crearEtiqueta(String texto) {
        Label etiqueta = new Label(texto);
        etiqueta.getStyleClass().add("label");

        // Añadir efecto de parpadeo a los títulos
        FadeTransition blink = new FadeTransition(Duration.millis(1000), etiqueta);
        blink.setFromValue(1.0);
        blink.setToValue(0.5);
        blink.setCycleCount(Animation.INDEFINITE);
        blink.setAutoReverse(true);
        blink.play();

        return etiqueta;
    }

    private TextArea crearAreaTexto(String titulo) {
        TextArea areaTexto = new TextArea();
        areaTexto.setPromptText(titulo);
        areaTexto.getStyleClass().add("text-area");
        areaTexto.setEffect(new Reflection()); // Añadir efecto de reflejo
        VBox.setVgrow(areaTexto, Priority.ALWAYS);
        return areaTexto;
    }

    private TextField crearCampoTexto() {
        TextField campoTexto = new TextField();
        campoTexto.getStyleClass().add("text-field");
        campoTexto.setEffect(new Reflection()); // Añadir efecto de reflejo
        return campoTexto;
    }

    private Button crearBoton(String texto) {
        Button boton = new Button(texto);
        boton.getStyleClass().add("button");
        return boton;
    }

    private ScrollPane crearScrollPane(TextArea textArea) {
        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.getStyleClass().add("scroll-pane");
        VBox.setVgrow(scrollPane, Priority.ALWAYS);

        // Añadir efecto de sombra y zoom
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.color(0.4, 0.5, 0.5));
        scrollPane.setEffect(shadow);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), scrollPane);
        scaleTransition.setToX(1.02);
        scaleTransition.setToY(1.02);

        scrollPane.setOnMouseEntered(e -> scaleTransition.playFromStart());
        scrollPane.setOnMouseExited(e -> {
            scaleTransition.stop();
            scrollPane.setScaleX(1);
            scrollPane.setScaleY(1);
        });

        return scrollPane;
    }

    private void agregarAnimacionBoton(Button boton, double rotateAngle, double scaleSize) {
        // Crear una transición de rotación sutil
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(300), boton);
        rotateTransition.setByAngle(rotateAngle);

        // Crear una transición de escala sutil
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), boton);
        scaleTransition.setToX(scaleSize);
        scaleTransition.setToY(scaleSize);

        // Crear sombra
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.color(0.4, 0.5, 0.5));
        boton.setOnMouseEntered(e -> {
            rotateTransition.playFromStart();
            scaleTransition.playFromStart();
            boton.setEffect(shadow);
        });
        boton.setOnMouseExited(e -> {
            rotateTransition.stop();
            scaleTransition.stop();
            boton.setRotate(0);
            boton.setScaleX(1);
            boton.setScaleY(1);
            boton.setEffect(null);
        });

        // Efecto de rebote al hacer clic
        boton.setOnAction(e -> {
            ScaleTransition bounce = new ScaleTransition(Duration.millis(150), boton);
            bounce.setFromX(1.0);
            bounce.setFromY(1.0);
            bounce.setToX(0.9);
            bounce.setToY(0.9);
            bounce.setAutoReverse(true);
            bounce.setCycleCount(2);
            bounce.play();
        });
    }

    private void configurarMatricesDesdeCampos() {
        try {
            int filas = Integer.parseInt(txtMatrizFilas.getText());
            int columnas = Integer.parseInt(txtMatrizColumnas.getText());
            int hilos = Integer.parseInt(txtCantHilos.getText());

            configurarMatrices(filas, columnas);
            maquinaEstados.cambiarEstado(Estado.MULTIPLICAR);
        } catch (NumberFormatException e) {
            showAlert("Error", "Ingrese valores válidos para filas, columnas y cantidad de hilos.");
        }
    }

    private void configurarMatrices(int filas, int columnas) {
        Random rand = new Random();
        txtAreaMatrix1.clear();
        txtAreaMatrix2.clear();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                txtAreaMatrix1.appendText(rand.nextInt(10) + " ");
                txtAreaMatrix2.appendText(rand.nextInt(10) + " ");
            }
            txtAreaMatrix1.appendText("\n");
            txtAreaMatrix2.appendText("\n");
        }
    }

    private void reiniciarInterfaz() {
        maquinaEstados.cambiarEstado(Estado.INICIO);
        txtMatrizFilas.clear();
        txtMatrizColumnas.clear();
        txtCantHilos.clear();
        txtAreaMatrix1.clear();
        txtAreaMatrix2.clear();
        txtASecuential.clear();
        txtAConcurrent.clear();
        lblTiempoSecuencial.setText("Tiempo Secuencial");
        lblTiempoConcurrente.setText("Tiempo Concurrente");
    }

    private void ejecutarMultiplicacionSecuencial() {
        int[][] matriz1 = obtenerMatrizDesdeTexto(txtAreaMatrix1);
        int[][] matriz2 = obtenerMatrizDesdeTexto(txtAreaMatrix2);
        if (matriz1[0].length != matriz2.length) {
            showAlert("Error", "Las matrices no se pueden multiplicar. Columnas de Matriz 1 deben ser igual a filas de Matriz 2.");
            return;
        }
        Secuencial secuencial = new Secuencial(matriz1, matriz2);

        long inicio = System.nanoTime();
        int[][] resultado = secuencial.multiplicar();
        long fin = System.nanoTime();

        // Efecto de desvanecimiento al mostrar el resultado
        FadeTransition fadeIn = new FadeTransition(Duration.millis(500), txtASecuential);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        txtASecuential.setOpacity(0);
        txtASecuential.setText("");
        mostrarResultado(resultado, txtASecuential);
        fadeIn.play();

        lblTiempoSecuencial.setText("Tiempo Secuencial: " + (fin - inicio) / 1e6 + " ms");
    }

    private void ejecutarMultiplicacionConcurrente() {
        int[][] matriz1 = obtenerMatrizDesdeTexto(txtAreaMatrix1);
        int[][] matriz2 = obtenerMatrizDesdeTexto(txtAreaMatrix2);
        if (matriz1[0].length != matriz2.length) {
            showAlert("Error", "Las matrices no se pueden multiplicar. Columnas de Matriz 1 deben ser igual a filas de Matriz 2.");
            return;
        }
        int filas = matriz1.length;
        int columnas = matriz2[0].length;
        int[][] resultado = new int[filas][columnas];
        Thread[] hilos = new Thread[filas];

        long inicio = System.nanoTime();
        for (int i = 0; i < filas; i++) {
            hilos[i] = new Thread(new Concurrente(matriz1, matriz2, resultado, i));
            hilos[i].start();
        }
        for (int i = 0; i < filas; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long fin = System.nanoTime();

        // Efecto de desvanecimiento al mostrar el resultado
        FadeTransition fadeIn = new FadeTransition(Duration.millis(500), txtAConcurrent);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        txtAConcurrent.setOpacity(0);
        txtAConcurrent.setText("");
        mostrarResultado(resultado, txtAConcurrent);
        fadeIn.play();

        lblTiempoConcurrente.setText("Tiempo Concurrente: " + (fin - inicio) / 1e6 + " ms");
    }

    private int[][] obtenerMatrizDesdeTexto(TextArea textArea) {
        String[] filas = textArea.getText().split("\n");
        int[][] matriz = new int[filas.length][];
        for (int i = 0; i < filas.length; i++) {
            String[] valores = filas[i].trim().split("\\s+");
            matriz[i] = new int[valores.length];
            for (int j = 0; j < valores.length; j++) {
                matriz[i][j] = Integer.parseInt(valores[j]);
            }
        }
        return matriz;
    }

    private void mostrarResultado(int[][] resultado, TextArea textArea) {
        for (int[] fila : resultado) {
            for (int valor : fila) {
                textArea.appendText(valor + " ");
            }
            textArea.appendText("\n");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
