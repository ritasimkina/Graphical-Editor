package Screen.Toolbar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolbarOperation  implements Component {
    static List<String> operation_names = Arrays.asList("Edit", "Move");

    public Iterator createIterator() {
        assert false;
        return null;
    }
    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}


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

    public String get_html() {
        Debug.out(Thread.currentThread());
        //String s="\n<div id=\"toolbar\">";
        //s+="<button type=\"button\" onclick=\"alert('Hello World!')\">Click Me!</button>";
        //s+="</div>\n";
//    }

        String s="\n<div id=\"operations\">";
        for (String i : operation_names) {
            s+="\n\t<div>";
            s += "\n\t<form action=\"" + i + "\" method=\"GET\">";
            s += "\n\t\t<button>" + i + "</button>";
            s += "\n\t</form>";
            s+="\n\t</div>";
        }
        s+="\n</div>\n\n";

        return s;
    }



}
