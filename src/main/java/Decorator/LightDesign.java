package Decorator;

public class LightDesign extends DecoratorFileSVG {

    public LightDesign(Format format)
    {
        super(format);
    }

    public String get_format() {

        return decorator.get_format() +

                "#menu {top: 0; background-color : #1976d2;}\n" +
                "#menu, #footer {left: 0; height: 60px; position: absolute; width: 100%; padding: 0px; margin-left: 0px;}\n" +
                "#menu, #footer {left: 0; position: absolute; width: 100%; padding: 0px; margin-left: 0px;}\n" +
                "#toolbar {position: relative; top: -8px; background-color : #bbdefb;}\n" +
                "#operations {position: relative; left: 0; top: -8px; width : 75px; height: 100%; float: left; background-color : #bbdefb;}\n" +
                "#layers {position: relative; right: 0; top: -8px; width : 75px; height: 100%; float: right; background-color : #bbdefb;}\n" +
                "#footer {bottom: 0; background-color : #1976d2;}\n" +
                "</style>\n" +
                "</head>\n\n";
    }
}
