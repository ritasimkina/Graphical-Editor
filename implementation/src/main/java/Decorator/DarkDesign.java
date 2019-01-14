package Decorator;

public class DarkDesign extends DecoratorFileSVG {

    public DarkDesign(Format format)
    {
        super(format);
    }

    public String get_format() {

        return decorator.get_format() +

                "#menu {top: 0; background-color : #3c3c3c;}\n" +
                "#menu, #footer {left: 0; height: 60px; position: absolute; width: 100%; padding: 0px; margin-left: 0px;}\n" +
                "#menu, #footer {left: 0; position: absolute; width: 100%; padding: 0px; margin-left: 0px;}\n" +
                "#toolbar {position: relative; top: -8px; background-color : #8c8c8c;}\n" +
                "#operations {position: relative; left: 0; top: -8px; width : 75px; height: 100%; float: left; background-color : #8c8c8c;}\n" +
                "#layers {position: relative; right: 0; top: -8px; width : 75px; height: 100%; float: right; background-color : #8c8c8c;}\n" +
                "#footer {bottom: 0; background-color : #3c3c3c;}\n" +
                "</style>\n" +
                "</head>\n\n";
    }
}