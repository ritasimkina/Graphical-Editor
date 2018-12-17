package Screen.DrawArray.Draws;

import Component.Component;
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


    @Override
    public Component get(int i) {
        return null;
    }
    @Override
    public int size() {
        return 0;
    }

    public String get_html() {
        String s;
        s= "\t<polygon points='" +
                points.get(0).getX()+ "," +points.get(0).getY() + " " +
                points.get(1).getX()+ "," +points.get(1).getY() + " " +
                points.get(2).getX()+ "," +points.get(2).getY() + " " +
                points.get(3).getX()+ "," +points.get(3).getY() + " " +
                points.get(4).getX()+ "," +points.get(4).getY() + " " +
                points.get(5).getX()+ "," +points.get(5).getY() +
        "' style='fill:"+color.get(0).gethtml()+
        ";stroke:"+color.get(1).gethtml()+
        ";stroke-width:" +stroke_width+
         ";fill-rule:nonzero;'/>\n";
        return s;
    }
}