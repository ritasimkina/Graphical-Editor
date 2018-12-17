package Screen.Toolbar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

public class Tool implements Component {
    public Iterator createIterator() {
        assert false;
        return null;
    }


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

    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public String get_html()   {Debug.out(Thread.currentThread());
        assert false;
        String s="";
        return s;
    }
}