package btapAbstract;

public class Car extends Vehicle{
	String sound;
	public Car(int numWheel, String fuel, String fact) {
		super(numWheel, fuel, fact);
	}
	public String sound() {
		this.sound="Ting Ting";
		return this.sound;
}
}

