public interface FactoryUI {
    public Component create();

    public class FactoryMenubar implements FactoryUI {
        public Component create() {
            return new Menubar();
        }
    }
    public class FactoryToolbar implements FactoryUI {
        public Component create() {
            return new Toolbar();
        }
    }
    public class FactoryToolbarLayer implements FactoryUI {
        public Component create() {
            return new ToolbarLayer();
        }
    }
    public class FactoryToolbarOperation implements FactoryUI {
        public Component create() {
            return new ToolbarOperation();
        }
    }
    public class FactoryInfobar implements FactoryUI {
        public Component create() {
            return new Infobar();
        }
    }
    public class FactoryDrawArray implements FactoryUI {
        public Component create()   {
            return new DrawArray();
        }
    }
}
