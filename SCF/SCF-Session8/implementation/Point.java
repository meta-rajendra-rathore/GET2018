package factoryforADT.implementation;


/**
 * This class represent the location of PointX and PointY on a screen size of
 * 1920x1080
 * 
 * @author Rajendra Singh Rathore
 *
 */
public class Point {
	private final double xPoint;
	private final double yPoint;

	public Point(double xPoint, double yPoint) {
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		if (!checkLocation()) {
			System.out.println("Point out of Screen Size");
		}
	}

	boolean checkLocation() {
		if (xPoint >= 0 && xPoint <= 1920 && yPoint >= 0 && yPoint <= 1080) {
			return true;
		}
		return false;
	}

	public double getxPoint() {
		return xPoint;
	}

	public double getyPoint() {
		return yPoint;
	}
}
