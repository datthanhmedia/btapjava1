package btap19jsp03;

public class checkThuanNghich {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkThuanNghich(1221));
		
	}
	static boolean checkThuanNghich(int a) {
		int un = 0;
		int temp = a;
		while(temp>0) {
			un+=temp%10;
			temp/=10;
			un*=10;
		}
		if(un/10==a)
		return true;
		return false;
	}

}
