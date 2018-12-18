package Screen;

import Debug.*;
import Component.*;
import Observer.ToolbarLayerObserver;
import Screen.DrawArray.DrawArray;
import Factory.*;
import Screen.Toolbar.ToolbarLayer;

public class Screen {
    Composite screen = new Composite();
    Component drawarray;    // for direct (faster) access
    Component toolbarLayer=null;
    ToolbarLayerObserver toolbar_layer_observer=new ToolbarLayerObserver();

    public Screen() {   Debug.out(Thread.currentThread());
        Factory factory_menubar = new FactoryMenubar();                       Component menubar=factory_menubar.create();
        Factory factory_toolbar = new FactoryToolbar();                       Component toolbar=factory_toolbar.create();
        Factory factory_toolbar_operation = new FactoryToolbarOperation();    Component toolbarOperation=factory_toolbar_operation.create();

        Factory factory_toolbar_layer = new FactoryToolbarLayer();            toolbarLayer=factory_toolbar_layer.create();
        ((ToolbarLayer)toolbarLayer).set_observer(toolbar_layer_observer);

        Factory factory_infobar = new FactoryInfobar();                       Component infobar=factory_infobar.create();
        Factory factory_drawarray = new FactoryDrawArray();                   drawarray=factory_drawarray.create();

        screen.add(menubar);
        screen.add(toolbar);
        screen.add(toolbarOperation);
        screen.add(toolbarLayer); // in drawarray
        screen.add(drawarray);
        screen.add(infobar);

        add_layer();
    }

    public String get_html()   {    Debug.out(Thread.currentThread());
       return screen.get_html();
    }

    public boolean create_shape(String name)    {
        return ((DrawArray) drawarray).create_shape(name);
    }

    public void select_svg(String name)  {
        //screen.select_svg( name);
        ((DrawArray)drawarray).select_svg(name);
    }
    public void add_layer()  {
        Component c=((DrawArray)drawarray).add_layer();
        toolbar_layer_observer.add_subject(c);
        c.registerObserver(toolbar_layer_observer);
    }

}
