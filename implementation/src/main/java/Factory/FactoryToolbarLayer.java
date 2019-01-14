package Factory;

import Component.*;
import Debug.Debug;
import Screen.Toolbar.ToolbarLayer;

public class FactoryToolbarLayer implements Factory {
    public Component create() {
        Debug.out(Thread.currentThread());
        return new ToolbarLayer();
    }
}