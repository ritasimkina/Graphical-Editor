public interface Iterator {
    public Iterator createIterator();


    public class IteratorComponent implements Iterator {
        public Iterator createIterator()    {
            return new IteratorComponent();
        }

    }
    public class IteratorMenubar implements Iterator {
        Menubar menubar;

        public IteratorMenubar(Menubar m)    {
            menubar=m;
        }
        public Iterator createIterator() {
            return null;
        }
    }
}
