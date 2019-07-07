package vn.datthanhmedia.main;

import java.util.ArrayList;

import vn.datthanhmedia.bo.Students;
import vn.datthanhmedia.dao.StudentDAO;

public class Main {

	public static void main(String[] args) {
		StudentDAO studentDao = new StudentDAO();
		// Add student to database
		 Students newStudent = new Students();
		 newStudent.setFirst_name("tot");
		 newStudent.setLast_name("nguyen dung tri");
		 newStudent.setGender("Male");
		 newStudent.setAge(12);
		 newStudent.setTelephone("0987567891");
		 newStudent.setScores(456);
		 studentDao.addStudentsPrepareStatement(newStudent);

		ArrayList<Students> list = studentDao.getAllStudent();
		// Print list students in database
		 for(Students student: list) {
		 System.out.println(student.getId() + " - "
		 + student.getFirst_name() + " - "
		 + student.getLast_name() + " - "
		 + student.getGender() + " - "
		 + student.getAge() + " - "
		 + student.getTelephone() + " - "
		 + student.getScores());
		 }
		// Print number of student
		System.out.println("Number of student: " + list.size());
		int numOfMaleStudent = 0;
		for(Students students: list) {
			if(students.getGender().equals("Male")) {
				numOfMaleStudent++;
			}
		}
		//Print Number of Male student
		System.out.println("Number of Male student: " + numOfMaleStudent);
		//Print list female student
		System.out.println("List female student: ");
		int numOfFemaleStudent = 0;
		for(Students student: list) {
			if(student.getGender().equals("Female")) {
				System.out.println(student.getId() + " - "
						 + student.getFirst_name() + " - "
						 + student.getLast_name() + " - "
						 + student.getGender() + " - "
						 + student.getAge() + " - "
						 + student.getTelephone() + " - "
						 + student.getScores());
				numOfFemaleStudent++;
			}
		}
		System.out.println("Number of Female student: " + numOfFemaleStudent);
		//Print list student hasn't telephone
		System.out.println("List student hasn't telephone: ");
		for(Students student: list) {
			if(student.getTelephone() == null) {
				System.out.println(student.getId() + " - "
						 + student.getFirst_name() + " - "
						 + student.getLast_name() + " - "
						 + student.getGender() + " - "
						 + student.getAge() + " - "
						 + student.getTelephone() + " - "
						 + student.getScores());
			}
		}
		//Print list student has age > 18
		System.out.println("List student > 18 year old: ");
		for(Students student: list) {
			if(student.getAge() > 18) {
				System.out.println(student.getId() + " - "
						 + student.getFirst_name() + " - "
						 + student.getLast_name() + " - "
						 + student.getGender() + " - "
						 + student.getAge() + " - "
						 + student.getTelephone() + " - "
						 + student.getScores());
			}
		}
		//Print list Excellent student
		System.out.println("List Excellent student");
		for(Students student: list) {
			if(student.getScores() > 800) {
				System.out.println(student.getId() + " - "
						 + student.getFirst_name() + " - "
						 + student.getLast_name() + " - "
						 + student.getGender() + " - "
						 + student.getAge() + " - "
						 + student.getTelephone() + " - "
						 + student.getScores());
			}
		}
		//Print list Bad student
				System.out.println("List Bad student");
				for(Students student: list) {
					if(student.getScores() < 450) {
						System.out.println(student.getId() + " - "
								 + student.getFirst_name() + " - "
								 + student.getLast_name() + " - "
								 + student.getGender() + " - "
								 + student.getAge() + " - "
								 + student.getTelephone() + " - "
								 + student.getScores());
					}
				}
				//Print student has first name or last name = nike
				System.out.println("List student's first name or last name is nike");
				for(Students student: list) {
					if(student.getFirst_name().equals("nike") || student.getLast_name().equals("nike")) {
						System.out.println(student.getId() + " - "
								 + student.getFirst_name() + " - "
								 + student.getLast_name() + " - "
								 + student.getGender() + " - "
								 + student.getAge() + " - "
								 + student.getTelephone() + " - "
								 + student.getScores());
					}
				}
				
				
	}
	

}
