package Screen;

import Debug.*;
import Iterator.*;
import Component.*;

public class Toolbar implements Component {

    public void registerObserver()  {assert false;}
    public void notifyObservers()  {assert false;}

    public Iterator createIterator() {
        assert false;
        return null;
    }

    public String get_html() {
        Debug.out(Thread.currentThread());
        //String s="\n<div id=\"toolbar\">";
        //s+="<button type=\"button\" onclick=\"alert('Hello World!')\">Click Me!</button>";
        //s+="</div>\n";
//    }

        String s = "";
        s += "\n<form action=\"Line\" method=\"GET\">";
        s += "\n\t<button>Line</button>";
        s += "\n</form>";

        return s;
    }

}