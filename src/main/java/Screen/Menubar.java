package Screen;

import Debug.*;
import Iterator.*;
import Component.*;

public class Menubar implements Component {

    public Iterator createIterator()    {   Debug.out(Thread.currentThread());
        return new Iterator.IteratorMenubar(this);
    }

    public String get_html()   { Debug.out(Thread.currentThread());
        String s= "<div id=\"menu\"> Screen.Menu</div>";
        return s;
    }
}