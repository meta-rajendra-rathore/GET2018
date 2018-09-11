package factoryforADT.shapes;

import java.text.DecimalFormat;
import factoryforADT.implementation.Point;
import factoryforADT.implementation.Shape;

/**
 * This Rectangle class implements Shape interface
 * 
 * @author Rajendra Singh Rathore
 *
 */
public class Rectangle implements Shape {

	final double width;
	final double height;
	final Point origin;
	final long timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	public Rectangle(double width, double height, Point origin, long timestamp) {
		this.width = width;
		this.height = height;
		this.origin = origin;
		this.timestamp = timestamp;
	}

	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(width * height));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(2 * (width + height)));
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {
		if (origin.getxPoint() <= isPointEnclosed.getxPoint()
				&& isPointEnclosed.getxPoint() <= origin.getxPoint() + width) {
			if (origin.getyPoint() <= isPointEnclosed.getyPoint()
					&& isPointEnclosed.getyPoint() <= origin.getyPoint() + height) {
				return true;
			}
		}
		return false;
	}

	@Override
	public long getTimestamp() {
		return timestamp;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.Rectangle;
	}

}
