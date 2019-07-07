package kieudulieu;

public interface EmployeeDAO {
	public void addEmployee();
	public void showEmployee();
	public Employee searchEmployee(String tennv);
	public  void updateEmployee(String tennv);
}
