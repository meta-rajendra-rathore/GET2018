package factoryforADT.implementation;

/**
 * 
 * @author Rajendra Singh Rathore
 */


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import factoryforADT.implementation.Shape.ShapeType;

public class ScreenTest {

	@Test
	public void testAddShapes() {
		Screen.addShape(ShapeType.Circle, new Point(20, 113), new ArrayList<>(Arrays.asList(300d)));
		Screen.addShape(ShapeType.Circle, new Point(20, 3), new ArrayList<>(Arrays.asList(30d)));
		Screen.addShape(ShapeType.Rectangle, new Point(1, 23), new ArrayList<>(Arrays.asList(12d, 23d)));
		
	}

}
