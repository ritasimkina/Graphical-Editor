package Component;

import Debug.Debug;
import Screen.DrawArray.DrawArray;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    //Collection of child IComponent.
    List<Component> childComponent = new ArrayList<>();

    public Component get(int i)   {
        return childComponent.get(i);
    }

    public List<Component> getChildComponent()
    {
        return childComponent;
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

    @Override
    public void set_attributes(String parameter) {
        //throw
    }
}