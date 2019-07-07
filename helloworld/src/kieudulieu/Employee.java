/**
 * 
 */
package kieudulieu;

import thuake.Animals;

/**
 * @author Admin
 *
 */
public class Employee {

	/**
	 * @param args
	 */
	private  String name;
	private  int id;
	private  double Salary;
	private  int age;
	private  boolean Maried;
	private  job job;
	public Employee(String name, int id, double salary, int age, boolean maried, kieudulieu.job job) {
		super();
		this.name = name;
		this.id = id;
		Salary = salary;
		this.age = age;
		Maried = maried;
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMaried() {
		return Maried;
	}
	public void setMaried(boolean maried) {
		Maried = maried;
	}
	public job getJob() {
		return job;
	}
	public void setJob(job job) {
		this.job = job;
	}

}
