
import Debug.*;
import Decorator.DarkDesign;
import Decorator.Format;
import Decorator.LightDesign;
import Decorator.PlainFormat;
import Screen.DrawArray.DrawArray;
import Screen.Screen;

public class Proxy {
    static final String HTML_START = "<html>\n\n<head>\n<title>Forms</title>\n";
    static final String HTML_END = "\n</html>";

    private Screen screen;
    private Format decorator = null;

    public Proxy() {    Debug.out(Thread.currentThread());
        screen = new Screen();
    }

    private String get_styles()   { Debug.out(Thread.currentThread());
    return "";
    }
    private String get_body()   {   Debug.out(Thread.currentThread());
        return "<body>\n" +
                    screen.get_html() +
                "\n</body>\n";
    }

    private String get_format()   {   Debug.out(Thread.currentThread());

        if(decorator == null)
        {
            decorator = new LightDesign(new PlainFormat());
        }
        String formatting = decorator.get_format();
        return formatting;
    }

    public void set_LightDesign()
    {
        decorator = new LightDesign(new PlainFormat());
    }

    public void set_DarkDesign()
    {
        decorator = new DarkDesign(new PlainFormat());
    }

    public String get_html()   {    Debug.out(Thread.currentThread());
        String s=HTML_START+get_format();
        s+=get_body();
        return s+HTML_END;
    }

    public boolean create_shape(String name)    {
        return screen.create_shape(name);
    }

    public void select_layer(String name)  {
        screen.select_layer(name);
    }
    public void show_layer(String name)  {
        screen.show_layer(name);
    }
    public void select_svg(String name)  {
        screen.select_svg(name);
    }
    public void add_layer()  {
        screen.add_layer();
    }
    public void edit()  {
        screen.edit_svg();
    }
    public void edit_end(String parameter)  {
        screen.edit_svg_end(parameter);
    }
    public void delete() { screen.delete_component(); }
    public void save() { screen.save(); }
}
