package baitap;

import java.text.SimpleDateFormat;
import java.util.Date;

public class camelCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Date date= new Date();
		String formats = "YYYY-MM-dd";
	
		SimpleDateFormat df = new SimpleDateFormat(formats);
		System.out.println(date);
		String ngay = df.format(date);
		System.out.println(ngay);
		}
	}
