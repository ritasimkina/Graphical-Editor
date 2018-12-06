package Screen.DrawArray.Draws;

import Component.Component;
import Debug.Debug;
import Iterator.Iterator;
import Observer.ToolbarObserver;
import Observer.Observer;
import Screen.DrawArray.Draw;

public class Line extends Draw implements Component {
    double x1=0, y1=0, x2=100, y2=100;
    int stroke_width=2;

    int r=255, g=0,b=0;

    public Line(double x1,double y1,double x2,double y2)    {
        Debug.out(Thread.currentThread());
        //observer.add(new ToolbarObserver());
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;

    }
    String rgb_html(int r,int g, int b)   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }



    public String get_html() {
        String s;
        s= "\n<line x1='" +x1+ "' y1='" +y1+ "' x2='" +x2+ "' y2='" +y2+ "' style='stroke:"+rgb_html(r,g,b)+";stroke-width:" +stroke_width+ "' />\n";
        return s;
    }
}
