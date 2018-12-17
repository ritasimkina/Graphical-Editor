package Screen.Menubar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

public class Menubar implements Component {

    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public Iterator createIterator()    {   Debug.out(Thread.currentThread());
        return null;//new Iterator.IteratorMenubar(this);
    }

    @Override
    public Component get(int i) {
        assert false;
        return null;
    }
    @Override
    public int size() {
        assert false;
        return 0;
    }


    public String get_html()   { Debug.out(Thread.currentThread());
        String s= "\n<div id=\"menu\"> Screen.Screen.Menubar.Menu</div>\n\n";
        return s;
    }
}