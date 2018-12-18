package Screen.DrawArray;
import java.util.Random;



import Debug.*;
import Iterator.*;
import Component.*;
import Component.Composite;
import Screen.DrawArray.Draws.*;


public class Layer extends Composite {
    Random rand = new Random();
    Composite draws = new Composite();

    public Iterator createIterator() {
        assert false;
        return null;
    }
    public Layer() { Debug.out(Thread.currentThread());
        //draws.add(new Text("Hello World!!!!"));
    }

    public String get_html()   {
        if(is_visible()) return draws.get_html();
        else return "// hiden Layer\n";
    }

    public boolean create_shape(String name)    {
        // ToDo:: für aktiven layer
        boolean result=true;

        double x=rand.nextInt(100)*5 ;
        double y=rand.nextInt(100) *5;


        switch (name) {
            case "Circle":
                draws.add(new Circle(x, y, 10));
                break;
            case "Elipse":
                draws.add(new Elipse(x, y, 10,20));
                break;
            case "Line":
                draws.add(new Line(50,50, x,y));
                break;
            case "NGon":
                //draws.add(new Text("Text"));
                break;
            case "Quadrangle":
                draws.add(new Quadrangle(x,y,50,50));
                break;
            case "Star":
                draws.add(new Star(x, y));
                break;
            case "Text":
                draws.add(new Text("Text",x,y));
                break;
            case "Triangle":
                draws.add(new Triangle(x,y));
                break;
            default:
                result=false;
        }
        return result;
    }


}