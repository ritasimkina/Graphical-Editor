package Screen.DrawArray.Draws;

import Screen.DrawArray.Color;
import Screen.DrawArray.Draw;
import Screen.DrawArray.Point;
import Tools.SVGAttributeList;
import java.util.Arrays;
import java.util.List;

public class Star  extends Draw {
    static List<String> ATTRIBUTES= Arrays.asList(
            //ATTRIBUTES
            "class", "svg_star",
            "transform", "",
            "points","",
            //CORE_ATTRIBUTES
            "id", "id",
            //GRAPHICAL_EVENT_ATTRIBUTES
            "onclick", "clicked_svg(this.id)",
            //Color and Painting properties:
            "fill", "rgb(255,255,255)",
            "stroke", "rgb(25,118,210)",
            "stroke-width", "2"
    );

    public Star(double x, double y) {
        super(new SVGAttributeList(ATTRIBUTES));
        attributes.setValue("id",get_id());
        points.add(new Point(x,y-20));
        points.add(new Point(x+20,y+20));
        points.add(new Point(x-20,y-10));
        points.add(new Point(x+20,y-10));
        points.add(new Point(x-20,y+20));
        points.add(new Point(x,y-20));
        String s=points.get(0).getX()+ "," +points.get(0).getY() + " " +
                points.get(1).getX()+ "," +points.get(1).getY() + " " +
                points.get(2).getX()+ "," +points.get(2).getY() + " " +
                points.get(3).getX()+ "," +points.get(3).getY() + " " +
                points.get(4).getX()+ "," +points.get(4).getY() + " " +
                points.get(5).getX()+ "," +points.get(5).getY();
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