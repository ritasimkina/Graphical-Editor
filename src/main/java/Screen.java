public class Screen {
    //muss noch ins composite:
    Component menubar;
    Component toolbar;
    Component infobar;

    public Screen() {
        //gehört noch ins composite:
        FactoryUI factory_menubar = new FactoryMenubar();
        /*Component*/ menubar=factory_menubar.create();

        FactoryUI factory_toolbar = new FactoryToolbar();
        /*Component*/ toolbar=factory_toolbar.create();

        FactoryUI factory_infobar = new FactoryInfobar();
        /*Component*/ infobar=factory_infobar.create();

    }

    public String get_html()   {
        //später über iterator:
        return menubar.get_html();
    }

}
