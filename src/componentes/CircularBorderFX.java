package componentes;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderWidths;

public class CircularBorderFX extends Region {

    private int radius;

    public CircularBorderFX(int radius) {
        this.radius = radius;
        setBorder(new Border(new BorderStroke(
                Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(radius), BorderWidths.DEFAULT)));
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        setBorder(new Border(new BorderStroke(
                Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(radius), BorderWidths.DEFAULT)));
    }
}
