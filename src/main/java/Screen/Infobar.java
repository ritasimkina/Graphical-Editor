package Screen;

import Iterator.*;
import Debug.*;
import Component.*;

public class Infobar implements Component {
    public Iterator createIterator() {
        assert false;
        return null;
    }
    public void registerObserver()  {assert false;}
    public void notifyObservers()  {assert false;}

    public String get_html()   {Debug.out(Thread.currentThread());
        assert false;
        String s="<div id=\"footer\"> Name</div>";
        return s;
    }
}