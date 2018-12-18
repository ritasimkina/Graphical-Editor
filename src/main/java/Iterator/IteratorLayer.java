package Iterator;

import Component.Composite;
import Component.Component;
import Debug.Debug;


public class IteratorLayer implements Iterator {
    Composite component=null;
    int current=0;

    public IteratorLayer(Composite c) {
        Debug.out(Thread.currentThread());
        component=c;
        current=0;
    }


    @Override
    public boolean hasNext() {
        //if( n instanceof DerivedNode ){
        String s="";
        for (int i=0;i<component.size();i++) {
            s += component.get(i).get_html();
        }

        return false;
    }

    @Override
    public Component next() {
        return null;
    }
}
