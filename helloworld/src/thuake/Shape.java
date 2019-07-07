package thuake;

public abstract class Shape {
	private String color;
	public Shape(String color) {
		super();
		this.color = color;
	}
	public abstract double getArea();
	public abstract String toString();
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
