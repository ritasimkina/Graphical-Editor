
import Debug.*;
import Screen.DrawArray.DrawArray;
import Screen.Screen;

public class Proxy {
    private Screen screen;

    public Proxy() {    Debug.out(Thread.currentThread());
        screen = new Screen();
    }

    private String get_styles()   { Debug.out(Thread.currentThread());
    return "";
    }
    private String get_body()   {   Debug.out(Thread.currentThread());
        return "<body>" +
                screen.get_html() + "\n"+
                "</body>\n";
    }
    private String get_head()   {   Debug.out(Thread.currentThread());

        String formatting =
                "<style type=\"text/css\">\n" +
                        "html, body {height: 100%; overflow: hidden;}\n" +
                        "body {padding-bottom: 60px; padding-top: 60px; box-sizing: border-box ;}\n" +
                        "#menu, #footer {left: 0; height: 60px; position: absolute; width: 100%; padding: 0px; margin-left: 0px;}\n" +
                        "#menu {top: 0; background-color : #1976d2;}\n" +
                        "#footer {bottom: 0; background-color : #1976d2;}\n" +
                        "#operations {position: relative; left: 0; top: -8px; width : 100px; height: 100%; float: left; background-color : #bbdefb;}\n" +
                        "#layers {position: relative; right: 0; top: -8px; width : 100px; height: 100%; float: right; background-color : #bbdefb;}\n" +
                        "</style>\n" +
                        "</head>";

        return formatting;

        /*return "HTTP/1.1 200 OK"+
                "Content-Type: text/html"+
                "<!DOCTYPE HTML>\n" +
                "<html lang=\"en\">\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<script src=\"./d3.js\"></script>\n" +
                //"\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n" +
                "\t</head>\n" +
                "\t\n";*/
    }



    public String get_html()   {    Debug.out(Thread.currentThread());
        String s=get_head();
        s+=get_body();
        return s;
    }

    public boolean create_shape(String name)    {
        return screen.create_shape(name);
    }
}
