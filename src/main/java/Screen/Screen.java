package Screen;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.ToolbarObserver;
import Screen.DrawArray.DrawArray;
import Factory.*;

public class Screen {
    Composite screen = new Composite();
    Component drawarray;    // for direct (faster) access
    ToolbarObserver toolbar_observer=new ToolbarObserver();

    public Screen() {   Debug.out(Thread.currentThread());
        Factory factory_menubar = new FactoryMenubar();                       Component menubar=factory_menubar.create();
        Factory factory_toolbar = new FactoryToolbar();                       Component toolbar=factory_toolbar.create();
        Factory factory_toolbar_operation = new FactoryToolbarOperation();    Component toolbarOperation=factory_toolbar_operation.create();
        Factory factory_toolbar_layer = new FactoryToolbarLayer();            Component toolbarLayer=factory_toolbar_layer.create();
        Factory factory_infobar = new FactoryInfobar();                       Component infobar=factory_infobar.create();
        Factory factory_drawarray = new FactoryDrawArray();                   drawarray=factory_drawarray.create();

        screen.add(menubar);
        screen.add(toolbar);
        screen.add(toolbarOperation);
        screen.add(toolbarLayer); // in drawarray
        screen.add(drawarray);
        screen.add(infobar);
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
        c.registerObserver(toolbar_observer);
        c.notifyObservers();
        // register toolbarLayer
    }

}
