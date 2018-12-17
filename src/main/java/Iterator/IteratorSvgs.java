package Iterator;

import Component.Component;
import Debug.Debug;
import Screen.DrawArray.Draws.Quadrangle;

public class IteratorSvgs implements Iterator {
    Component component=null;
    int current=0;

    public IteratorSvgs(Component c) {
        Debug.out(Thread.currentThread());
        component=c;
        current=0;
    }


    @Override
    public boolean hasNext() {
        return  current<component.size();
    }

    @Override
    public Component next() {
        return component.get(current++);
    }
}
