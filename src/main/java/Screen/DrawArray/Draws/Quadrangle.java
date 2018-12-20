package Screen.DrawArray.Draws;


import Screen.DrawArray.Color;
import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;
import Tools.Pair;
import Tools.SVGAttributeList;


import java.util.Arrays;
import java.util.List;

public class Quadrangle  extends Draw {
    //https://www.w3.org/TR/SVG11/shapes.html#CircleElement



//<input type="text" id="myText" value="Some text...">


    static List<String> ATTRIBUTES=Arrays.asList(
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
            "fill", "rgb(255,255,255)",
            "stroke", "rgb(0,255,255)",
            "stroke-width", "2"     //, "color-interpolation", "color-interpolation-filters", "color-profile", "color-rendering", "fill-opacity", "fill-rule", "image-rendering", "marker", "marker-end", "marker-mid", "marker-start", "shape-rendering", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "text-rendering",
    );

    public Quadrangle(double x, double y, double width, double height) {
        super(new SVGAttributeList(ATTRIBUTES));
        attributes.setValue("id",get_id());
        attributes.setValue("x",x);
        attributes.setValue("y",y);
        attributes.setValue("width",width);
        attributes.setValue("height",height);
//        addColor(255,0,0);  // fill
//        addColor(0,0,255);  // stroke

    }

    private SVGAttributeList make_clicked(SVGAttributeList al)    {
        Color fill=new Color(attributes.getValue("fill"));
        Color stroke=new Color(attributes.getValue("stroke"));
        al.setValue("fill",fill.gethtml(true));
        al.setValue("stroke",stroke.gethtml(true));

//        attributes.setValue("fill",color.get(0).gethtml(is_clicked()));
//        attributes.setValue("stroke",color.get(1).gethtml(is_clicked()));
        return al;
    }

    @Override
    public String get_html() {
        SVGAttributeList al = new SVGAttributeList(attributes);

        if( is_clicked()) {
            al=make_clicked(al);
        }
        String s=get_attributes_as_html(al);
        return "\t<rect "+ s+ " />\n";
    }



}
