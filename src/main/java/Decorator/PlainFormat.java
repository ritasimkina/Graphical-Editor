package Decorator;

public class PlainFormat implements Format {

    @Override
    public String get_format(){
        return  "<style type=\"text/css\">\n" +
                "html, body {height: 100%; overflow: hidden;}\n" +
                "body {padding-bottom: 60px; padding-top: 60px; box-sizing: border-box ;}\n";
    }
}
