package btapAbstract;

public abstract class Vehicle {
	private int numWheel;
	private String fuel;
	private String fact;
	private String sound;
		 public Vehicle(int numWheel, String fuel, String fact) {
			 this.numWheel = numWheel;
			 this.fuel = fuel;
			 this.fact = fact;
		 }
		public String sound() {
			this.sound = sound;
			return this.sound;
		}
	
	public int getNumWheel() {
		return numWheel;
	}
	public void setNumWheel(int numWheel) {
		this.numWheel = numWheel;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getFact() {
		return fact;
	}
	public void setFact(String fact) {
		this.fact = fact;
	}
}
