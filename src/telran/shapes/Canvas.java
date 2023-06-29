package telran.shapes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Canvas implements Shape,Iterable<Shape> {
	private Shape[]shapes=new Shape[0];
	private Shape[]removedShapes=new Shape[0];
	private class CanvasIterator implements Iterator<Shape>{
		int currentIndex=containsInRemoved(0)?getCurrentIndex(0):0;
		boolean flNext=false;
		int previous;

		@Override
		public boolean hasNext() {
			
			return currentIndex<shapes.length-1;
		}

		@Override
		public Shape next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			Shape res=shapes[currentIndex];
			previous=currentIndex;
			currentIndex=getCurrentIndex(currentIndex);
			flNext=true;
			return res;
		}
		private int getCurrentIndex(int index) {
			index++;
			while(index<shapes.length&&containsInRemoved(index)) {
				index++;
			}
			return index;
		}

		@Override
		public void remove() {
			if(!flNext) {
				throw new IllegalStateException();
			}
			addRemove(previous);
			flNext=false;
			
		}
		
	}

	@Override
	public int perimeter() {
		int res=0;
		for(int i=0;i<shapes.length;i++) {
			res+=shapes[i].perimeter();
		}
		return res;
	}

	public void addRemove(int index) {
		removedShapes=Arrays.copyOf(removedShapes, removedShapes.length+1);
		removedShapes[removedShapes.length-1]=shapes[index];
		
		
	}

	public boolean containsInRemoved(int shapeIndex) {
		boolean res=false;
		for (int index = 0; index < removedShapes.length; index++) {
	        if (removedShapes[index] == shapes[shapeIndex]) {
	            res= true;
	        }
	    }
	    return res;
	}

	

	@Override
	public int square() {
		int res=0;
		for(int i=0;i<shapes.length;i++) {
			res+=shapes[i].square();
		}
		return res;
	}

	@Override
	public Iterator<Shape> iterator() {
		return new CanvasIterator();
	}
	public void addShape(Shape shape) {
		shapes=Arrays.copyOf(shapes, shapes.length+1);
		shapes[shapes.length-1]=shape;
	}
	  public boolean removeIf(Predicate<Shape> predicate) {
	    	boolean res=false;
	    	Iterator<Shape>it=iterator();
	    	 while (it.hasNext()) {
	    	        Shape shape = it.next();
	    	        if (predicate.test(shape)) {
	    	            it.remove();
	    	            res = true;
	    	        }
	    	    }
	    	    
	    	    return res;
	    	
	    }
	
    public boolean removeNestedCanvases() {
    	return removeIf(shape -> shape instanceof Canvas);
    }

}
