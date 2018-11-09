public class Screen {
    //muss noch ins composite:
    Component combonent;
    Component menubar;
    Component toolbar;
    Component infobar;

    public Screen() {
        //gehört noch ins composite:
        FactoryUI factory_menubar = new FactoryMenubar(); Component menubar=factory_menubar.create();
        FactoryUI factory_toolbar = new FactoryToolbar(); Component toolbar=factory_toolbar.create();
        //FactoryUI factory_toolbar_operation = new FactoryToolbarOperation(); Component toolbar_operation=factory_toolbar_operation.create();
        FactoryUI factory_drawarray = new FactoryDrawArray(); Component drawarray=factory_drawarray.create();
        //FactoryUI factory_toolbar_layer = new FactoryToolbarLayer(); Component toolbar_layer=factory_toolbar_layer.create();
        FactoryUI factory_infobar = new FactoryInfobar(); Component infobar=factory_infobar.create();

    }

    public String get_html()   {
        //später über iterator:

        //IteratorComponent it = combonent.create();


        return menubar.get_html();
    }



}
