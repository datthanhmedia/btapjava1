package com.mista.studentmanagement.main;



import java.io.*;
import java.util.ArrayList;

import com.mista.studentmanagement.bo.Student;

import helloworld.student;

	public class test {
	   public static void main(String[] args)  {
			ArrayList<Student> list = new ArrayList<Student>();
				try {
					FileReader rd = new FileReader("StudentInfo.txt");
					BufferedReader bd= new BufferedReader(rd);// bo dem
					while (true) {
						String s= bd.readLine();
						if (s.isEmpty() || s==null) break;
						String [] ds= s.split("[;]");
						Student st = new Student(Integer.valueOf(ds[0]), ds[1], ds[2], ds[3], Integer.valueOf(ds[4]), ds[5],Integer.valueOf(ds[6]));
						list.add(st);
					}
					bd.close();	
				}catch(Exception e) {		
				}
	      
	   
	   	for(int i= 0;i<list.size();i++) {
	   		hieu chu
	   		
	   	}
	   }
	   }
	
