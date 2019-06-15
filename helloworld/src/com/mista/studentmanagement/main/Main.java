package com.mista.studentmanagement.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import com.mista.studentmanagement.bo.Student;
import com.mista.studentmanagement.utils.StudentUtils;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src\\StudentInfo.txt");
		String a = null;
		ArrayList<Student> listOfStudent = new ArrayList<Student>();
		Scanner sc = new Scanner(file);

		while (sc.hasNext()) {
			a = sc.nextLine();
			String[] studentInfo = a.split(";"); // [][]...
			if (Integer.parseInt(studentInfo[6]) > 10 || Integer.parseInt(studentInfo[6]) < 0) {
				System.out.println("Score in file not right");
				System.exit(0);
			}
			Student student = new Student();
			if (studentInfo[0].isEmpty() == true || studentInfo[0] == "") {
				studentInfo[0] = "0";
			} else if (studentInfo[1].isEmpty() || studentInfo[1] == "") {
				studentInfo[1] = "0";
			} else if (studentInfo[2].isEmpty() || studentInfo[2] == "") {
				studentInfo[2] = "0";
			} else if (studentInfo[3].isEmpty() || studentInfo[3] == "") {
				studentInfo[3] = "0";
			} else if (studentInfo[4].isEmpty() || studentInfo[4] == "") {
				studentInfo[4] = "0";
			} else if (studentInfo[5].isEmpty() || studentInfo[5] == "") {
				studentInfo[5] = "0";
			} else if (studentInfo[6].isEmpty() || studentInfo[6] == "") {
				studentInfo[6] = "0";
			}
			// Add list students
			
			try {
			student.setId(Integer.parseInt(studentInfo[0]));
			student.setFirstName(studentInfo[1]);
			student.setLastName(studentInfo[2]);
			student.setGender(studentInfo[3].trim());
			student.setAge(Integer.parseInt(studentInfo[4]));
			student.setTelephone(studentInfo[5]);
			student.setScores(Integer.parseInt(studentInfo[6]));
			listOfStudent.add(student);
			}catch (Exception e) {
				System.out.println("Data in file not correct");
				System.exit(0);
			}

		}

		System.out.println("Number of students: " + listOfStudent.size());
		System.out.println("Percent of gender:" + StudentUtils.percentOfGender(listOfStudent) + "/"
				+ (100 - StudentUtils.percentOfGender(listOfStudent)));
		ArrayList<Student> stdNotAge = StudentUtils.studentNotAge(listOfStudent);

		// Student hasn't Age
		System.out.println("Student Not Age");
		for (Student student: stdNotAge) {
			System.out.println("- " + student.getFirstName() + " " + student.getLastName());
		}
		ArrayList<Student> stdNotTelephone = StudentUtils.studentNotTelephone(listOfStudent);
		// Student hasn't telephone
		System.out.println("Student Not Telephone");
		for (Student student: stdNotTelephone) {
			System.out.println(
					"- " + student.getFirstName() + " " + student.getLastName());
		}
		// List student
		System.out.println("List of students");
		// Print to Excellent student
		System.out.println("* Excellent");
		for (int i = 0; i < listOfStudent.size(); i++) {
			if (StudentUtils.isExcellent(listOfStudent.get(i)))
				System.out.println("- " + (listOfStudent.get(i).getId() + " " + listOfStudent.get(i).getFirstName()
						+ " " + (listOfStudent.get(i)).getLastName()));
		}
		// Print to Good student
		System.out.println("* Good");
		for (int i = 0; i < listOfStudent.size(); i++) {
			if (StudentUtils.isGood(listOfStudent.get(i)))
				System.out.println("- " + (listOfStudent.get(i).getId() + " " + listOfStudent.get(i).getFirstName()
						+ " " + (listOfStudent.get(i)).getLastName()));
		}
		// Print to Bad student
		System.out.println("* Bad");
		for (int i = 0; i < listOfStudent.size(); i++) {
			if (StudentUtils.isBad(listOfStudent.get(i)))
				System.out.println("- " + (listOfStudent.get(i).getId() + " " + listOfStudent.get(i).getFirstName()
						+ " " + (listOfStudent.get(i)).getLastName()));
		}
	}
}
