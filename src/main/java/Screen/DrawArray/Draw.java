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

    static String EDIT_TABLE=(      "<table>\n"+
            "TABLEROW"+
            "</table>\n <br>" +
            "&emsp;&emsp;&emsp;&emsp;<button style=\"height:30px; width:75px\", onclick='svg_edit_save(IDS)'>Save</button>\n"  +
            "&emsp;&emsp;<button style=\"height:30px; width:75px\", onclick='svg_edit_cancel()'>Cancel</button>\n"  );
    static String EDIT_TABLE_ROW=(  "<tr>&emsp;&emsp;<th> &emsp;&emsp; KEY</th><th><input type='text' id='ID' value='VALUE'></th></tr>\n");

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

    public void set_attributes(String parameter) {
        StringTokenizer tok = new StringTokenizer(parameter,"&",true);  // no empty tokens
        int i=0;
        while (tok.hasMoreTokens()) {
            String s=tok.nextToken();
            if (s.equals("&")) {
                s="";
                attributes.setValue(i++, s);
            } else {
                attributes.setValue(i++, s);
                if (tok.hasMoreTokens())  tok.nextToken();
            }
        }
    }
    public String get_attributes_as_html(SVGAttributeList l)    {
        //using l, not attributes, to derived class can temporarily change attributes (clicked, ...)
        String s="";
        for(int i=0;i<l.size();i++)    {
            s+=l.get_key(i)+"='"+l.get_value(i)+"' ";
        }
        return s;
    }
    public String get_edit_html()    {
        String r="";
        for(int i=0;i<attributes.size();i++)    {
            String s = EDIT_TABLE_ROW;
            s=s.replace("ID",Integer.toString(i));
            s=s.replace("KEY",attributes.get_key(i));
            s=s.replace("VALUE",attributes.get_value(i));
            r+=s;
        }
        String t=EDIT_TABLE;
        t=t.replace("IDS",Integer.toString(attributes.size()));
        t=t.replace("TABLEROW",r);
        return t;
    }

    public void set_attribute(String key, String value) {
        attributes.setValue(key,value);
    }


    public SVGAttributeList make_clicked(SVGAttributeList al)  {
        assert false;
        return null;
    }
    public String souround_svg_type(String al)  {
        assert false;
        return null;
    }
    public void set_additional_attributes()   {
    }


    public String get_html() {
        SVGAttributeList al = new SVGAttributeList(attributes);
        if( is_clicked()) {
            al=make_clicked(al);
        }
        set_additional_attributes();
        String s=get_attributes_as_html(al);
        return souround_svg_type(s);
    }

    public String get_points() {
        String s="";
        for(int i=0;i<points.size();i+=1)   {
            s+=points.get(i).getX()+ "," +points.get(i).getY() + " ";
        }
        return s;
    }

    public SVGAttributeList getAttributes() {
        return attributes;
    }
}