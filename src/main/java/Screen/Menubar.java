package Screen;

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
        String s= "<div id=\"menu\"> Screen.Menu</div>";
        return s;
    }
}