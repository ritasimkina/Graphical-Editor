public class Menubar implements Component {

    public Iterator createIterator()    {
        return new Iterator.IteratorMenubar(this);
    }

    public String get_html()   {
        String s="//menubar:\n";
        s+="<ul>\n";
        s+="  <li><a class=\"active\" href=\"#home\">Home</a></li>\n";
        s+="  <li><a href=\"#news\">News</a></li>\n";
        s+="  <li><a href=\"#contact\">Contact</a></li>\n";
        s+="  <li style=\"float:right\"><a href=\"#about\">About</a></li>\n";
        s+="</ul>";
        return s;
    }
}