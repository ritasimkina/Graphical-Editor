import java.util.ArrayList;
import java.util.List;

public class Screen {
    Composite screen = new Composite();
    Component menubar;  // zum test

    public Screen() {
        FactoryUI factory_menubar = new FactoryMenubar();                       /*Component*/ menubar=factory_menubar.create();
        FactoryUI factory_toolbar = new FactoryToolbar();                       //Component toolbar=factory_toolbar.create();
        FactoryUI factory_toolbar_operation = new FactoryToolbarOperation();    //Component toolbar_operation=factory_toolbar_operation.create();
        FactoryUI factory_drawarray = new FactoryDrawArray();                   //Component drawarray=factory_drawarray.create();
        FactoryUI factory_toolbar_layer = new FactoryToolbarLayer();            //Component toolbar_layer=factory_toolbar_layer.create();
        FactoryUI factory_infobar = new FactoryInfobar();                       //Component infobar=factory_infobar.create();

        screen.add(menubar);
        screen.add(factory_toolbar.create());
        screen.add(factory_toolbar_operation.create());
        screen.add(factory_drawarray.create());
        screen.add(factory_toolbar_layer.create());
        screen.add(factory_infobar.create());
    }

    public String get_html()   {
        //später über iterator:
        //Iterator it = screen.createIterator();
        
        return menubar.get_html();  //zum test
    }



}
