package Factory;

import Component.*;
import Debug.Debug;
import Screen.Toolbar.ToolbarOperation;

public class FactoryToolbarOperation implements Factory {
    public Component create() {
        Debug.out(Thread.currentThread());
        return new ToolbarOperation();
    }
}