package Screen.DrawArray.Draws;


import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;
import Tools.Pair;


import java.util.Arrays;
import java.util.List;

public class Quadrangle  extends Draw {

    List<String> ATTRIBUTES=Arrays.asList(
    "class", "transform", "x", "y", "width", "height", "rx", "ry", //,"style","externalResourcesRequired");    style uses as PRESENTATION_ATTRIBUTES
    //CONDITIONAL_PROCESSING_ATTRIBUTES
                //"requiredExtensions", "requiredFeatures",  "systemLanguage");
    //CORE_ATTRIBUTES
    "id",       //, "xml:base", "xml:lang",  "xml:space");
    //GRAPHICAL_EVENT_ATTRIBUTES
    "onclick",   //,"onactivate",  "onfocusin", "onfocusout", "onload", "onmousedown", "onmousemove", "onmouseout", "onmouseover",  "onmouseup");
    //PRESENTATION_ATTRIBUTES
        //Color and Painting properties:
            "fill", "stroke", "stroke-width"    //, "color-interpolation", "color-interpolation-filters", "color-profile", "color-rendering", "fill-opacity", "fill-rule", "image-rendering", "marker", "marker-end", "marker-mid", "marker-start", "shape-rendering", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "text-rendering",
    );

    List<String> ATTRIBUTE_VALUES=Arrays.asList("svg_rect", "style", "", "10", "10", "100", "100", "0", "0",
                                            "id",
                                            "clicked_svg(this.id)",
            "fill", "stroke", "stroke-width"    //, "color-interpolation", "color-interpolation-filters", "color-profile", "color-rendering", "fill-opacity", "fill-rule", "image-rendering", "marker", "marker-end", "marker-mid", "marker-start", "shape-rendering", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "text-rendering",
    );





    private int stroke_width=2;
    private double width=0, height=0;


    public Quadrangle(double x, double y, double width, double height) {
        addPoint(new Point(x,y));
        this.width=width;
        this.height=height;
        addColor(255,0,0);  // fill
        addColor(0,0,255);  // stroke

        List<Pair> Atr=Arrays.asList(new Pair("1", "One"),
                new Pair("1", "One"),
                new Pair("1", "One")
                );



    }

    public String get_html() {
        String s;
        s= "\t<rect "+
                get_id_tag()+
                " x=" +points.get(0).getX()+ " y=" +points.get(0).getY() +
                " width='" +width+ "' height='" +height+"'"+
                "' style='fill:"+color.get(0).gethtml(is_clicked())+
                ";stroke-width:" +stroke_width+
                ";stroke:"+color.get(1).gethtml(is_clicked())+"'"+get_onclick()+" />\n";
        return s;
    }
}
