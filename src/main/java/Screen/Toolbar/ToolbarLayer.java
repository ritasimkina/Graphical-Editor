package Screen.Toolbar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

public class ToolbarLayer  implements Component {
//    public Iterator createIterator() {
//        assert false;
//        return null;
//    }
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
    @Override
    public String get_id() {
        return null;
    }
    @Override
    public void set_clicked(boolean state) {

    }

    public String get_html()   {Debug.out(Thread.currentThread());

        assert false;
        String s="<div id=\"layers\">\n"+
//                "Layers"+
                add_button_html()+
                "</div>\n\n";
        return s;
    }

    private String add_button_html()    {
        String s="\t<div>";
            s += "\n\t<form action=layer_add method=\"GET\">";
            s += "\n\t\t<button>New Layer</button>";
            s += "\n\t</form>";
            s+="\n\t</div>";
            return s;
    }


}
