package Screen.DrawArray.Draws;

import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;

public class Quadrangle  extends Draw {
    private int stroke_width=2;
    private double width=0, height=0;


    public Quadrangle(double x, double y, double width, double height) {
        addPoint(new Point(x,y));
        this.width=width;
        this.height=height;
        addColor(255,0,0);  // fill
        addColor(0,0,0);  // stroke
    }

    public String get_html() {
        String s;
        s= "\n<rect x=" +points.get(0).getX()+ " y=" +points.get(0).getY() +
                " width='" +width+ "' height='" +height+"'"+
                "' style='fill:"+color.get(0).gethtml()+
                ";stroke-width:" +stroke_width+
                ";stroke:"+color.get(1).gethtml()+"' />";
        return s;
    }
}
