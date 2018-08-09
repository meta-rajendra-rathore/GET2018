package factoryforADT.shapes;

import java.text.DecimalFormat;
import factoryforADT.implementation.Point;
import factoryforADT.implementation.Shape;

/**
 * This Circle class implements Shape interface
 * 
 * @author Rajendra Singh Rathore
 *
 */
public class Circle implements Shape {

	private final double radius;
	private final Point origin;
	private final long timestamp;
	private DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	public Circle(double radius, Point origin, long timestamp) {
		this.radius = radius;
		this.origin = origin;
		this.timestamp = timestamp;
		Point originPoint = getOrigin();
		if (originPoint == null) {
			throw new NullPointerException("The Circle is out of Screen");
		}
	}

	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(Math.PI * radius * radius));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(2 * Math.PI * radius));
	}

	@Override
	public Point getOrigin() {
		double valueOfX1;
		double valueOfX2;
		double valueOfY;
		double A;
		double B;
		double C;
		double M = origin.getyPoint() / origin.getxPoint();
		A = (Math.pow(M, 2) + 1);
		B = (-2 * (M * origin.getyPoint() + origin.getxPoint()));
		C = (Math.pow(origin.getyPoint(), 2) + Math.pow(origin.getxPoint(), 2) - Math.pow(radius, 2));
		double underRoot = Math.sqrt((Math.pow(B, 2) - 4 * A * C));
		valueOfX1 = (-B + underRoot) / (2 * A);
		valueOfX2 = (-B - underRoot) / (2 * A);
		if (valueOfX1 <= origin.getxPoint()) {
			valueOfY = M * valueOfX1;
			return new Point(valueOfX1, valueOfY);
		} else if (valueOfX2 <= origin.getxPoint()) {
			valueOfY = M * valueOfX2;

			return new Point(valueOfX2, valueOfY);
		}
		return null;
	}

	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {
		if (Math.pow(origin.getxPoint() - isPointEnclosed.getxPoint(), 2)
				+ Math.pow(origin.getyPoint() - isPointEnclosed.getyPoint(), 2) <= Math.pow(radius, 2)) {
			return true;
		}
		return false;
	}

	@Override
	public long getTimestamp() {
		return timestamp;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.Circle;
	}
}
