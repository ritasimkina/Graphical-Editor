package Factory;

import Component.Component;
import Debug.Debug;
import Screen.Menubar.Menubar;

public class FactoryMenubar implements Factory {
    public Component create() {
        Debug.out(Thread.currentThread());
        return new Menubar();
    }
}