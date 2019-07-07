package thuake;

public class Dog extends Animals{

	private String typeAnimal;

	public Dog(String name, int age, String typeAnimal) {
		super(name, age);
		this.typeAnimal = typeAnimal;
	}

	public String getTypeAnimal() {
		return typeAnimal;
	}

	public void setTypeAnimal(String typeAnimal) {
		this.typeAnimal = typeAnimal;
	}

}
