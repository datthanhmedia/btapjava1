package thuake;

public class Triangle extends Shape {
	private static int base;
	private static int height;
	public Triangle(String color, int base, int height) {
		super(color);
		this.base = base;
		this.height = height;
	}
	public static int getBase() {
		return base;
	}
	public static void setBase(int base) {
		Triangle.base = base;
	}
	public static int getHeight() {
		return height;
	}
	public static void setHeight(int height) {
		Triangle.height = height;
	}
@Override
public double getArea() {
	// TODO Auto-generated method stub
	return 0.5*this.base*this.height;
}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getColor();
	}
}
