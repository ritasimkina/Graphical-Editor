package Screen.DrawArray;

import Debug.*;
import Iterator.*;
import Component.*;

public class Layer implements Component {
    Component.Composite draws = new Component.Composite();

    public Iterator createIterator() {
        assert false;
        return null;
    }
    public Layer() { Debug.out(Thread.currentThread());
        draws.add(new Text("Hello World!!!!"));
        draws.add(new Line(10,10,100,100));
    }

    public String get_html()   {
        return draws.get_html();
    }
}