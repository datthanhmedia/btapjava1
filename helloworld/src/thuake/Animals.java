package thuake;

public class Animals {
	private static String name;
	private static int age;
	public Animals(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
//	public static void getName(String nameAnimal) {
//		name = nameAnimal;
//	}
//	public static String setName() {
//		return name;
//	}
//	public static void getAge(int ageAnimal) {
//		age = ageAnimal;
//	}
//	public static int setAge() {
//		return age;
//	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Animals.name = name;
	}
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		Animals.age = age;
	}
}
