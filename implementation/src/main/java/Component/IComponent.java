package Component;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;

public interface IComponent {

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

    public String get_id();
    public void set_clicked(boolean state);
}
