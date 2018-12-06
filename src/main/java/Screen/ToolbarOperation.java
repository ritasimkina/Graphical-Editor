package Screen;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

public class ToolbarOperation  implements Component {
    public Iterator createIterator() {
        assert false;
        return null;
    }
    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public String get_html()   {Debug.out(Thread.currentThread());
        assert false;
        String s="<div id=\"operations\"> Operations</div>";
        return s;
    }
}
