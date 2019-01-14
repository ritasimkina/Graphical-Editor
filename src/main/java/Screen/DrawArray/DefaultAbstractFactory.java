package Screen.DrawArray;

import Screen.DrawArray.Draws.Circle;
import Screen.DrawArray.Draws.Ellipse;
import Screen.DrawArray.Draws.Line;
import Screen.DrawArray.Draws.NGon;
import Screen.DrawArray.Draws.Quadrangle;
import Screen.DrawArray.Draws.Star;
import Screen.DrawArray.Draws.Text;
import Screen.DrawArray.Draws.Triangle;

import java.util.Optional;
import java.util.Random;

public class DefaultAbstractFactory extends DrawAbstractFactory {

    @Override
    Optional<Draw> create(String name) {
        double x = new Random().nextInt(900);
        double y = new Random().nextInt(600);
        double x2 = new Random().nextInt(900);
        double y2 = new Random().nextInt(600);
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
}
