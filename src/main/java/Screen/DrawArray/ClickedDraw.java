package Screen.DrawArray;

import Tools.SVGAttributeList;

public class ClickedDraw extends Draw {
    private final Draw draw;

    public ClickedDraw(Draw draw) {
        this.draw = draw;
    }

    @Override
    public SVGAttributeList make_clicked(SVGAttributeList al) {
        Color fill = new Color(draw.attributes.getValue("fill"));
        Color stroke = new Color(draw.attributes.getValue("stroke"));
        al.setValue("fill", fill.gethtml(true));
        al.setValue("stroke", stroke.gethtml(true));
        return al;
    }

    @Override
    public String souround_svg_type(String s) {
        return draw.souround_svg_type(s);
    }

    @Override
    public void addPoint(Point p) {
        draw.addPoint(p);
    }

    @Override
    public void addColor(int r, int g, int b) {
        draw.addColor(r, g, b);
    }

    @Override
    public String get_onclick() {
        return draw.get_onclick();
    }

    @Override
    public void set_attributes(String parameter) {
        draw.set_attributes(parameter);
    }

    @Override
    public String get_attributes_as_html(SVGAttributeList l) {
        return draw.get_attributes_as_html(l);
    }

    @Override
    public String get_edit_html() {
        return draw.get_edit_html();
    }

    @Override
    public void set_attribute(String key, String value) {
        draw.set_attribute(key, value);
    }

    @Override
    public void set_additional_attributes() {
        draw.set_additional_attributes();
    }

    @Override
    public String get_html() {
        if (!is_clicked()) {
            return draw.get_html();
        }
        SVGAttributeList al = make_clicked(new SVGAttributeList(draw.attributes));
        draw.set_additional_attributes();
        return souround_svg_type(get_attributes_as_html(al));
    }

    @Override
    public String get_points() {
        return draw.get_points();
    }

    @Override
    public String get_id_tag() {
        return draw.get_id_tag();
    }

    @Override
    public String get_id() {
        return draw.get_id();
    }

    @Override
    public String get_show_html() {
        return draw.get_show_html();
    }

    @Override
    public void set_visible(boolean state) {
        draw.set_visible(state);
    }

    @Override
    public boolean is_visible() {
        return draw.is_visible();
    }

    @Override
    public boolean toggle_visible() {
        return draw.toggle_visible();
    }

    @Override
    public void set_clicked(boolean state) {
        draw.set_clicked(state);
    }

    @Override
    public boolean is_clicked() {
        return draw.is_clicked();
    }

    @Override
    public boolean toggle_clicked() {
        return draw.toggle_clicked();
    }

    @Override
    public SVGAttributeList getAttributes() {
        return draw.getAttributes();
    }
}
