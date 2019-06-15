package com.mista.studentmanagement.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mista.studentmanagement.bo.Student;

public class StudentUtils {

	// Print Percent of gender
	public static float percentOfGender(ArrayList<Student> listOfStudent) {
		int male = 0, female = 0;
		for (int i = 0; i < listOfStudent.size(); i++) {

			if ("Male".equals(listOfStudent.get(i).getGender())) {
				male++;
			}
		}
		float percentMale = (100 / listOfStudent.size()) * male;
		return percentMale;
	}

	// Students not have age
	public static ArrayList<Student> studentNotAge(ArrayList<Student> listOfStudent) {
		// System.out.println("Students not have age: ");
		ArrayList<Student> studentNotAge = new ArrayList<Student>();

		for (int i = 0; i < listOfStudent.size(); i++) {

			if (!hasAge(listOfStudent.get(i))) {
				studentNotAge.add(listOfStudent.get(i));
				//
			}
		}
		return studentNotAge;
	}

	public static boolean hasAge(Student student) {

		if ((student.getAge() == 0)) {
			return false;
		}
		return true;
	}

	// Students not have age
	public static boolean hasTelephone(Student student) {

		if (student.getTelephone() == "0") {
			return false;
		}
		return true;
	}

	public static ArrayList<Student> studentNotTelephone(ArrayList<Student> listOfStudent) {
		// System.out.println("Students not have age: ");
		ArrayList<Student> studentNotTelephone = new ArrayList<Student>();

		for (int i = 0; i < listOfStudent.size(); i++) {

			if (!hasTelephone(listOfStudent.get(i))) {
				studentNotTelephone.add(listOfStudent.get(i));
			}
		}
		return studentNotTelephone;
	}

	// List of students
	// public static void listOfStudent(ArrayList listOfStudent) {
	// int highScore;
	// System.out.println("* Excellent");
	// for(int i = 0; i < listOfStudent.size(); i++) {
	// if(((Student) listOfStudent.get(i)).getscores() >= 8) {
	//
	// System.out.println("- " + ((Student) listOfStudent.get(i)).getid() + " " +
	// ((Student) listOfStudent.get(i)).getfirstName() + " " + ((Student)
	// listOfStudent.get(i)).getlastName());
	// }
	// }
	// System.out.println("* Good");
	// for(int i = 0; i < listOfStudent.size(); i++) {
	// if(((Student) listOfStudent.get(i)).getscores() < 8 && ((Student)
	// listOfStudent.get(i)).getscores() >= 5) {
	//
	// System.out.println("- " + ((Student) listOfStudent.get(i)).getid() + " " +
	// ((Student) listOfStudent.get(i)).getfirstName() + " " + ((Student)
	// listOfStudent.get(i)).getlastName());
	//
	// }
	// }
	// System.out.println("* Bad");
	// for(int i = 0; i < listOfStudent.size(); i++) {
	// if(((Student) listOfStudent.get(i)).getscores() < 5) {
	//
	// System.out.println("- " + ((Student) listOfStudent.get(i)).getid() + " " +
	// ((Student) listOfStudent.get(i)).getfirstName() + " " + ((Student)
	// listOfStudent.get(i)).getlastName());
	//
	// }
	// }
	// }
	public static boolean isExcellent(Student student) {
		if (student.getScores() >= 8) {
			return true;
		}
		return false;
	}

	public static boolean isGood(Student student) {
		if (student.getScores() < 8 && student.getScores() >= 5) {
			return true;
		}
		return false;
	}

	public static boolean isBad(Student student) {
		if (student.getScores() < 5) {
			return true;
		}
		return false;
	}
}
