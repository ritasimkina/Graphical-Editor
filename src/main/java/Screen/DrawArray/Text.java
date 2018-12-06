package Screen.DrawArray;

import Component.Component;
import Debug.Debug;
import Iterator.Iterator;

public class Text implements Component {
    private double x1=50, y1=50;
    private int r=255, g=0,b=0;
    private String txt="";

    public void registerObserver()  {assert false;}
    public void notifyObservers()  {assert false;}

    private String rgb_html(int r,int g, int b)   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }

    public Iterator createIterator() {
        assert false;
        return null;
    }
    public Text(String text) { Debug.out(Thread.currentThread());
        txt=text;
    }
    public String get_html() {
        String s;
        s= "\n<text x='" +x1+ "' y='" +y1+ "' fill="+rgb_html(r,g,b)+"'>"+txt+"</text>\n";
        return s;
    }
}