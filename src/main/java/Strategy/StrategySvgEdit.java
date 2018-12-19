package Strategy;

import Component.Component;

public class StrategySvgEdit extends Strategy{

    public StrategySvgEdit(Component c) {
        super(c);
    }

    @Override
    public String get_html() {
        return component.get_edit_html();
    }
}
