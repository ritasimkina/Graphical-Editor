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

    private String souround_svg(String s)   {
        return "\n<svg height='210' width='500'>"+s+"</svg>\n";
    }


    public String get_html()   {
        String s="";
        for (Layer l: layer  ) {
            s+=l.get_html();
        }
        return souround_svg(s);
    }

    public void new_line()  {
        // ToDo:: für aktiven layer
        layer.get(0).new_line();
    }


}