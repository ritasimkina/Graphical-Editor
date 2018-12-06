package Component;

import java.util.ArrayList;
import java.util.List;
import Iterator.Iterator;
import Debug.*;

public interface Component {
    Iterator.IteratorComponent   iterator = null;
    public Iterator createIterator();
    public String get_html();
    public void registerObserver();
    public void notifyObservers();



    public class Composite implements Component {
        //Collection of child Component.
        List<Component> childComponent = new ArrayList<Component>();

        public void registerObserver()  {assert false;}
        public void notifyObservers()  {assert false;}

        //Adds the Component to the composition.
        public void add(Component component) {Debug.out(Thread.currentThread());
            childComponent.add(component);
        }
        //Removes the Component from the composition.
        public void remove(Component component) {Debug.out(Thread.currentThread());
            childComponent.remove(component);
        }

        public Iterator createIterator() {Debug.out(Thread.currentThread());
            return (Iterator) childComponent.iterator();
        }

        public String get_html()   {Debug.out(Thread.currentThread());
            String s="";
            for (Component i: childComponent  ) {
                s+=i.get_html();
            }
            return s;
        }
    }

}
