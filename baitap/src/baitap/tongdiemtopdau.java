package baitap;

import java.util.Scanner;

public class tongdiemtopdau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int t = scanner.nextInt();
		double a[] = new double[1000000];
		for(int i = 0; i<n; i++) {
			a[i] = scanner.nextDouble();
			if(i>0 && a[i]>a[i-1]) {
				a[i] = a[i]+a[i-1];
				a[i-1] = a[i] - a[i-1];
				a[i] = a[i]-a[i-1];
			}
		}
		for(int i = 0; i<n; i++) {
			System.out.println(a[i]);
		}
		double tong=0;
		for(int i = 0; i<t;i++) {
			tong+=a[i];
		}
		System.out.print(tong);
	}

}
