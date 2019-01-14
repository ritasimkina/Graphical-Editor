package Screen.Toolbar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

import java.util.Arrays;
import java.util.List;

public class ToolbarOperation  extends Component {
    List<String> operation_names = Arrays.asList("Edit", "Delete", "Save", "Light", "Dark");

    public Iterator createIterator() {
        assert false;
        return null;
    }
    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public String get_html() {
        Debug.out(Thread.currentThread());

        String s="\n<div id=\"operations\"><br>";
        for (String i : operation_names) {
            s+="\n\t<div>";
            s += "\n\t<form action=\"" + i + "\" method=\"GET\">";
            s += "\n\t\t<button style=\"height:30px; width:75px\">" + i + "</button>&ensp;";
            s += "\n\t</form>";
            s+="\n\t</div>";
        }
        s+="\n</div>\n\n";

        return s;
    }



}
