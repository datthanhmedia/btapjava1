package btap19jsp03;

public class tongChuSo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 115613;
		//x=x/10;
		System.out.println(tongNum(x));
		//System.out.println(x);
	}
	static long tongNum(int n) {
		long x = 0;
		int temp = n;
		do {
			x+=temp%10;
			temp=temp/10;
		}while(temp!=0);
		return x;
	}

}
