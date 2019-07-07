package kieudulieu;

import java.util.Scanner;

public class EmployeeDAOImpl implements EmployeeDAO {
	public static Scanner scanner = new Scanner(System.in);
	public static int inputNumber = 0;
	public static int employeeNumber = 0;
	public static Employee[] employee;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	@Override
	public void addEmployee() {
		// TODO Auto-generated method stub
		System.out.print("Ban muon nhap vao bao nhieu nhan vien?");
		employeeNumber = scanner.nextInt();
		employee = new Employee[employeeNumber];
		
		for (int i = 0; i < employee.length; i++) {
			System.out.print("Ten nhan vien: ");
			String name = scanner.next();
			System.out.print("Luong: ");
			double salary = scanner.nextDouble();
			System.out.print("Tuoi: ");
			int age = scanner.nextInt();
			System.out.print("Hon nhan (T/F): ");
			boolean married = scanner.nextBoolean();
			System.out.print("Chuc vu: ");
			String jobName = scanner.next();
			Employee employees = new Employee(name, i + 1, salary, age, married, new job(i+1, jobName));
			employee[i] = employees;
		}
	}

	@Override
	public void showEmployee() {
		// TODO Auto-generated method stub
		for (int i = 0; i < employee.length; i++) {
			System.out.println((i+1) + "\t" + employee[i].getName() + "\t" + employee[i].getAge() + "\t" + employee[i].getSalary() + "\t" + employee[i].getMaried() + "\t" + employee[i].getJob());
		}
	}

	public Employee searchEmployee(String tennv) {
		Employee employees = null;
		for(int i = 0; i < employee.length; i++) {
			if (tennv.equals(employee[i].getName())) {
				employees = employee[i];
				break;
			}
			
			
		}
		return employees;
	}

	@Override
	public void updateEmployee(String tennv) {
		System.out.print("Nhap so luong muon thay doi: ");
		double luongnv = scanner.nextDouble();
		for(int i = 0; i < employee.length; i++) {
			if(tennv.equals(employee[i].getName())) {
				employee[i].setSalary(luongnv);
			}
		}
		
	}




}
