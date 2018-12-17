package Factory;

import Component.Component;
import Debug.Debug;
import Screen.DrawArray.DrawArray;
import Screen.DrawArray.Layer;

public class FactoryLayer implements Factory {
    public Component create()   {
        Debug.out(Thread.currentThread());
        return new Layer();
    }
}