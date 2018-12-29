package Screen.DrawArray.Draws;

import Screen.DrawArray.Color;
import Screen.DrawArray.Draw;
import Tools.SVGAttributeList;
import java.util.Arrays;
import java.util.List;

public class Circle  extends Draw {
    static List<String> ATTRIBUTES= Arrays.asList(
            // ATTRIBUTES
            "class", "svg_circle",
            "transform", "",
            "cx", "50",
            "cy", "50",
            "r", "50",   //,"style","externalResourcesRequired";    style uses as PRESENTATION_ATTRIBUTES
            //CONDITIONAL_PROCESSING_ATTRIBUTES
            //"requiredExtensions", "requiredFeatures",  "systemLanguage";
            //CORE_ATTRIBUTES
            "id", "id",       //, "xml:base", "xml:lang",  "xml:space";
            //GRAPHICAL_EVENT_ATTRIBUTES
            "onclick", "clicked_svg(this.id)",  //,"onactivate",  "onfocusin", "onfocusout", "onload", "onmousedown", "onmousemove", "onmouseout", "onmouseover",  "onmouseup";
            //PRESENTATION_ATTRIBUTES
            //Color and Painting properties:
            "fill", "rgb(255,255,255)",
            "stroke", "rgb(25,118,210)",
            "stroke-width", "2"     //, "color-interpolation", "color-interpolation-filters", "color-profile", "color-rendering", "fill-opacity", "fill-rule", "image-rendering", "marker", "marker-end", "marker-mid", "marker-start", "shape-rendering", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "text-rendering",
    );

    public Circle(double x, double y, double r) {
        super(new SVGAttributeList(ATTRIBUTES));
        attributes.setValue("id",get_id());
        attributes.setValue("cx",x);
        attributes.setValue("cy",y);
        attributes.setValue("r",r);
    }

    @Override
    public SVGAttributeList make_clicked(SVGAttributeList al)    {
        Color fill=new Color(attributes.getValue("fill"));
        Color stroke=new Color(attributes.getValue("stroke"));
        al.setValue("fill",fill.gethtml(true));
        al.setValue("stroke",stroke.gethtml(true));
        return al;
    }

    @Override
    public String souround_svg_type(String s) {
        return "\t<circle "+ s+ " />\n";
    }
}
