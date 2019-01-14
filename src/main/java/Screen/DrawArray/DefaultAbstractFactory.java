package Screen.DrawArray;

import Screen.DrawArray.Draws.Circle;
import Screen.DrawArray.Draws.Ellipse;
import Screen.DrawArray.Draws.Line;
import Screen.DrawArray.Draws.NGon;
import Screen.DrawArray.Draws.Quadrangle;
import Screen.DrawArray.Draws.Star;
import Screen.DrawArray.Draws.Text;
import Screen.DrawArray.Draws.Triangle;
import Tools.Context;

import java.util.Optional;
import java.util.Random;

public class DefaultAbstractFactory extends DrawAbstractFactory {
    private final Context context;

    public DefaultAbstractFactory(Context context) {
        this.context = context;
    }

    @Override
    Optional<Draw> create(String name) {
        double x = context.get("x").map(Double::new).orElseGet(this::generate);
        double y = context.get("y").map(Double::new).orElseGet(this::generate);
        double x2 = generate();
        double y2 = generate();
        switch (name) {
            case "Circle":
                return Optional.of(new Circle(x, y, 10));
            case "Ellipse":
                return Optional.of(new Ellipse(x, y, 10, 20));
            case "Line":
                return Optional.of(new Line(x, y, x2, y2));
            case "NGon":
                return Optional.of(new NGon(x, y));
            case "Quadrangle":
                return Optional.of(new Quadrangle(x, y, 50, 50));
            case "Star":
                return Optional.of(new Star(x, y));
            case "Text":
                return Optional.of(new Text("Text", x, y));
            case "Triangle":
                return Optional.of(new Triangle(x, y));
            default:
                return Optional.empty();
        }
    }

    private Double generate() {
        return (double) new Random().nextInt(100) * 5;
    }
}
