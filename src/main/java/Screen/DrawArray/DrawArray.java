package Screen.DrawArray;

import Component.*;
import Debug.Debug;
import Iterator.*;
import Observer.Observer;

import java.util.ArrayList;
import java.util.List;


public class DrawArray implements Component {
    Component.Composite screen = new Component.Composite();
    List<Layer> layer = new ArrayList<Layer>();

    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public Iterator createIterator() {
        assert false;
        return null;
    }

    public DrawArray() { Debug.out(Thread.currentThread());
        layer.add(new Layer());
    }

    private String souround_svg(String s)   {
        return "\n<svg height='500' width='500'>"+s+"</svg>\n";
    }


    public String get_html()   {
        String s="";
        for (Layer l: layer  ) {
            s+=l.get_html();
        }
        return souround_svg(s);
    }



    public boolean create_shape(String name)    {
        // ToDo:: für aktiven layer
        return layer.get(0).create_shape(name);
    }



}