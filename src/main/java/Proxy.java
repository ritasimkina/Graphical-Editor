public class Proxy {
    private Screen screen;

    public Proxy() {
        screen = new Screen();
    }

    private String get_styles()   {return "";}
    private String get_body()   {
        return "<body>\n"+
                screen.get_html() + "\n"+
                "</body>\n";
    }
    private String get_head()   {
        return "<!DOCTYPE HTML>\n" +
                "<html lang=\"en\">\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<script src=\"./d3.js\"></script>\n" +
                //"\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n" +
                "\t</head>\n" +
                "\t\n";

    }


    public String get_html()   {
        String s=get_head();
        s+=get_body();
        return s;
    }

}
