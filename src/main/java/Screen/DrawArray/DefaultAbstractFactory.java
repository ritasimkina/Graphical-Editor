package Screen.DrawArray;

import Screen.DrawArray.Draws.Circle;
import Screen.DrawArray.Draws.Elipse;
import Screen.DrawArray.Draws.Line;
import Screen.DrawArray.Draws.NGon;
import Screen.DrawArray.Draws.Quadrangle;
import Screen.DrawArray.Draws.Star;
import Screen.DrawArray.Draws.Text;
import Screen.DrawArray.Draws.Triangle;
import Tools.BeanContainer;
import Tools.Context;

import java.util.Optional;
import java.util.Random;

public class DefaultAbstractFactory extends DrawAbstractFactory {
    private final Context context;

    public DefaultAbstractFactory() {
        this.context = BeanContainer.get(Context.class);
    }

    @Override
    Optional<Draw> create(String name) {
        double x = context.get("x").map(Double::new).orElseGet(this::generate);
        double y = context.get("y").map(Double::new).orElseGet(this::generate);
        switch (name) {
            case "Circle":
                return Optional.of(new ClickedDraw(new Circle(x, y, 10)));
            case "Elipse":
                new Elipse(x, y, 10, 20);
            case "Line":
                return Optional.of(new ClickedDraw(new Line(50, 50, x, y)));
            case "NGon":
                return Optional.of(new ClickedDraw(new NGon(x, y)));
            case "Quadrangle":
                return Optional.of(new ClickedDraw(new Quadrangle(x, y, 50, 50)));
            case "Star":
                return Optional.of(new ClickedDraw(new Star(x, y)));
            case "Text":
                return Optional.of(new ClickedDraw(new Text("Text", x, y)));
            case "Triangle":
                return Optional.of(new Triangle(x, y));
            default:
                return Optional.empty();
        }
    }

    private double generate() {
        return (double) new Random().nextInt(100) * 5;
    }
}
