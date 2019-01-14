package Screen.DrawArray.Draws;

import Screen.DrawArray.Color;
import Screen.DrawArray.Draw;
import Tools.SVGAttributeList;


import java.util.Arrays;
import java.util.List;

public class Quadrangle  extends Draw {
    static List<String> ATTRIBUTES=Arrays.asList(
            //ATTRIBUTES
            "class", "svg_rect",
            "transform", "",
            "x", "10",
            "y", "10",
            "width", "100",
            "height", "100",
            "rx", "0",
            "ry", "0",
            //CORE_ATTRIBUTES
            "id", "id",
            //GRAPHICAL_EVENT_ATTRIBUTES
             "onclick", "clicked_svg(this.id)",
            //Color and Painting properties:
            "fill", "rgb(255,255,255)",
            "stroke", "rgb(25,118,210)",
            "stroke-width", "2"
    );

    public Quadrangle(double x, double y, double width, double height) {
        super(new SVGAttributeList(ATTRIBUTES));
        attributes.setValue("id",get_id());
        attributes.setValue("x",x);
        attributes.setValue("y",y);
        attributes.setValue("width",width);
        attributes.setValue("height",height);
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
        return "\t<rect "+ s+ " />\n";
    }
}
