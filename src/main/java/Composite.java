import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    //Collection of child Component.
    List<Component> childComponent = new ArrayList<Component>();

    //Adds the Component to the composition.
    public void add(Component component) {
        childComponent.add(component);
    }
    //Removes the Component from the composition.
    public void remove(Component component) {
        childComponent.remove(component);
    }

    public String get_html()   {
        assert false;
        String s="";
        return s;
    }
}
