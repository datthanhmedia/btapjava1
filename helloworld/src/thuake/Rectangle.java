package thuake;

public class Rectangle extends Shape {
	private static int width;
	private static int height;
	public Rectangle(String color, int width, int height) {
		super(color);
		this.width = width;
		this.height = height;
	}
	public static int getWidth() {
		return width;
	}
	public static void setWidth(int width) {
		Rectangle.width = width;
	}
	public static int getHeight() {
		return height;
	}
	public static void setHeight(int height) {
		Rectangle.height = height;
	}
@Override
public double getArea() {
	
	return this.height*this.width;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return this.getColor();
}
}
