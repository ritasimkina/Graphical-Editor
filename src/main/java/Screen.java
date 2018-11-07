public class Screen {
    public Screen() {
        FactoryUI factory_menubar = new FactoryMenubar();
        Component menubar=factory_menubar.create();

        FactoryUI factory_toolbar = new FactoryToolbar();
        Component toolbar=factory_toolbar.create();

        FactoryUI factory_infobar = new FactoryInfobar();
        Component infobar=factory_infobar.create();

        System.out.println("infobar="+infobar);
    }


}
