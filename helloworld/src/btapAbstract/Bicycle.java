package btapAbstract;

public class Bicycle extends Vehicle {
	String sound;
	public Bicycle(int numWheel, String fuel, String fact) {
		super(numWheel, fuel, fact);
	}
	public String sound() {
		this.sound="beep beep";
		return this.sound;
}

}
