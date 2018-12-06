package Screen.DrawArray;
import Iterator.*;
import Component.*;
import Debug.*;
import Observer.Observer;
import Observer.ToolbarObserver;

import java.util.ArrayList;
import java.util.List;

/*

public abstract class Shape {

	private	ArrayList<Double> x;
	private ArrayList<Double> y;
	private String id;
	private String colour;

	private double diag;



	public Shape(ArrayList<Double> x, ArrayList<Double> y, String id, String colour) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.colour = colour;

	}

	public Shape(){}


 */
public abstract class Draw implements Component {
    List<Observer> observers = new ArrayList<Observer>();
    protected  List<Point> points = new ArrayList<Point>();
    protected  List<Color> color = new ArrayList<Color>();

    public Iterator createIterator() {
        assert false;
        return null;
    }

    public void registerObserver(Observer o)  {
        observers.add(o);
    }
    public void notifyObservers()  {
        for (Observer i: observers  ) {
            i.update();
        }
    }

    public Draw()   {
//        registerObserver(new ToolbarObserver(this));
    }
    public void addPoint(Point p)   {
        points.add(p);
    }
    public void addColor(int r, int g, int b)   {
        color.add(new Color(r,g,b));
    }





    public abstract String get_html();


}