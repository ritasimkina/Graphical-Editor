package Screen.DrawArray.Draws;

import Screen.DrawArray.Draw;

public class Quadrangle  extends Draw {
    private int stroke_width=2;
    private int r=255, g=0,b=0;
    private int r2=255, g2=0,b2=0;
    private double width=0, height=0;

    private String rgb_html(int r,int g, int b)   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }

    public String get_html() {
        String s;
        s= "<rect width='" +width+ "' height='" +height+ "' style='fill:"+rgb_html(r,g,b)+";stroke-width:" +stroke_width+ ";stroke:"+rgb_html(r2,g2,b2)+"' />";
        return s;
    }
}
