package baitap;

import java.util.Scanner;

public class timMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		String mang = scanner.nextLine();
		String[] A = mang.split("\\s");
		System.out.print(Min(A, n));
	}
	public static String Min(String A[], int n)
	{
		if (n == 0)
			return -1;
		if (n == 1)
			return A[0];
		else
		{
			if (A[n - 1] < Min(A, n - 1))
				return A[n - 1];
			else
				return Min(A, n - 1);
		}
	}
}
