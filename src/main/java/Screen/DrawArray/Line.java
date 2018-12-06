package Screen.DrawArray;

import Component.Component;
import Debug.Debug;
import Iterator.Iterator;

public class Line implements Component {
    double x1=0, y1=0, x2=100, y2=100;
    int stroke_width=2;

    int r=255, g=0,b=0;

    public void registerObserver()  {assert false;}
    public void notifyObservers()  {assert false;}

    public Line(double x1,double y1,double x2,double y2)    {
        Debug.out(Thread.currentThread());
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;

    }
    String rgb_html(int r,int g, int b)   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }

    public Iterator createIterator() {
        assert false;
        return null;
    }

    public String get_html() {
        String s;
        s= "\n<line x1='" +x1+ "' y1='" +y1+ "' x2='" +x2+ "' y2='" +y2+ "' style='stroke:"+rgb_html(r,g,b)+";stroke-width:" +stroke_width+ "' />\n";
        return s;
    }
}
