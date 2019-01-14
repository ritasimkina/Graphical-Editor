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
        String s="<div id=\"footer\" style=\"color:white; font-family:arial;\"><br>&ensp; BAREIS Klaus, SCHMON Fabian, SIMKINA Margaryta</div>\n";
        return s;
    }


}