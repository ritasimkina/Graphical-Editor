import java.util.ArrayList;
import java.util.List;

public interface Component {
    Iterator.IteratorComponent   iterator = null;
    public Iterator createIterator();
    public String get_html();

    public class Composite implements Component {
        //Collection of child Component.
        List<Component> childComponent = new ArrayList<Component>();

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
            assert false;
            String s="";
            return s;
        }
    }

}
