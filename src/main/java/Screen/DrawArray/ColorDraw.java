package Screen.DrawArray;

import Tools.SVGAttributeList;

public class ColorDraw extends Draw {
    private final Draw draw;

    public ColorDraw(Draw draw, String color) {
        super(draw.getAttributes());
        draw.getAttributes().setValue("stroke", color);
        this.draw = draw;
        this.points = draw.points;
    }

    @Override
    public SVGAttributeList make_clicked(SVGAttributeList al)    {
        return draw.make_clicked(al);
    }

    @Override
    public String souround_svg_type(String s) {
        return draw.souround_svg_type(s);
    }
}
