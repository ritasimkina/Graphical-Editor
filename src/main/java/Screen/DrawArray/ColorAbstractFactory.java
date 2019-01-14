package Screen.DrawArray;

import Tools.Context;

import java.util.Optional;

public class ColorAbstractFactory extends DrawAbstractFactory {
    private final String color;
    private final DrawAbstractFactory abstractFactory;

    public ColorAbstractFactory(Context context) {
        this.color = context.get("color").get();
        this.abstractFactory = DrawAbstractFactory.getFactory(DrawAttribute.DEFAULT);
    }

    @Override
    Optional<Draw> create(String name) {
        return abstractFactory.create(name).map(draw -> new ColorDraw(draw, color));
    }
}
