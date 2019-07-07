package thuake;

public class MainAnimal {

	public static void main(String[] args) {
		Dog dog = new Dog("kiki", 3, "dog");
	
		System.out.println("Name of " + dog.getTypeAnimal() + " : " + dog.getName());
		System.out.println("Age: " + dog.getAge());
		 Tiger tiger = new Tiger("kikit", 4, "tiger");	
		 System.out.println("Name: " + tiger.getName());
		System.out.println("Age of " + tiger.getTypeAnimal() + " : " + tiger.getAge());
	}
}
