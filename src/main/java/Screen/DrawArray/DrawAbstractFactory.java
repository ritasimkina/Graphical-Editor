package Screen.DrawArray;

import java.util.Map;
import java.util.Optional;

public abstract class DrawAbstractFactory {

    // concrete factory class appropriate for the given architecture.
    static DrawAbstractFactory getFactory(DrawAttribute attribute, Map<String, String> params) {
        switch (attribute) {
            case COLOR:
                return new ColorAbstractFactory(params);
            case DEFAULT:
                return new DefaultAbstractFactory();
            default: return new DefaultAbstractFactory();
        }
    }

    abstract Optional<Draw> create(String name);

    enum DrawAttribute {
        COLOR,
        DEFAULT
    }
}
