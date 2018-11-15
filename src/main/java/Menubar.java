public class Menubar implements Component {

    public Iterator createIterator()    {
        return new Iterator.IteratorMenubar(this);
    }

    public String get_html()   {
        String s= "<div id=\"menu\"> Menu</div>";
        return s;
    }
}