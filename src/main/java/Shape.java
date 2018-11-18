

import java.util.ArrayList;

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
	
	
	

	public ArrayList<Double> getxCoordinates() {
		return x;
	}

	public void setX(ArrayList<Double> x) {
		this.x = x;
	}
	/**
	 * @return the yCoordinates
	 */
	public ArrayList<Double> getY() {
		return y;
	}
	/**
	 * @param yCoordinates the yCoordinates to set
	 */
	public void setY(ArrayList<Double> y) {
		this.y = y;
	}
	/**
	 * @return the name
	 */
	public String getID() {
		return id;
	}

	/**
	 * @return the fill
	 */
	public String getColour() {
		return colour;
	}
	/**
	 * @param fill the fill to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}


	
}