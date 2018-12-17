package Screen.Infobar;

import Iterator.*;
import Debug.*;
import Component.*;
import Observer.Observer;

public class Infobar implements Component {
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

    @Override
    public String get_id() {
        return null;
    }

    @Override
    public void set_clicked(boolean state) {

    }

    public String get_html()   {Debug.out(Thread.currentThread());
        assert false;
        String s="<div id=\"footer\">footer</div>\n";
        return s;
    }


}