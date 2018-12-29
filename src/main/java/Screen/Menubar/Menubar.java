package Screen.Menubar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

public class Menubar extends Component {

    public String get_html()   { Debug.out(Thread.currentThread());
        String s= "\n<h1><div id=\"menu\" style=\"color:white\">&ensp; SE2 Forms</div></h1>\n\n";
        return s;
    }
}