package kieudulieu;

import java.util.Scanner;


public class ManageEmployee {
	public static Scanner scanner = new Scanner(System.in);
	public static int inputNumber = 0;
	public static int employeeNumber = 0;
	public static Employee[] employee;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
showMenu();
System.out.println("End Program");
	}
	public static void showMenu() {
		do {
			System.out.println("1. Creat Employee");
			System.out.println("2. Show all employee");
			System.out.println("3. Exit");
			System.out.println("4. Search employee by name");
			System.out.println("0. Return main menu");
			System.out.print("Nhap 1 so: ");
			inputNumber = scanner.nextInt();
			switch (inputNumber) {
			case 1:
				addEmployee();
				break;
			case 2:
				showEmployee();
				break;
			case 3:
				break;
			case 4:
				searchEmployee();
				break;
			case 0:
				showMenu();
				default:
					System.out.println("Your input was wrong, Please input again!");
			}
		}while(inputNumber !=3);
		
	}
	public static void addEmployee() {
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
	public static void showEmployee() {
		for (int i = 0; i < employee.length; i++) {
			System.out.println((i+1) + "\t" + employee[i].name + "\t" + employee[i].age + "\t" + employee[i].Salary + "\t" + employee[i].Maried + "\t" + employee[i].job.name);
		}
	}
	public static void searchEmployee() {
		System.out.print("Nhap vao ten nhan vien: ");
		String tennv = scanner.next();
		for(int i = 0; i < employee.length; i++) {
			System.out.println("Tat ca nhan vien co ten: " + tennv + "la: ");
			if (tennv.equals(employee[i].name)) {
				System.out.println((i+1) + "\t" + employee[i].name + "\t" + employee[i].age + "\t" + employee[i].Salary + "\t" + employee[i].Maried + "\t" + employee[i].job.name);
			}
		}
		System.out.print("Ban co muon thay doi luong nhan vien? 1 = Yes / 2 = No / Khac = exit");
		int temp = scanner.nextInt();
		switch(temp){
			case 1:
				updateEmployee(tennv);
			case 2:
				showMenu();
			default:
				break;
		}
	}
	public static void updateEmployee(String tennv) {
		System.out.print("Nhap so luong muon thay doi: ");
		double luongnv = scanner.nextDouble();
		for(int i = 0; i < employee.length; i++) {
			if(tennv.equals(employee[i].name)) {
				employee[i].Salary = luongnv;
				break;
			}
		}
	}

}
