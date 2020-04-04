package baitap;

import java.util.Scanner;

public class daucuatich {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		if(a==0 || b==0) {
			System.out.print("Zero");
		}else if(a>0) {
			System.out.print("Positive");
		}else if(b<0) {
			int dem = (-1)*a + b + 1;
			if(dem%2==0) {
				System.out.print("Positive");
			}else System.out.print("Negative");
		}else{
			System.out.print("Zero");
		}
	}

}
