package Screen.DrawArray.Draws;

import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;

public class Circle  extends Draw {
    double cr=100;
    int stroke_width=2;

    int r=255, g=0,b=0;
    int r2=255, g2=0,b2=0;

    public Circle(double x, double y, double r) {
        addPoint(new Point(x,y));
        cr=r;
    }

    String rgb_html(int r,int g, int b)   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }

    public String get_html() {
        String s;
        s= "<circle cx='" +points.get(0).getX() + "' cy='" +points.get(0).getY()+ "' r='" +cr+ "' stroke='"+rgb_html(r,g,b)+"' stroke-width='" +stroke_width+ "' fill='"+rgb_html(r2,g2,b2)+"' />";
        return s;
    }
}
