package Screen.DrawArray;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;



import Debug.*;
import Iterator.*;
import Component.*;
import Component.Composite;
import Screen.DrawArray.Draws.*;
import Tools.BeanContainer;
import Tools.Context;


public class Layer extends Composite {
    Random rand = new Random();
    private final Context context;

    public Iterator createIterator() {
        assert false;
        return null;
    }
    public Layer() { Debug.out(Thread.currentThread());
        //draws.add(new Text("Hello World!!!!"));
        this.context = BeanContainer.get(Context.class);
    }

    public String get_html()   {
        if(is_visible()) return super.get_html();
        else return "// hiden Layer\n";
    }

    public boolean create_shape(String name, String attributes) {
        final Optional<String> color = context.get("color");
        final DrawAbstractFactory factory;
        if  (!color.isPresent()) {
            factory = DrawAbstractFactory.getFactory(DrawAbstractFactory.DrawAttribute.DEFAULT, new HashMap<>());
        } else {
            Map<String, String> attrs = new HashMap<>();
            attrs.put("color", color.get());
            factory = DrawAbstractFactory.getFactory(DrawAbstractFactory.DrawAttribute.COLOR, attrs);
        }

        final Optional<Draw> draw = factory.create(name);
        if (draw.isPresent()) {
            add(draw.get());
            return true;
        }

        return false;
    }

}