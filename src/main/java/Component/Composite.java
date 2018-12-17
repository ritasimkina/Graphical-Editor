package Component;

import Debug.Debug;
import Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    //Collection of child Component.
    List<Component> childComponent = new ArrayList<Component>();

    public Component get(int i)   {
        return childComponent.get(i);
    }

    public void registerObserver(Observer o)  {observer.add(o);}
    public void notifyObservers()  {
        for (Observer i: observer  ) {
            i.notify();
        }
    }

    //Adds the Component to the composition.
    public void add(Component component) {
        Debug.out(Thread.currentThread());
        childComponent.add(component);
    }
    //Removes the Component from the composition.
    public void remove(Component component) {Debug.out(Thread.currentThread());
        childComponent.remove(component);
    }

        /*public Iterator createIterator() {Debug.out(Thread.currentThread());
            return (Iterator) childComponent.iterator();
        }*/

    public int size()   {
        return childComponent.size();
    }

    public String get_html()   {Debug.out(Thread.currentThread());
        String s="";
        for (Component i: childComponent  ) {
            s+=i.get_html();
        }
        return s;
    }





}