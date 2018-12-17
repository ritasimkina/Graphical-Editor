package Factory;

import Component.Component;
import Debug.Debug;
import Screen.Infobar.Infobar;

public class FactoryInfobar implements Factory {
    public Component create() {
        Debug.out(Thread.currentThread());
        return new Infobar();
    }
}