package Iterator;

import Component.Component;
import Debug.Debug;

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


        String s="";
        for (int i=0;i<component.size();i++) {
            s += component.get(i).get_html();
        }

        return false;
    }
}
