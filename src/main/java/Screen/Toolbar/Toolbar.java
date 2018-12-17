package Screen.Toolbar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Toolbar implements Component {
    static List<String> toolbar_names = new ArrayList<String>();

    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public Iterator createIterator() {
        assert false;
        return null;
    }

    public Toolbar()    {
        getClassnames();
    }
    private static void getClassnames() {
        File directory = new File("./src/main/java/Screen/DrawArray/Draws");
        //get all the files from a directory
        File[] files = directory.listFiles();
        for (File file : files){
            if (file.isFile()){
                System.out.println(file.getName());
                String str = file.getName().replace(".java", "");
                toolbar_names.add(str);
            }
        }
    }


    @Override
    public Component get(int i) {
        assert false;
        return null;
    }
    @Override
    public int size() {
        assert false;
        return 0;
    }

    @Override
    public String get_id() {
        return null;
    }

    @Override
    public void set_clicked(boolean state) {

    }

    public String get_html() {
        Debug.out(Thread.currentThread());
        String s = "";

        s+="<div id=\"toolbar\">\n";
        s+="\t<table>";
        for (String i : toolbar_names) {
            s += "\n\t<form action=\"add_svg." + i + "\" method=\"GET\">";
            s += "\n\t\t<button>" + i + "</button>";
            s += "\n\t</form>";
        }
        s+="\n\t</table>\n";
        s+="</div>\n\n";
        return s;
    }

}