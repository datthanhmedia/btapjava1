package btap19jsp03;

public class timBCNN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10, b = 1;
		System.out.println(timBCNN(a, b));
	}
	static long timBCNN(int a, int b) {
		if(a==0 || b == 0) {
			return 0;
		}
		long BC = a*b;
		int check;
		if(a > b) {
			if(a%b==0) return a;
			check = a;
		}else {
			if(b%a==0) return b;
			check = b;
		}
		for(int i = check; i < BC - check;i+=check) {
			if(i%a==0 && i%b==0) {
				return i;
			}
		}
		
		return BC;
	}

}
