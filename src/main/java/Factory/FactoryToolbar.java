package Factory;

import Component.Component;
import Debug.Debug;
import Screen.Toolbar.Toolbar;

public class FactoryToolbar implements Factory {
    public Component create() {
        Debug.out(Thread.currentThread());
        return new Toolbar();
    }
}