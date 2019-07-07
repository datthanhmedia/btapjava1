package thuake;

public class MainShape {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle("red", 3, 5);
		Triangle triangle = new Triangle("gray", 6, 8);
		System.out.println("HCN mau " + rectangle.toString() + " co dien tich la: " + rectangle.getArea());
		int a = 3*8;
		System.out.println("Tam giac mau: " + triangle.toString() + " co dien tich la: " + triangle.getArea());
	}
	class pig extends Shape {

		public pig(String color) {
			super(color);
			// TODO Auto-generated constructor stub
		}
		
	}

}
