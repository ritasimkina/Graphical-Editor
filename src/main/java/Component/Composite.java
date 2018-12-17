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

    @Override
    public String get_id() {
        return null;
    }

    @Override
    public void set_clicked(boolean state) {

    }

    public String get_html()   {Debug.out(Thread.currentThread());
        String s="";
        for (Component i: childComponent  ) {
            s+=i.get_html();
        }
        return s;
    }





}