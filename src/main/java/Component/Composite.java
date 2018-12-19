package Component;

import Debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    //Collection of child IComponent.
    List<Component> childComponent = new ArrayList<>();

    public Component get(int i)   {
        return childComponent.get(i);
    }



    //Adds the IComponent to the composition.
    public void add(Component component) {
        Debug.out(Thread.currentThread());
        childComponent.add(component);
    }
    //Removes the IComponent from the composition.
    public void remove(Component component) {Debug.out(Thread.currentThread());
        childComponent.remove(component);
    }

        /*public Iterator createIterator() {Debug.out(Thread.currentThread());
            return (Iterator) childComponent.iterator();
        }*/

    public int size()   {
        return childComponent.size();
    }



    /*@Override
    public void set_clicked(boolean state) {
    }*/

    public String get_html()   {Debug.out(Thread.currentThread());
        String s="";
        for (Component i: childComponent  ) {
            s+=i.get_html();
        }
        return s;
    }


    @Override
    public void set_attributes(String parameter) {
        //throw
    }
}