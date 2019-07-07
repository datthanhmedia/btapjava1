package btap19jsp03;

public class timUCLN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1, b = 219;
		System.out.println(timUCLN(a, b));
	}
	static int timUCLN(int a, int b) {
		int UC = 1;
		int check;
		if (a==0 || b == 0) {
			return 0;
		}
		if(a > b) {
			if(a%b==0) return b;
			else check = b;
		}
			
		else {
			if(b%a==0) return a;
			check = a;
		}
		for(int i=1; i<=check/2; i++) {
			if(a%i==0 && b%i==0) {
				UC = i;
			}
		}
		
		return UC;
	}

}
