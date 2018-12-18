package Component;

public abstract class Component implements IComponent {
    protected static int id_count=0;
    protected String id="?";
    boolean visible=true;
    boolean clicked=false;

    public String get_id_tag()   {
        return "id="+get_id();
    }
    public String get_id()    {
        return id;
    }

    public boolean is_visible()    {
        return visible;
    }

    public void set_clicked(boolean state) {
        clicked=state;
    }
    public boolean get_clicked() {
        return clicked;
    }
}
