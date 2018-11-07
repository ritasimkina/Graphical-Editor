import java.util.ArrayList;
import java.util.List;

public interface Component {
    //Collection of child Component.
    List<Component> childComponent = new ArrayList<Component>();

    public String get_html();
}
