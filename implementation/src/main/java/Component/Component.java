package Component;

public abstract class Component implements IComponent {
    protected static int id_count=0;
    protected String id="?";
    boolean visible=true;
    boolean clicked=false;


    public void set_attributes(String parameter)    {
        assert false;
    }

    public Component()  {
        id_count++;
        id= Integer.toString(id_count);
    }

    public Component(boolean newID)  {
        if (newID) {
            id_count++;
        }
        id= Integer.toString(id_count);
    }


    public String get_id_tag()   {
        return "id="+get_id();
    }
    public String get_id()    {
        return id;
    }

    public String get_show_html()  {
        // throw
        return "";
    }
    public String get_edit_html()  {
        // throw
        return "";
    }
    public void set_visible(boolean state) {
        visible=state;
    }
    public boolean is_visible() {
        return visible;
    }
    public boolean toggle_visible() {
        visible=!visible;
        notifyObservers();
        return visible;
    }


    public void set_clicked(boolean state) {
        clicked=state;
        notifyObservers();
    }
    public boolean is_clicked() {
        return clicked;
    }
    public boolean toggle_clicked() {
        clicked=!clicked;
        return clicked;
    }


}
