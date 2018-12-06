package Screen.Menubar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

public class Menu implements Component {
    public Iterator createIterator() {Debug.out(Thread.currentThread());
        assert false;
        return null;
    }

    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public String get_html()   {Debug.out(Thread.currentThread());
        assert false;
        String s="";
        return s;
    }
}
