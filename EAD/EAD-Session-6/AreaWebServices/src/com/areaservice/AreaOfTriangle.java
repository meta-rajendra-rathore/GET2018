/**
 * this class create a web service class to get area of triangle using area function through browser
 */
package com.areaservice;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class AreaOfTriangle {
	public static double getAreaOfTriangle(double side1, double side2, double side3) {
		double semiPerimeter = (side1 + side2 + side3) / 2;
		return Math.sqrt(semiPerimeter * ((semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3)));
	}
}
