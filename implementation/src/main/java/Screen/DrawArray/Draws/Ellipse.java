package Screen.DrawArray.Draws;

import Screen.DrawArray.Color;
import Screen.DrawArray.Draw;
import Tools.SVGAttributeList;
import java.util.Arrays;
import java.util.List;

public class Ellipse extends Draw {
    static List<String> ATTRIBUTES= Arrays.asList(
            //ATTRIBUTES
            "class", "svg_ellipse",
            "transform", "",
            "cx", "50",
            "cy", "50",
            "rx", "40",
            "ry", "20",
            //CORE_ATTRIBUTES
            "id", "id",
            //GRAPHICAL_EVENT_ATTRIBUTES
            "onclick", "clicked_svg(this.id)",
            //Color and Painting properties:
            "fill", "rgb(255,255,255)",
            "stroke", "rgb(25,118,210)",
            "stroke-width", "2"
    );

    public Ellipse(double x, double y, double rx, double ry) {
        super(new SVGAttributeList(ATTRIBUTES));
        attributes.setValue("id",get_id());
        attributes.setValue("cx",x);
        attributes.setValue("cy",y);
        attributes.setValue("rx",rx);
        attributes.setValue("ry",ry);
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
        return "\t<ellipse "+ s+ " />\n";
    }
}
