package Screen;

import Debug.*;
import Iterator.*;
import Component.*;

public class ToolbarOperation  implements Component {
    public Iterator createIterator() {
        assert false;
        return null;
    }

    public String get_html()   {Debug.out(Thread.currentThread());
        assert false;
        String s="<div id=\"operations\"> Operations</div>";
        return s;
    }
}
