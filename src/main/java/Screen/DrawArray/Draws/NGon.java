package Screen.DrawArray.Draws;

import Screen.DrawArray.Color;
import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;
import Tools.SVGAttributeList;

import java.util.Arrays;
import java.util.List;

public class NGon  extends Draw {
    static List<String> ATTRIBUTES= Arrays.asList(
            // ATTRIBUTES
            "class", "svg_ngon",
            "transform", "",
            "points","",   //,"style","externalResourcesRequired";    style uses as PRESENTATION_ATTRIBUTES
            //CONDITIONAL_PROCESSING_ATTRIBUTES
            //CORE_ATTRIBUTES
            "id", "id",       //, "xml:base", "xml:lang",  "xml:space";
            //GRAPHICAL_EVENT_ATTRIBUTES
            "onclick", "clicked_svg(this.id)",  //,"onactivate",  "onfocusin", "onfocusout", "onload", "onmousedown", "onmousemove", "onmouseout", "onmouseover",  "onmouseup";
            //PRESENTATION_ATTRIBUTES
            //Color and Painting properties:
            "fill", "rgb(255,255,255)",
            "stroke", "rgb(25,118,210)",
            "stroke-width", "2"     //, "color-interpolation", "color-interpolation-filters", "color-profile", "color-rendering", "fill-opacity", "fill-rule", "image-rendering", "marker", "marker-end", "marker-mid", "marker-start", "shape-rendering", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "text-rendering",
            //GRAPHICAL EVENT ATTRIBUTES
            //PRESENTATION ATTRIBUTES
    );

    public NGon(double x, double y) {
        super(new SVGAttributeList(ATTRIBUTES));
        attributes.setValue("id",get_id());
        points.add(new Point(x-24,y));
        points.add(new Point(x-22,y-12));
        points.add(new Point(x-14,y-20));
        points.add(new Point(x+14,y-20));
        points.add(new Point(x+22,y-12));
        points.add(new Point(x+24,y));
        points.add(new Point(x+22,y+12));
        points.add(new Point(x+14,y+20));
        points.add(new Point(x-14,y+20));
        points.add(new Point(x-22,y+12));
        points.add(new Point(x-24,y));
        String s=points.get(0).getX()+ "," +points.get(0).getY() + " " +
                points.get(1).getX()+ "," +points.get(1).getY() + " " +
                points.get(2).getX()+ "," +points.get(2).getY() + " " +
                points.get(3).getX()+ "," +points.get(3).getY() + " " +
                points.get(4).getX()+ "," +points.get(4).getY() + " " +
                points.get(5).getX()+ "," +points.get(5).getY() + " " +
                points.get(6).getX()+ "," +points.get(6).getY() + " " +
                points.get(7).getX()+ "," +points.get(7).getY() + " " +
                points.get(8).getX()+ "," +points.get(8).getY() + " " +
                points.get(9).getX()+ "," +points.get(9).getY() + " " +
                points.get(10).getX()+ "," +points.get(10).getY();
        set_attribute("points",s);
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
        return "\t<polygon "+ s+ " />\n";
    }
    @Override
    public void set_additional_attributes() {
        set_attribute("points",get_points());
    }

}