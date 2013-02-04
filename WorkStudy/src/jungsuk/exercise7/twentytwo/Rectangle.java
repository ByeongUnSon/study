package jungsuk.exercise7.twentytwo;

public class Rectangle extends Shape {

	double width;
	double height;
		
	public Rectangle(double width, double height) {
		this(new Point(0,0), width, height);
	}
	
	public Rectangle(Point p, double width, double height) {
		super(p);
		this.width = width;
		this.height = height;
	}
	
	public boolean isSqure() {
		return width == height && width * height != 0;  
	}
	
	@Override
	double calcArea() {
		return width * height;
	}

}
