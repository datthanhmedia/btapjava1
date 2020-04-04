package baitap;

import java.util.Scanner;

public class tinhchanle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a1 = scanner.nextInt();
		int a2 = scanner.nextInt();
		if(a1%2==0 || a2%2==0) {
			System.out.print("Even");
		}else {
			System.out.print("Odd");
		}
	}
}
