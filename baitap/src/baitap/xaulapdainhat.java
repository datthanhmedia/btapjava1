package baitap;

import java.util.Scanner;

public class xaulapdainhat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String xaucha = scanner.next();
		char[]mangChuoi = xaucha.toCharArray();
		int max1 = 1;
		int max=1;
		char a = 'P';
		for(int i = 0; i < mangChuoi.length; i++) {
			if(a!=mangChuoi[i]) {
				a = mangChuoi[i];
				if(max1>max) {
					max = max1;
					
				}max1=1;
			}else {
				max1++;
				
			}
			
		}if(max1>max) max = max1;
		
		System.out.print(max);
	}

}
