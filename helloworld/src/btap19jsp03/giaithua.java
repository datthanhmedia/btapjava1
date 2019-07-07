package btap19jsp03;

public class giaithua {
//	public static void main(String[] args) {
//		
//		System.out.println(giaithua(10));
//	}
	static double giaithua(double a) {
		double n = a;
		if(n == 1)return n;
		return n*giaithua(n-1);
	}
}
