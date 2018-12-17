package Screen.DrawArray.Draws;

import Component.Component;
import Debug.Debug;
import Iterator.Iterator;
import Observer.Observer;
import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;

public class Text  extends Draw implements Component {
    private String txt="";

    public Text(String text, double x, double y) {
        txt=text;
        addPoint(new Point(x,y));
        addColor(0,0,0);    // fill
    }


    @Override
    public Component get(int i) {
        return null;
    }
    @Override
    public int size() {
        return 0;
    }
    @Override
    public void set_clicked(boolean state) {
        clicked=state;
    }

    public String get_html() {
        String s;
        s= "\t<text x='" +points.get(0).getX() + "' y='"  +points.get(0).getY() +
        "' fill="+color.get(0).gethtml()+
        "'>"+txt+"</text>\n";
        return s;
    }


}