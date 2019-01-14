package Factory;

import Debug.*;
import Component.*;
import Screen.DrawArray.DrawArray;

public class FactoryDrawArray implements Factory {
    public Component create()   {
        Debug.out(Thread.currentThread());
        return new DrawArray();
    }
}