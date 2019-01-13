package Factory;

import Component.*;
import Debug.Debug;
import Screen.Toolbar.Toolbar;
import Tools.BeanContainer;
import Tools.Context;

public class FactoryToolbar implements Factory {
    private final Context context;

    public FactoryToolbar() {
        context = BeanContainer.get(Context.class);
    }

    public Component create() {
        Debug.out(Thread.currentThread());
        return new Toolbar(context);
    }
}