package Screen.DrawArray;
import java.util.Random;



import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;
import Screen.DrawArray.Draws.*;

public class Layer implements Component {
    Random rand = new Random();
    Component.Composite draws = new Component.Composite();

    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public Iterator createIterator() {
        assert false;
        return null;
    }
    public Layer() { Debug.out(Thread.currentThread());
        //draws.add(new Text("Hello World!!!!"));
    }

    public String get_html()   {
        return draws.get_html();
    }


    public boolean create_shape(String name)    {
        // ToDo:: für aktiven layer
        boolean result=true;

        switch (name) {
            case "Circle":
                draws.add(new Circle(10, 10, 10));
                break;
            case "Elipse":
                draws.add(new Elipse(10, 10, 10,20));
                break;
            case "Line":
                draws.add(new Line(10,10, rand.nextInt(100) + 10,rand.nextInt(100) + 10));
                break;
            case "NGon":
                //draws.add(new Text("Text"));
                break;
            case "Quadrangle":
                draws.add(new Quadrangle(20,20,50,50));
                break;
            case "Star":
                draws.add(new Star(50, 50));
                break;
            case "Text":
                draws.add(new Text("Text",20,20));
                break;
            case "Triangle":
                draws.add(new Triangle(20,20));
                break;
            default:
                result=false;
        }
        return result;
    }


}