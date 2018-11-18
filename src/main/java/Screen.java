import java.util.ArrayList;
import java.util.List;
import Debug.*;
import Iterator.*;
import Component.*;
import UI.*;

public class Screen {
    Component.Composite screen = new Component.Composite();

    public Screen() {   Debug.out(Thread.currentThread());
        FactoryUI factory_menubar = new FactoryUI.FactoryMenubar();                       Component menubar=factory_menubar.create();
        FactoryUI factory_toolbar = new FactoryUI.FactoryToolbar();                       Component toolbar=factory_toolbar.create();
        FactoryUI factory_toolbar_operation = new FactoryUI.FactoryToolbarOperation();    Component toolbarOperation=factory_toolbar_operation.create();
        //FactoryUI factory_toolbar_layer = new FactoryUI.FactoryToolbarLayer();            Component toolbarLayer=factory_toolbar_layer.create();
        FactoryUI factory_infobar = new FactoryUI.FactoryInfobar();                       Component infobar=factory_infobar.create();
        FactoryUI factory_drawarray = new FactoryUI.FactoryDrawArray();                   Component drawarray=factory_drawarray.create();

        screen.add(menubar);
        screen.add(toolbar);
        screen.add(toolbarOperation);
        //screen.add(toolbarLayer); // in drawarray
        screen.add(drawarray);
        screen.add(infobar);
    }

    public String get_html()   {    Debug.out(Thread.currentThread());
        return screen.get_html();
    }
}
