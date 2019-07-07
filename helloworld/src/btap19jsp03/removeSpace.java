package btap19jsp03;

public class removeSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeSpace("fdfdf  dfd f d"));
	}
	static String removeSpace(String s) {
		String text = "";
		int n = s.length();
		for(int i = 0; i < n; i++) {
			if(" ".equals(s.charAt(i)) && " ".equals(s.charAt(i-1)))
			{
				for(int j = i; j<n;j++)
				text.replace(s.charAt(j), s.charAt(j+1));
			//	n--;
			}
		}
		return text;
	}
	
}
