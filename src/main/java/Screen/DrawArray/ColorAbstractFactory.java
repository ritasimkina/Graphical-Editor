package Screen.DrawArray;

import java.util.Map;
import java.util.Optional;

public class ColorAbstractFactory extends DrawAbstractFactory {
    private final String color;
    private final DrawAbstractFactory abstractFactory;

    public ColorAbstractFactory(Map<String, String> params) {
        this.color = params.get("color");
        this.abstractFactory = DrawAbstractFactory.getFactory(DrawAttribute.DEFAULT, params);
    }

    @Override
    Optional<Draw> create(String name) {
        return abstractFactory.create(name).map(draw -> new ColorDraw(draw, color));
    }
}
