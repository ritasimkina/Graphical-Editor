package Strategy;

import Component.Component;

public abstract class Strategy  implements IStrategy{
    Component component;

    public Strategy(Component c)    {
        component=c;
    }

}
