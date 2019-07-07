package btap19jsp03;

public class checkChuoiDoiXung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String a = "abca acba dfdfsdf";

System.out.println(check(a));
	}
	static boolean check(String a) {
		
		for(int i = 0; i < a.length()/2; i++) {
			
				if (a.charAt(i) != a.charAt(a.length()-1-i))
					return false;
			
		}
		return true;
	}

}
