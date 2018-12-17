package Screen.Menubar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

public class Menubar implements Component {

    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public Iterator createIterator()    {   Debug.out(Thread.currentThread());
        return new Iterator.IteratorMenubar(this);
    }

    public String get_html()   { Debug.out(Thread.currentThread());
        String s= "\n<div id=\"menu\"> Screen.Screen.Menubar.Menu</div>\n\n";
        return s;
    }
}