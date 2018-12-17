package Iterator;
import Debug.*;
import Screen.Menubar.Menubar;
import Component.Component;

public interface Iterator {

    //Iterator createIterator(Component c);

    //Inserts obj into the list in front of the element that will be returned by the next call to next( ).
    //void add(Object obj)

    // Returns true if there is a next element. Otherwise, returns false.
    boolean hasNext();

    // Returns true if there is a previous element. Otherwise, returns false.
    //boolean hasPrevious( )

    // Returns the next element. A NoSuchElementException is thrown if there is not a next element.
    //Object next( )


    // Returns the index of the next element. If there is not a next element, returns the size of the list.
    //int nextIndex( )

    // Returns the previous element. A NoSuchElementException is thrown if there is not a previous element.
    //Object previous( )

    // Returns the index of the previous element. If there is not a previous element, returns -1.
    //int previousIndex( )

    // Removes the current element from the list. An IllegalStateException is thrown if remove( ) is called before next( ) or previous( ) is invoked.
    //void remove( )

    // Assigns obj to the current element. This is the element last returned by a call to either next( ) or previous( ).
    //void set(Object obj)


    /*public class IteratorComponent implements Iterator {
        public Iterator createIterator()    {
            Debug.out(Thread.currentThread());
            return new IteratorComponent();
        }

        @Override
        public boolean hasNext() {
            return false;
        }
    }*/

    /*public class IteratorMenubar implements Iterator {
        Menubar menubar;

        public IteratorMenubar(Menubar m)    {
            Debug.out(Thread.currentThread());
            menubar=m;
        }
        public Iterator createIterator() {
            Debug.out(Thread.currentThread());
            return null;
        }
        @Override
        public boolean hasNext() {
            return false;
        }
    }*/
}
