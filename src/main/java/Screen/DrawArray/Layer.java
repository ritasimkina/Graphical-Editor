package Screen.DrawArray;
import java.util.Random;



import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;
import Screen.DrawArray.Draws.*;

public class Layer implements Component {
    Random rand = new Random();
    Composite draws = new Composite();

    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public Iterator createIterator() {
        assert false;
        return null;
    }
    public Layer() { Debug.out(Thread.currentThread());
        //draws.add(new Text("Hello World!!!!"));
    }


    @Override
    public Component get(int i) {
        return draws.get(i);
    }
    @Override
    public int size() {
        return draws.size();
    }

    @Override
    public String get_id() {
        return null;
    }

    @Override
    public void set_clicked(boolean state) {

    }

    public String get_html()   {
        if(visible) return draws.get_html();
        else return "// hided Layer\n";
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