/**
 * 
 * @author Rajendra Singh Rathore
 */

package factoryforADT.implementation;

import java.util.ArrayList;
import java.util.List;

import factoryforADT.implementation.Shape.ShapeType;

public class Screen {
	static ArrayList<Shape> shapesList = new ArrayList<>();

	static void addShape(ShapeType shapeType, Point point, List<Double> parameters) {
		shapesList.add(FactoryShape.createShape(shapeType, point, parameters));
	}

	static boolean deleteShape(ShapeType shapeType, Point point, List<Double> parameters) {
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).getShapeType() == shapeType && shapesList.get(i).getOrigin() == point) {
				shapesList.remove(i);
				return true;
			}
		}
		return false;
	}

	static void deleteShapesOfSpecificType(ShapeType shapeType) {
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).getShapeType() == shapeType) {
				shapesList.remove(i);
			}
		}
	}

	static ArrayList<Shape> ascendingInArea() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getArea() > sortedShapes.get(j + 1).getArea()) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	static ArrayList<Shape> ascendingInPerimeter() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getPerimeter() > sortedShapes.get(j + 1).getPerimeter()) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	static ArrayList<Shape> ascendingInTimestamp() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getTimestamp() > (sortedShapes.get(j + 1).getTimestamp())) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	static ArrayList<Shape> ascendingInOriginDistance() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				double originDistanceJ = Math.sqrt(Math.pow(sortedShapes.get(j).getOrigin().getxPoint(), 2)
						+ Math.pow(sortedShapes.get(j).getOrigin().getyPoint(), 2));
				double originDistanceJ1 = Math.sqrt(Math.pow(sortedShapes.get(j + 1).getOrigin().getxPoint(), 2)
						+ Math.pow(sortedShapes.get(j + 1).getOrigin().getyPoint(), 2));
				if (originDistanceJ > originDistanceJ1) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	static ArrayList<Shape> isPointEnclosed(Point point) {
		ArrayList<Shape> pointEnclosedShapes = new ArrayList<>();
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).isPointEnclosed(point)) {
				pointEnclosedShapes.add(shapesList.get(i));
			}
		}
		return pointEnclosedShapes;
	}
}
