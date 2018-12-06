package Iterator;
import Debug.*;
import Screen.Menubar.Menubar;

public interface Iterator {
    public Iterator createIterator();


    public class IteratorComponent implements Iterator {
        public Iterator createIterator()    {
            Debug.out(Thread.currentThread());
            return new IteratorComponent();
        }

    }
    public class IteratorMenubar implements Iterator {
        Menubar menubar;

        public IteratorMenubar(Menubar m)    {
            Debug.out(Thread.currentThread());
            menubar=m;
        }
        public Iterator createIterator() {
            Debug.out(Thread.currentThread());
            return null;
        }
    }
}
