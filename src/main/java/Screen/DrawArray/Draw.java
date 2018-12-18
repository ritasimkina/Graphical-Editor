package Screen.DrawArray;
import Iterator.*;
import Component.*;

import java.util.ArrayList;
import java.util.List;


public abstract class Draw extends Component {
    protected  List<Point> points = new ArrayList<Point>();
    protected  List<Color> color = new ArrayList<Color>();
    protected boolean clicked=false;

    /*public Draw()   {
        id_count++;
        id= Integer.toString(id_count);
    }*/

    /*public Iterator createIterator() {
        assert false;
        return null;
    }*/

    public void addPoint(Point p)   {
        points.add(p);
    }
    public void addColor(int r, int g, int b)   {
        color.add(new Color(r,g,b));
    }

    public String get_onclick()   {
        return " onclick=\"meldung(this.id)\"";
    }

    public abstract String get_html();


}