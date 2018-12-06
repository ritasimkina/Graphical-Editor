package Screen.DrawArray.Draws;

import Screen.DrawArray.Draw;

public class Star  extends Draw {
    private double p1=0, p2=0, p3=100;
    private int stroke_width=2;
    private int r=255, g=0,b=0;
    private int r2=255, g2=0,b2=0;


    public Quadrangle(double x, double y, double width, double height) {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }


    private String rgb_html(int r,int g, int b)   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }

    public String get_html() {
        String s;
        s= "<polygon points='" +p1+ " " +p2+ " " +p3+ "' style='fill:"+rgb_html(r,g,b)+";stroke:"+rgb_html(r2,g2,b2)+";stroke-width:" +stroke_width+ "' />";
        return s;
    }
}