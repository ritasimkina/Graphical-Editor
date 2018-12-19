package Screen.DrawArray;
import Iterator.*;
import Component.*;
import Strategy.*;
import Tools.SVGAttributeList;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public abstract class Draw extends Component {
    protected  List<Point> points = new ArrayList<Point>();
    protected  List<Color> color = new ArrayList<Color>();
    protected boolean clicked=false;
    protected SVGAttributeList attributes;//=new SVGAttributeList(ATTRIBUTES);


    public Draw()   {}
    public Draw(SVGAttributeList l)   {
        attributes=l;
    }


    public void addPoint(Point p)   {
        points.add(p);
    }
    public void addColor(int r, int g, int b)   {
        color.add(new Color(r,g,b));
    }

    public String get_onclick()   {
        return " onclick=\"clicked_svg(this.id)\"";
    }

    /*public String get_html()    {
        return strategy.get_html();
    }*/



    public void set_attributes(String parameter) {
        StringTokenizer tok = new StringTokenizer(parameter,";",true);  // no empty tokens
        int i=0;
        while (tok.hasMoreTokens()) {
            String s=tok.nextToken();
            if (s.equals(";")) {
                s="";
                attributes.setValue(i++, s);
            } else {
                attributes.setValue(i++, s);
                tok.nextToken();
            }
            System.out.println(s);
        }
    }

}