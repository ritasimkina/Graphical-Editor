package Factory;

import Component.*;
import Debug.Debug;
import Screen.DrawArray.Layer;

public class FactoryLayer implements Factory {
    public Component create()   {
        Debug.out(Thread.currentThread());
        return new Layer();
    }
}