import java.util.ArrayList;
import java.util.List;

public interface Component {


    IteratorComponent   iterator = null;

    public Iterator createIterator();

    public String get_html();
}
