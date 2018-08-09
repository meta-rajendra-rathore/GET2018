/**
 * This interface is made for Shapes Properties
 * 
 * @author Rajendra Singh Rathore
 *
 */

package factoryforADT.implementation;

public interface Shape {

    enum ShapeType {
        Square, Rectangle, Circle, Triangle;
    }

    double getArea();

    double getPerimeter();

    Point getOrigin();

    boolean isPointEnclosed(Point isPointEnclosed);

    long getTimestamp();

    ShapeType getShapeType();
}