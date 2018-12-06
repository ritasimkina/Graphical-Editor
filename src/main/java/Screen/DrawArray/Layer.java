package Screen.DrawArray;
import java.util.Random;



import Debug.*;
import Iterator.*;
import Component.*;

public class Layer implements Component {
    Random rand = new Random();
    Component.Composite draws = new Component.Composite();

    public void registerObserver()  {assert false;}
    public void notifyObservers()  {assert false;}

    public Iterator createIterator() {
        assert false;
        return null;
    }
    public Layer() { Debug.out(Thread.currentThread());
        draws.add(new Text("Hello World!!!!"));
    }

    public String get_html()   {
        return draws.get_html();
    }

    public void new_line()  {
        draws.add(new Line(0,0, rand.nextInt(100) + 10,rand.nextInt(100) + 10));
    }


}