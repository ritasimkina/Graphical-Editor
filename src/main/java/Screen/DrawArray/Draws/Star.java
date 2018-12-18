package Screen.DrawArray.Draws;

import Component.IComponent;
import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;

public class Star  extends Draw {
    private int stroke_width=2;

    public Star(double x, double y) {
        addPoint(new Point(x,y-10));
        addPoint(new Point(x+10,y+10));
        addPoint(new Point(x-10,y-5));
        addPoint(new Point(x+10,y-5));
        addPoint(new Point(x-10,y+10));
        addPoint(new Point(x,y-10));
        addColor(255,0,0);  // fill
        addColor(0,0,0);  // stroke
    }

    public String get_html() {
        String s;
        s= "\t<polygon "+
                get_id_tag()+
                " points='" +
                points.get(0).getX()+ "," +points.get(0).getY() + " " +
                points.get(1).getX()+ "," +points.get(1).getY() + " " +
                points.get(2).getX()+ "," +points.get(2).getY() + " " +
                points.get(3).getX()+ "," +points.get(3).getY() + " " +
                points.get(4).getX()+ "," +points.get(4).getY() + " " +
                points.get(5).getX()+ "," +points.get(5).getY() +
        "' style='fill:"+color.get(0).gethtml(is_clicked())+
        ";stroke:"+color.get(1).gethtml(is_clicked())+
        ";stroke-width:" +stroke_width+
         ";fill-rule:nonzero;' "+
                get_onclick()+
                " />\n";
        return s;
    }
}