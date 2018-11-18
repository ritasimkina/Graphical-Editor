import java.util.ArrayList;
import java.util.List;

public class Screen {
    Component.Composite screen = new Component.Composite();
    Component menubar;
    Component toolbarOperation;
    Component toolbarLayer;
    Component infobar;

    public Screen() {
        FactoryUI factory_menubar = new FactoryUI.FactoryMenubar();                       /*Component*/ menubar=factory_menubar.create();
        FactoryUI factory_toolbar = new FactoryUI.FactoryToolbar();                       //Component toolbar=factory_toolbar.create();
        FactoryUI factory_toolbar_operation = new FactoryUI.FactoryToolbarOperation();    /*Component*/ toolbarOperation=factory_toolbar_operation.create();
        FactoryUI factory_toolbar_layer = new FactoryUI.FactoryToolbarLayer();            /*Component*/ toolbarLayer=factory_toolbar_layer.create();
        FactoryUI factory_infobar = new FactoryUI.FactoryInfobar();                       /*Component*/ infobar=factory_infobar.create();
        FactoryUI factory_drawarray = new FactoryUI.FactoryDrawArray();                   //Component drawarray=factory_drawarray.create();

        screen.add(menubar);
        screen.add(factory_toolbar.create());
        screen.add(factory_toolbar_operation.create());
        screen.add(factory_drawarray.create());
        screen.add(factory_toolbar_layer.create());
        screen.add(factory_infobar.create());
    }

    public String get_html()   {

        //später über iterator:
        //Iterator itl = screen.createIterator();
        // for (itl->first(), itr->first(); !itl->isDone(); itl->next(), itr->next())

        return menubar.get_html() + toolbarOperation.get_html()  +  toolbarLayer.get_html() + infobar.get_html();

    }



}
