package Observer;

import Component.Component;
import Debug.Debug;

import java.util.ArrayList;
import java.util.List;


public class ToolbarLayerObserver implements Observer {
    List<Component> subjects = new ArrayList<Component>();
    List<Boolean> visible = new ArrayList<Boolean>();
    List<String> ids = new ArrayList<String>();
    String clicked_id="";

    public void add_subject(Component subject) {
        subjects.add(subject);
        visible.add(subject.is_visible());
        ids.add(subject.get_id());
    }
    public void update()    {
        Debug.out(Thread.currentThread());
        //System.out.println(Thread.currentThread());
        for (int i=0; i<subjects.size();i++) {
            visible.set(i,subjects.get(i).is_visible());
            if (subjects.get(i).is_clicked())   clicked_id=subjects.get(i).get_id();
        }
    }

    public int size()   {
        return visible.size();
    }
    public Boolean is_visible(int i)   {
        return visible.get(i);
    }
    public String get_id(int i)   {
        return ids.get(i);
    }
    public String clicked_id()   {
        return clicked_id;
    }

}