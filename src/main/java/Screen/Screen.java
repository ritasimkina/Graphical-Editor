package Screen;

import Debug.*;
import Component.*;
import Observer.ToolbarLayerObserver;
import Screen.DrawArray.DrawArray;
import Factory.*;
import Screen.Toolbar.ToolbarLayer;
import Strategy.StrategySvgEdit;
import Strategy.StrategySvgShow;

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

    public boolean create_shape(String name, String params)    {
        return ((DrawArray) drawarray).create_shape(name, params);
    }

    public void select_svg(String name)  {
        //screen.select_svg( name);
        ((DrawArray)drawarray).select_svg(name);
    }
    public void select_layer(String name)  {
        //screen.select_svg( name);
        ((DrawArray)drawarray).select_layer(name);
    }
    public void show_layer(String name)  {
        //screen.select_svg( name);
        ((DrawArray)drawarray).show_layer(name);
    }
    public void add_layer()  {
        Component c=((DrawArray)drawarray).add_layer();
        toolbar_layer_observer.add_subject(c);
        c.registerObserver(toolbar_layer_observer);
        c.set_clicked(true);    // now draw on this layer
    }
    public void edit_svg()  {
        ((DrawArray)drawarray).set_strategy(new StrategySvgEdit(drawarray));
    }
    public void edit_svg_end(String parameter)  {
        if (!parameter.isEmpty())    {
            Component c=((DrawArray)drawarray).aktiv_component();
            c.set_attributes(parameter);
        }
        ((DrawArray)drawarray).set_strategy(new StrategySvgShow(drawarray));
    }
    public void delete_component()  {

        ((DrawArray)drawarray).delete_aktiv_component();
    }
    public void save()  {

        ((DrawArray)drawarray).save();
    }
}
