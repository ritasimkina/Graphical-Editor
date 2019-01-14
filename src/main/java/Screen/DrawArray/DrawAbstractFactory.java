package Screen.DrawArray;

import Tools.BeanContainer;
import Tools.Context;

import java.util.Optional;

public abstract class DrawAbstractFactory {

    static DrawAbstractFactory getFactory(DrawAttribute attribute) {
        Context context = BeanContainer.get(Context.class);
        switch (attribute) {
            case COLOR:
                return new ColorAbstractFactory(context);
            case DEFAULT:
                return new DefaultAbstractFactory(context);
            default: return new DefaultAbstractFactory(context);
        }
    }

    abstract Optional<Draw> create(String name);

    enum DrawAttribute {
        COLOR,
        DEFAULT
    }
}
