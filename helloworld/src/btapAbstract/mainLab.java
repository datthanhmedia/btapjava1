package btapAbstract;

import java.util.Scanner;

public class mainLab {
static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
	int carWheel = input.nextInt();
	String carFuel = input.next();
	String carFact = input.next();
	Car car1 = new Car(carWheel, carFuel, carFact);
	
	System.out.println(car1.getNumWheel() + ", " + car1.getFuel() + ", " + car1.getFact() + ", " + car1.sound());
	
	int bicWheel = input.nextInt();
	String bicFuel = input.next();
	String bicFact = input.next();
	Car bic1 = new Car(bicWheel, bicFuel, bicFact);
	System.out.println(bic1.getNumWheel() + ", " + bic1.getFuel() + ", " + bic1.getFact() + ", " + bic1.sound());
	
	}

}
