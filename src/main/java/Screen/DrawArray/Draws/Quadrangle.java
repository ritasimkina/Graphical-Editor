package Screen.DrawArray.Draws;


import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;
import Tools.Pair;
import Tools.SVGAttributeList;


import java.util.Arrays;
import java.util.List;

public class Quadrangle  extends Draw {
    //https://www.w3.org/TR/SVG11/shapes.html#CircleElement

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
         "onclick", "clicked_svg(this.id",  //,"onactivate",  "onfocusin", "onfocusout", "onload", "onmousedown", "onmousemove", "onmouseout", "onmouseover",  "onmouseup";
        //PRESENTATION_ATTRIBUTES
         //Color and Painting properties:
            "fill", "",
            "stroke", "",
            "stroke-width", ""     //, "color-interpolation", "color-interpolation-filters", "color-profile", "color-rendering", "fill-opacity", "fill-rule", "image-rendering", "marker", "marker-end", "marker-mid", "marker-start", "shape-rendering", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "text-rendering",
    );

    SVGAttributeList attributes=new SVGAttributeList(ATTRIBUTES);



    public Quadrangle(double x, double y, double width, double height) {
        addPoint(new Point(x,y));
        addColor(255,0,0);  // fill
        addColor(0,0,255);  // stroke
    }

    public String get_html() {
        String s="";
//        s= "\t<rect "+
//                get_id_tag()+
//                " x=" +points.get(0).getX()+ " y=" +points.get(0).getY() +
//                " width='" +width+ "' height='" +height+"'"+
//                "' style='fill:"+color.get(0).gethtml(is_clicked())+
//                ";stroke-width:" +stroke_width+
//                ";stroke:"+color.get(1).gethtml(is_clicked())+"'"+get_onclick()+" />\n";
        return s;
    }
}
