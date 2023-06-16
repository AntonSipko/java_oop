package telran.points;

public class Point implements Comparable<Point> {
	private final int x;
	private final int y;
	public Point (int x,int y){
		this.x=x;
		this.y=y;
	}
	@Override
	public int compareTo(Point point) {
		Point start=new Point(0,0);
		double length1=this.getLengthBetween(start);
		double length2=point.getLengthBetween(start);
		return Double.compare(length1, length2);
		
	}
	private double getLengthBetween(Point start) {
		
		return  Math.hypot(x-start.x, y-start.y) ;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	public boolean equals(Object pointObj) {
		Point point=(Point)pointObj;
		return this.x==point.x&&this.y==point.y;
	}
	
	

}
