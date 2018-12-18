package Screen.DrawArray.Draws;

import Component.IComponent;
import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;

public class Circle  extends Draw {
    double cr;
    int stroke_width;

    public Circle(double x, double y, double r) {
        addPoint(new Point(x,y));
        addColor(255,0,0);  // line
        addColor(0,0,0);    // fill
        cr=r;
        stroke_width=2;
    }

    public String get_html() {
        String s;
        s= "\t<circle "+
                get_id_tag()+
                " cx='" +points.get(0).getX() + "' cy='" +points.get(0).getY()+ "' r='" +cr+
                "' stroke='"+color.get(0).gethtml(get_clicked())+
                "' stroke-width='" +stroke_width+
                "' fill='"+color.get(1).gethtml(get_clicked())+"'"+get_onclick()+" />\n";
        return s;
    }
}
