package nhapdulieu;

import java.util.Scanner;

public class tinhtoan {

	public static String check(int a, int b) {
//		return (a > b)? "A > b" : "A <= b"; 
		if (a>b) {
			return "A>b";
		}else if (a<b) {
			return "A<b";
		}else return "A=b";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner A1 = new Scanner(System.in);
		Scanner b1 = new Scanner(System.in);
		System.out.print("Nhap so A: ");
		int A = A1.nextInt();
		System.out.print("Nhap so b: ");
		int b = b1.nextInt();
//		String dieukien;
//		if (A == b) {
//			System.out.println("A = b");
//		}
//		else {
//		dieukien = (A > b) ? "A > b" : "A <= b";
//		System.out.println(dieukien);
//		}
		System.out.println(check(A , b));
		System.out.println("A + b = "+ (A + b));
		System.out.println("A - b = "+ (A - b));
		System.out.println("A chia b duoc: "+ (A / b) + " du " + (A % b));
		A++;
		b--;
		System.out.println("A++ = "+ (A));
		System.out.println("b-- = "+ (b));
		
		

		
	}

}
