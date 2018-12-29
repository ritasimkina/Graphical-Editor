package Screen.Menubar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

public class Menubar extends Component {

    public String get_html()   { Debug.out(Thread.currentThread());
        String s= "\n<div id=\"menu\" style=\"color:white; font-family:arial;\"><h1 style=\"margin-top:10px\">&ensp; SE2 Forms</h1></div>\n";
        return s;
    }
}