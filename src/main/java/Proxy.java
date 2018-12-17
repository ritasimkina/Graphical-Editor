
import Debug.*;
import Screen.DrawArray.DrawArray;
import Screen.Screen;

public class Proxy {
    static final String HTML_START = "<html>\n\n<head>\n<title>Forms</title>\n";
    static final String HTML_END = "\n</html>";

    private Screen screen;

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
        String formatting =
                "<style type=\"text/css\">\n" +
                        "html, body {height: 100%; overflow: hidden;}\n" +
                        "body {padding-bottom: 60px; padding-top: 60px; box-sizing: border-box ;}\n" +
                        "#menu {top: 0; background-color : #1976d2;}\n" +
                        "#menu, #footer {left: 0; height: 60px; position: absolute; width: 100%; padding: 0px; margin-left: 0px;}\n" +
                        "#menu, #footer {left: 0; position: absolute; width: 100%; padding: 0px; margin-left: 0px;}\n" +
                        "#toolbar {top: 0; background-color : #1976d2;}\n" +
                        "#operations {position: relative; left: 0; top: 10px; width : 100px; height: 100%; float: left; background-color : #bbdefb;}\n" +
                        "#layers {position: relative; right: 0; top: 10px; width : 100px; height: 100%; float: right; background-color : #bbdefb;}\n" +
                       "#footer {bottom: 0; background-color : #1976d2;}\n" +
                        "</style>\n" +
                        "</head>\n\n";
        return formatting;
    }

    public String get_html()   {    Debug.out(Thread.currentThread());
        String s=HTML_START+get_format();
        s+=get_body();
        return s+HTML_END;
    }

    public boolean create_shape(String name)    {
        return screen.create_shape(name);
    }
}
