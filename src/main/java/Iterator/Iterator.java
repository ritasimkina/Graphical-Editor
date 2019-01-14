package Iterator;
import Component.Component;

public interface Iterator {

    // Returns true if there is a next element. Otherwise, returns false.
    boolean hasNext();

    // Returns the next element. A NoSuchElementException is thrown if there is not a next element.
    Component next( );
}
