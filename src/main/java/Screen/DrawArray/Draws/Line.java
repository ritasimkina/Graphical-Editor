package Screen.DrawArray.Draws;

import Component.Component;
import Debug.Debug;
import Iterator.Iterator;
import Observer.ToolbarObserver;
import Observer.Observer;
import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;

public class Line extends Draw implements Component {
    int stroke_width;

    public Line(double x1, double y1, double x2, double y2) {
        addPoint(new Point(x1,y1));
        addPoint(new Point(x2,y2));
        addColor(0,0,0);    // stroke
        stroke_width=2;
    }


    public String get_html() {
        String s;
        s= "\t<line x1='" +points.get(0).getX() + "' y1='" +points.get(0).getY() +
                "' x2='" +points.get(1).getX() + "' y2='" +points.get(1).getY() +
                "' style='stroke:"+color.get(0).gethtml()+
                ";stroke-width:" +stroke_width+ "' />\n";
        return s;
    }
}
