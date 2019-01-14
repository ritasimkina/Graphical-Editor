package Iterator;

import Component.Component;
import Component.Composite;
import Debug.Debug;
import Screen.DrawArray.Draw;

public class IteratorSvgs implements Iterator {
    Composite component=null;
    int current=0;
    int next=-1;

    public IteratorSvgs(Component c) {
        Debug.out(Thread.currentThread());
        component=(Composite)c;
        current=-1;
    }


    @Override
    public boolean hasNext() {
        for(++next;next< component.size();next++)    {
            if( ((Composite) component).get(next)  instanceof Draw) return true;
        }
        return false;
    }
    @Override
    public Component next() {
        current=next;
        return component.get(next);
    }
}
