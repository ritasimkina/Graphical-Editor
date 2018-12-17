package Factory;

import Screen.*;
import Debug.*;
import Component.*;
import Screen.DrawArray.DrawArray;

public interface FactoryUI {
    public Component create();

    public class FactoryMenubar implements FactoryUI {
        public Component create() {
            Debug.out(Thread.currentThread());
            return new Menubar();
        }
    }
    public class FactoryToolbar implements FactoryUI {
        public Component create() {
            Debug.out(Thread.currentThread());
            return new Toolbar();
        }
    }
    public class FactoryToolbarLayer implements FactoryUI {
        public Component create() {
            Debug.out(Thread.currentThread());
            return new ToolbarLayer();
        }
    }
    public class FactoryToolbarOperation implements FactoryUI {
        public Component create() {
            Debug.out(Thread.currentThread());
            return new ToolbarOperation();
        }
    }
    public class FactoryInfobar implements FactoryUI {
        public Component create() {
            Debug.out(Thread.currentThread());
            return new Infobar();
        }
    }
    public class FactoryDrawArray implements FactoryUI {
        public Component create()   {
            Debug.out(Thread.currentThread());
            return new DrawArray();
        }
    }
}
