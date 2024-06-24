package componentes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class RGBChromaButtonUIFX extends Button {

    private Timeline timeline;

    public RGBChromaButtonUIFX(String text) {
        super(text);
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> changeColor()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void changeColor() {
        Color color = Color.color(Math.random(), Math.random(), Math.random());
        this.setStyle("-fx-background-color: " + toRgbString(color));
    }

    private String toRgbString(Color color) {
        return String.format("rgb(%d, %d, %d)",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }
}
