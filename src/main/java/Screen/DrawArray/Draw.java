package Screen.DrawArray;
import Iterator.*;
import Component.*;
import Debug.*;
import Observer.Observer;


public class Draw implements Component {
    public Iterator createIterator() {
        assert false;
        return null;
    }

    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public String get_html()   {Debug.out(Thread.currentThread());
        assert false;
        String s="";
        return s;
    }
}