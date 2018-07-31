package factoryforADT.shapes;

import java.text.DecimalFormat;

import factoryforADT.implementation.Point;
import factoryforADT.implementation.Shape;

/**
 * This Triangle class implements Shape interface
 * 
 * @author Rajendra Singh Rathore
 *
 */
public class Triangle implements Shape {
    private Point origin;
    private Point pointA;
    private Point pointB;
    private double height;
    private double base;
    private double sideA;
    private double sideB;
    private double slopeA;
    private double slopeB;
    DecimalFormat df = new DecimalFormat("####0.00");
    long timeStamp;

    public Triangle(double height, double base, double sideA, Point origin, long timestamp) {
        this.height = height;
        this.base = base;
        this.sideA = sideA;
        computeOtherParameters();
        this.origin = origin;
        this.timeStamp = timestamp;
    }

    @Override
    public double getArea() {
        double perimeter = getPerimeter() / 2;
        return Double.parseDouble(
                df.format(Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - base))));
    }

    @Override
    public double getPerimeter() {
        return Double.parseDouble(df.format(sideA + sideB + base));
    }

    public Point getOrigin() {
        return origin;
    }

    public boolean isPointEnclosed(Point isPointEnclosed) {
        if (isPointEnclosed.getyPoint() - slopeA * isPointEnclosed.getxPoint() <= origin.getyPoint()
                - slopeA * origin.getyPoint()
                && isPointEnclosed.getyPoint() - slopeB * isPointEnclosed.getxPoint() <= pointA.getyPoint()
                        - slopeB * pointA.getxPoint()
                && isPointEnclosed.getyPoint() >= origin.getyPoint()) {
            return true;
        }
        return false;
    }

    @Override
    public long getTimestamp() {
        return timeStamp;
    }

    public ShapeType getShapeType() {
        return ShapeType.Triangle;
    }

    private void computeOtherParameters() {
        double difference = Math.sqrt(Math.pow(sideA, 2) - Math.pow(height, 2));
        double otherDifference = base - difference;
        sideB = Math.sqrt(Math.pow(height, 2) + Math.pow(otherDifference, 2));
        pointA = new Point(origin.getxPoint() + difference, origin.getyPoint() + height);
        pointB = new Point(origin.getxPoint() + base, origin.getyPoint());
        slopeA = (pointA.getyPoint() - origin.getyPoint()) / (pointA.getxPoint() - origin.getxPoint());
        slopeB = (pointA.getyPoint() - pointB.getyPoint()) / (pointA.getxPoint() - pointB.getxPoint());
        ;
    }
}
