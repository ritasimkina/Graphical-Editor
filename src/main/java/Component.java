import java.util.ArrayList;
import java.util.List;

public interface Component {
    //Collection of child Component.
    List<Component> childComponent = new ArrayList<Component>();
    IteratorComponent   iterator = null;
    
    public String get_html();
}
