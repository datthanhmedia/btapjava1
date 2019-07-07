package btap19jsp03;

public class checkNguyenTo {
public static void main(String[] args) {
		
		System.out.println(kiemTraNguyenTo(13));
	}
	static boolean kiemTraNguyenTo(int n) {
		for(int i = 2; i<n; i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
}
