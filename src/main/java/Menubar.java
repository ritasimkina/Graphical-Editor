public class Menubar implements Component {

    public Iterator createIterator()    {   Debug.out(Thread.currentThread());
        return new Iterator.IteratorMenubar(this);
    }

    public String get_html()   { Debug.out(Thread.currentThread());
        String s= "<div id=\"menu\"> Menu</div>";
        return s;
    }
}