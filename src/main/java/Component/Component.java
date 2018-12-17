package Component;

import java.util.ArrayList;
import java.util.List;
import Iterator.*;
import Observer.Observer;
import Debug.*;

public interface Component {
    //Iterator.IteratorComponent   iterator = null;
    List<Observer> observer = new ArrayList<Observer>();

    //public Iterator createIterator();
    public String get_html();
    public void registerObserver(Observer o);
    public void notifyObservers();

    public Component get(int i);
    public int size();
}
