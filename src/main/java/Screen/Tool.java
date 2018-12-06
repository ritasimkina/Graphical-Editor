package Screen;

import Debug.*;
import Iterator.*;
import Component.*;

public class Tool implements Component {
    public Iterator createIterator() {
        assert false;
        return null;
    }

    public void registerObserver()  {assert false;}
    public void notifyObservers()  {assert false;}

    public String get_html()   {Debug.out(Thread.currentThread());
        assert false;
        String s="";
        return s;
    }
}