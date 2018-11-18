import java.util.ArrayList;

public class Circle extends Shape{


	private Double CircleRadius;	
	
	public Circle(String id, ArrayList<Double> x, ArrayList<Double> y, String colour,
			Double CircleRadius, Double diag) {
		super(x, y, id, colour);
		this.CircleRadius = CircleRadius;
	}
	
	/**
	 * @return circles's radius
	 */
	public Double getRadius() {
		return CircleRadius;
	}


	/**
	 * @param set circle's radius
	 */
	public void setRadius(Double radius) {
		this.CircleRadius = radius;
	}



	
}
