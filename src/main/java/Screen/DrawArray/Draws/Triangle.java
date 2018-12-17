package Screen.DrawArray.Draws;

import Component.Component;
import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;

public class Triangle  extends Draw {
    //private double mx=0,my=0,l1x=0,l1y=0,l2x=0,l2y=0;
    private int stroke_width=2;

    /*public String get_html() {

        M = moveto
        L = lineto
        H = horizontal lineto
        V = vertical lineto
        C = curveto
        S = smooth curveto
        Q = quadratic Bézier curve
        T = smooth quadratic Bézier curveto
        A = elliptical Arc
        Z = closepath

        String s;
        s= "<path d='M" +mx+ " " +my+ " L" +l1x+ " " +l1y+ " L" +l2x+ " " +l2y+ " Z' />";
        return s;
    }*/

    public Triangle(double x, double y) {
        addPoint(new Point(x,y-10));
        addPoint(new Point(x+10,y+10));
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
                points.get(3).getX()+ "," +points.get(3).getY() +
                "' style='fill:"+color.get(0).gethtml()+
                ";stroke:"+color.get(1).gethtml()+
                ";stroke-width:" +stroke_width+
                ";fill-rule:nonzero;'/>\n";
        return s;
    }


}