package Decorator;

abstract public class DecoratorFileSVG implements Format {

    protected Format decorator;

    public DecoratorFileSVG(Format format) {

        decorator = format;
    }

    public String get_format() {

        return decorator.get_format();
    }
}
