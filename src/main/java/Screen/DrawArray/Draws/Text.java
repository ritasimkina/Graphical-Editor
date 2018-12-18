package Screen.DrawArray.Draws;

import Component.IComponent;
import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;

public class Text  extends Draw  {
    private String txt="";

    public Text(String text, double x, double y) {
        txt=text;
        addPoint(new Point(x,y));
        addColor(0,0,0);    // fill
    }

    public String get_html() {
        String s;
        s= "\t<text "+
                get_id_tag()+
                " x='" +points.get(0).getX() + "' y='"  +points.get(0).getY() +
        "' fill="+color.get(0).gethtml(is_clicked())+" "+get_onclick()+
        "'>"+txt+"</text>\n";
        return s;
    }


}