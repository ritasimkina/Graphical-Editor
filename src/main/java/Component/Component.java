package Component;

import java.util.ArrayList;
import java.util.List;
import Iterator.*;
import Observer.Observer;
import Debug.*;

public interface Component {
    boolean visible=true;

    //Iterator.IteratorComponent   iterator = null;
    //public Iterator createIterator();

    public String get_html();

    List<Observer> observers = new ArrayList<Observer>();
    default public void registerObserver(Observer o)  {
        observers.add(o);
    }
    default public void notifyObservers()  {
        for (Observer i: observers  ) {
            i.update();
        }
    }



    public Component get(int i);
    public int size();
    public String get_id();
    public void set_clicked(boolean state);
}
