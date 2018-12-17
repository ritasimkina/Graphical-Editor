package Screen.DrawArray;
import Iterator.*;
import Component.*;
import Debug.*;
import Observer.Observer;
import Observer.ToolbarObserver;

import java.util.ArrayList;
import java.util.List;


public abstract class Draw implements Component {
    private static int id_count=0;
    String id="?";
    protected boolean clicked=false;

    public Draw()   {
        //        registerObserver(new ToolbarObserver(this));
        id_count++;
        id= Integer.toString(id_count);
    }


    protected  List<Point> points = new ArrayList<Point>();
    protected  List<Color> color = new ArrayList<Color>();

    public Iterator createIterator() {
        assert false;
        return null;
    }



    public void addPoint(Point p)   {
        points.add(p);
    }
    public void addColor(int r, int g, int b)   {
        color.add(new Color(r,g,b));
    }


    public String get_onclick()   {
        return " onclick=\"meldung(this.id)\"";
    }
    public String get_id_tag()   {
        return "id="+get_id();
    }
    public String get_id() {
        return id;
    }

    public abstract String get_html();


}