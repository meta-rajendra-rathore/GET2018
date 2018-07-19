/**
 * This class computes Area of Different Geometrical Shapes
 * @author Rajendra Singh Rathore
 *
 */

package calculate_area;

public class CustomArea {

	/**
	 * Calculate Area of Triangle
	 * 
	 * @param width
	 * @param height
	 * @return area of triangle
	 */
	double areaOfTriangle(double width, double height) {
		return width * height * 0.5;
	}

	/**
	 * Computes Area of Rectangle
	 * @param width
	 * @param height
	 * @return area of rectangle 
	 */
	double areaOfRectangle(double width, double height) {
		return width * height;
	}

	/**
	 * Computes Area of Square
	 * @param width
	 * @return area of square
	 */ 
	double areaOfSquare(double width) {
		return width * width;
	}

	/**
	 * Computes Area of Circle
	 * @param radius
	 * @return area of circle
	 */
	double areaOfCircle(double radius) {
		return Math.PI * radius * radius;
	}
}