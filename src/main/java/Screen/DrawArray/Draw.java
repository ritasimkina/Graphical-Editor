package Screen.DrawArray;
import Iterator.*;
import Component.*;

import java.util.ArrayList;
import java.util.List;


public abstract class Draw extends Component {
    protected  List<Point> points = new ArrayList<Point>();
    protected  List<Color> color = new ArrayList<Color>();
    protected boolean clicked=false;

    public void addPoint(Point p)   {
        points.add(p);
    }
    public void addColor(int r, int g, int b)   {
        color.add(new Color(r,g,b));
    }

    public String get_onclick()   {
        return " onclick=\"clicked_svg(this.id)\"";
    }

    public abstract String get_html();


}