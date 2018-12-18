package Screen.Infobar;

import Iterator.*;
import Debug.*;
import Component.*;
import Observer.Observer;

public class Infobar extends Component {
    public Iterator createIterator() {
        assert false;
        return null;
    }

    public String get_html()   {Debug.out(Thread.currentThread());
        assert false;
        String s="<div id=\"footer\">footer</div>\n";
        return s;
    }


}