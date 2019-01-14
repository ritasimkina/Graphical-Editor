package Screen.DrawArray;

import Component.Composite;
import Debug.Debug;
import Iterator.Iterator;
import Tools.BeanContainer;
import Tools.Context;

import java.util.Optional;
import java.util.Random;


public class Layer extends Composite {
    Random rand = new Random();
    private final Context context;

    public Iterator createIterator() {
        assert false;
        return null;
    }

    public Layer() {
        Debug.out(Thread.currentThread());
        context = BeanContainer.get(Context.class);
    }

    public String get_html() {
        if (is_visible()) return super.get_html();
        else return "// hiden Layer\n";
    }

    public boolean create_shape(String name) {
        final Optional<String> color = context.get("color");
        final DrawAbstractFactory factory;
        if (color.isPresent()) {
            factory = DrawAbstractFactory.getFactory(DrawAbstractFactory.DrawAttribute.COLOR);
        } else {
            factory = DrawAbstractFactory.getFactory(DrawAbstractFactory.DrawAttribute.DEFAULT);
        }

        final Optional<Draw> draw = factory.create(name);
        if (draw.isPresent()) {
            add(draw.get());
            return true;
        }

        return false;
    }

}