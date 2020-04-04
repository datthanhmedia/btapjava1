package baitap;

import java.util.Scanner;

public class xaukhacnhau {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		char[] mang = str.toCharArray();
		for(int i = 0; i < mang.length-1; i++) {
			for(int j = i+1; j<mang.length; j++) {
				if(Character.toString(mang[i]).equals(Character.toString(mang[j]))) {
					System.out.println("No");
					System.exit(0);
				}
			}
		}
        System.out.println("Yes");
	}
}
