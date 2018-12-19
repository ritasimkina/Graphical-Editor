package Screen.DrawArray.Draws;


import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;
import Tools.Pair;
import Tools.SVGAttributeList;


import java.util.Arrays;
import java.util.List;

public class Quadrangle  extends Draw {
    //https://www.w3.org/TR/SVG11/shapes.html#CircleElement

    String EDIT_TABLE=(      "<table>\n"+
                             "TABLEROW"+
                             "</table>\n" +
                            "<button onclick='svg_edit_save(IDS)'>Save</button>\n"  +
                             "<button onclick='svg_edit_cancel()'>Cancel</button>\n"  );
    String EDIT_TABLE_ROW=(  "  <tr><th>KEY</th><th><input type='text' id='ID' value='VALUE'></th></tr>\n");

//<input type="text" id="myText" value="Some text...">


    List<String> ATTRIBUTES=Arrays.asList(
        // ATTRIBUTES
            "class", "svg_rect",
            "transform", "",
            "x", "10",
            "y", "10",
            "width", "100",
            "height", "100",
            "rx", "0",
            "ry", "0",        //,"style","externalResourcesRequired";    style uses as PRESENTATION_ATTRIBUTES
        //CONDITIONAL_PROCESSING_ATTRIBUTES
            //"requiredExtensions", "requiredFeatures",  "systemLanguage";
        //CORE_ATTRIBUTES
            "id", "id",       //, "xml:base", "xml:lang",  "xml:space";
        //GRAPHICAL_EVENT_ATTRIBUTES
         "onclick", "clicked_svg(this.id)",  //,"onactivate",  "onfocusin", "onfocusout", "onload", "onmousedown", "onmousemove", "onmouseout", "onmouseover",  "onmouseup";
        //PRESENTATION_ATTRIBUTES
         //Color and Painting properties:
            "fill", "",
            "stroke", "",
            "stroke-width", ""     //, "color-interpolation", "color-interpolation-filters", "color-profile", "color-rendering", "fill-opacity", "fill-rule", "image-rendering", "marker", "marker-end", "marker-mid", "marker-start", "shape-rendering", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "text-rendering",
    );
    SVGAttributeList attributes=new SVGAttributeList(ATTRIBUTES);

    public Quadrangle(double x, double y, double width, double height) {
        attributes.setValue("id",get_id());
        attributes.setValue("x",x);
        attributes.setValue("y",y);
        attributes.setValue("width",width);
        attributes.setValue("height",height);
        addColor(255,0,0);  // fill
        addColor(0,0,255);  // stroke
    }


    private void set_attributes()    {
        attributes.setValue("fill",color.get(0).gethtml(is_clicked()));
        attributes.setValue("stroke",color.get(1).gethtml(is_clicked()));
    }
    private String get_attributes_html()    {
        set_attributes();
        String s="";
        for(int i=0;i<attributes.size();i++)    {
            s+=attributes.get_key(i)+"='"+attributes.get_value(i)+"' ";
        }
        return s;
    }


    public String get_html() {
        return "\t<rect "+ get_attributes_html()+ " />\n";
    }

    public String get_edit_html(SVGAttributeList list)    {
        String r="";
        for(int i=0;i<list.size();i++)    {
            String s=EDIT_TABLE_ROW;
            s=s.replace("ID",Integer.toString(i));
            s=s.replace("KEY",list.get_key(i));
            s=s.replace("VALUE",list.get_value(i));
            r+=s;
        }
        String t=EDIT_TABLE;
        t=t.replace("IDS",Integer.toString(list.size()));
        t=t.replace("TABLEROW",r);
        return t;
    }

    @Override
    public String get_edit_html() {
        return get_edit_html(attributes);
    }


}
