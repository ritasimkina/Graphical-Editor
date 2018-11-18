package Screen.DrawArray;

import Component.*;
import Debug.Debug;
import Iterator.*;

import java.util.ArrayList;
import java.util.List;


public class DrawArray implements Component {
    Component.Composite screen = new Component.Composite();
    List<Layer> layer = new ArrayList<Layer>();

    public Iterator createIterator() {
        assert false;
        return null;
    }

    public DrawArray() { Debug.out(Thread.currentThread());
        layer.add(new Layer());
    }

    public String get_html()   {
        String s="";
        for (Layer l: layer  ) {
            s+=l.get_html();
        }
        return s;
    }
}