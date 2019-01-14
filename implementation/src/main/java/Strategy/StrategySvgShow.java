package Strategy;

import Component.Component;

public class StrategySvgShow extends Strategy{

    public StrategySvgShow(Component c) {
        super(c);
    }

    @Override
    public String get_html() {
        return component.get_show_html();
    }
}
