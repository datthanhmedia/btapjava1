/**
 * 
 */
package kieudulieu;

/**
 * @author Admin
 *
 */
public class Employee {

	/**
	 * @param args
	 */
	protected String name;
	protected int id;
	protected double Salary;
	protected int age;
	protected boolean Maried;
	protected job job;
	public Employee(String name, int id, double salary, int age, boolean maried, kieudulieu.job job) {
		super();
		this.name = name;
		this.id = id;
		Salary = salary;
		this.age = age;
		Maried = maried;
		this.job = job;
	}

}
