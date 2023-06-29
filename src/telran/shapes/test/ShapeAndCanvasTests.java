package telran.shapes.test;
import java.util.Iterator;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.shapes.Canvas;
import telran.shapes.Rectangle;
import telran.shapes.Shape;
import telran.shapes.Square;
class ShapeAndCanvasTests {
	private Shape rectangle;
	private Shape square;
	private Canvas canvas;
	
    @BeforeEach
    public void setup() {
        canvas = new Canvas();
        rectangle = new Rectangle(4, 6);
        square = new Square(5);
    }

    @Test
    public void testAddShape() {
    	 canvas.addShape(rectangle);
         canvas.addShape(square);

    	 Iterator<Shape> iterator = canvas.iterator();
         int shapeCount = 1;

         while (iterator.hasNext()) {
             iterator.next();
             shapeCount++;
         }

         assertEquals(2, shapeCount);

    }

    @Test
    public void testPerimeter() {
        canvas.addShape(rectangle);
        canvas.addShape(square);

        int expectedPerimeter = rectangle.perimeter()+square.perimeter();
        int actualPerimeter = canvas.perimeter();

        Assertions.assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    public void testSquare() {
        canvas.addShape(rectangle);
        canvas.addShape(square);

        int expectedSquare =   rectangle.square() + square.square();
        int actualSquare = canvas.square();

        Assertions.assertEquals(expectedSquare, actualSquare);
    }

    @Test
    public void testIterator() {
        canvas.addShape(rectangle);
        canvas.addShape(square);
        canvas.addShape(new Rectangle(1,3));
        assertEquals(3, countShapes(canvas));
    }
    @Test
    public void testRemoveIf() {
        canvas.addShape(rectangle);
        canvas.addShape(square);

        Predicate<Shape> predicate = shape -> shape.square() < 25;
        boolean removed = canvas.removeIf(predicate);

        assertTrue(removed);
        assertEquals(1, countShapes(canvas));
        Predicate<Shape> predicate1 = shape -> shape.square() > 30;
        boolean removed2 = canvas.removeIf(predicate);
        assertFalse(removed2);
        assertEquals(1, countShapes(canvas));
        
       
    }
    private int countShapes(Canvas canvas) {
    	Iterator<Shape> iterator = canvas.iterator();
        int count = 1;

        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    	
    }



	
	

	

}
