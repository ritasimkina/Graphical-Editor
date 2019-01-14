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


public class Layer extends Composite {
    Random rand = new Random();

    public Iterator createIterator() {
        assert false;
        return null;
    }
    public Layer() { Debug.out(Thread.currentThread());

    }

    public String get_html()   {
        if(is_visible()) return super.get_html();
        else return "// hiden Layer\n";
    }

    public boolean create_shape(String name, String attributes) {
        final String color = getValueFromAttr(attributes, "color");
        final DrawAbstractFactory factory;
        if  (color.equals("")) {
            factory = DrawAbstractFactory.getFactory(DrawAbstractFactory.DrawAttribute.DEFAULT, new HashMap<>());
        } else {
            Map<String, String> attrs = new HashMap<>();
            attrs.put("color", color);
            factory = DrawAbstractFactory.getFactory(DrawAbstractFactory.DrawAttribute.COLOR, attrs);
        }

        final Optional<Draw> draw = factory.create(name);
        if (draw.isPresent()) {
            add(draw.get());
            return true;
        }

        return false;
    }

    //parse attributes format: "key1:value1;key2:value2"
    private String getValueFromAttr(String attributes, String key) {
        for (String attr : attributes.split(";")) {
            final String[] keyValue = attr.split(":");
            if (key.equals(keyValue[0])) {
                return keyValue[1];
            }
        }
        return "";
    }

}