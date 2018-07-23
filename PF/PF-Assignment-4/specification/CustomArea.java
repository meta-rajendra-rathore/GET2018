/**
 * This class computes Area of Different Geometrical Shapes
 * @author Rajendra Singh Rathore
 *
 */

package specification;

import java.text.DecimalFormat;

public class CustomArea {
	DecimalFormat df = new DecimalFormat("####0.00");

	/**
	 * Calculate Area of Triangle
	 * 
	 * @param width
	 * @param height
	 * @return area of triangle
	 */
	double areaOfTriangle(double width, double height) {
		if (width < 0 || height < 0) {
			throw new AssertionError();
		}
		return Double.parseDouble(df.format(width * height * 0.5));
	}

	/**
	 * Computes Area of Rectangle
	 * 
	 * @param width
	 * @param height
	 * @return area of rectangle
	 */
	double areaOfRectangle(double width, double height) {
		if (width < 0 || height < 0) {
			throw new AssertionError();
		}
		return Double.parseDouble(df.format(width * height));
	}

	/**
	 * Computes Area of Square
	 * 
	 * @param width
	 * @return area of square
	 */
	double areaOfSquare(double width) {
		if (width < 0) {
			throw new AssertionError();
		}
		return Double.parseDouble(df.format(width * width));
	}

	/**
	 * Computes Area of Circle
	 * 
	 * @param radius
	 * @return area of circle
	 */
	double areaOfCircle(double radius) {
		if (radius < 0) {
			throw new AssertionError();
		}
		return Double.parseDouble(df.format(Math.PI * radius * radius));
	}
}