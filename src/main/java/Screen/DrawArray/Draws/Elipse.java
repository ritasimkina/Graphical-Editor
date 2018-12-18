package Screen.DrawArray.Draws;

import Component.IComponent;
import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;

public class Elipse  extends Draw {
    private double rx, ry;
    private int stroke_width;


    public Elipse(double x, double y, double rx, double ry) {
        addPoint(new Point(x,y));
        this.rx=rx;
        this.ry=ry;
        addColor(255,0,0);  // fill
        addColor(0,0,0);    // stroke
        stroke_width=2;
    }

    public String get_html() {
        String s;
        s= "\t<ellipse "+
                get_id_tag()+
                " cx='" +points.get(0).getX() + "' cy='" +points.get(0).getY() +
                "' rx='" +rx+ "' ry='" +ry+
                "' style='fill:"+color.get(0).gethtml(get_clicked())+
                ";stroke:"+color.get(1).gethtml(get_clicked())+
                ";stroke-width:" +stroke_width+ "'"+get_onclick()+" />\n";
        return s;
    }
}
