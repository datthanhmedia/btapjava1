package kieudulieu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Employee[] employees[i] = new Employee[5];
//		Employee[] employee2 = new Employee[5];
//		Employee[] employee3 = new Employee[5];
//		Employee[] employee4 = new Employee[5];
//		Employee[] employee5 = new Employee[5];
//		employees[i] = (1, "nguyenvana", 30,3000,"HR");
		job job1= new job(1, "HR");
		job job2= new job(2, "BA");
		job job3= new job(3, "Tester");
		job job4= new job(4, "Deverloper");
		job job5= new job(5, "CEO");
		Set<Employee> employees = new HashSet<Employee>();
	
		Employee employee1 = new Employee("Nguyen Van A", 1, 3000, 30, false, job1);
		Employee employee2 = new Employee("Nguyen Van B", 2, 4000, 40, true, job2);
		Employee employee3 = new Employee("Nguyen Van C", 3, 5000, 50, false, job3);
		Employee employee4 = new Employee("Nguyen Van D", 4, 6000, 60, true, job4);
		Employee employee5 = new Employee("Nguyen Van E", 5, 7000, 70, false, job5);
//		Employee[] employees = new Employee[5];
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee5);
		
//		employees[0] = employee1;
//		employees[1] = employee2;
//		employees[2] = employee3;
//		employees[3] = employee4;
//		employees[4] = employee5;
		
	//System.out.println(employees);
//	for (Employee employee : employees) {
//	
//		System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getAge() + "\t" + employee.getSalary() + "\t" + "\t" + employee.getJob().getName());
//	}
	
	
		Iterator<Employee> itr = employees.iterator();
	while (itr.hasNext()) {
	Employee item = itr.next();
		System.out.println(item.getId() + "\t" + item.getName() + "\t" + item.getAge() + "\t" + item.getSalary() + "\t" + item.getJob().getName());
		
	}
//	System.out.println(employees[i].id + "\t" + employees[i].name + "\t" + employees[i].age + "\t" + employees[i].Salary + "\t" + employees[i].Maried + "\t" + employees[i].job.name);
	}

}

