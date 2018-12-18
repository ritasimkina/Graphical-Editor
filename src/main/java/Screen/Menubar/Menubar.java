package Screen.Menubar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

public class Menubar extends Component {

    public String get_html()   { Debug.out(Thread.currentThread());
        String s= "\n<div id=\"menu\"> Screen.Screen.Menubar.Menu</div>\n\n";
        return s;
    }
}