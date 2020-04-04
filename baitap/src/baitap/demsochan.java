package baitap;

import java.util.Scanner;

public class demsochan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int ketqua = 0;
			Scanner scanner = new Scanner(System.in);
			String n1 = scanner.next();
			String n = n1.replace("-", "1");
			if(n.length()%2!=0) {
				n = n + '1';
			}
			char[] mang = n.toCharArray();
			for(int i=0; i<mang.length;i+=2) {
				
				if(i<=n.length()-2) {
					int dem = Integer.parseInt(Character.toString(mang[i])) + Integer.parseInt(Character.toString(mang[i+1]));
					
					if(dem%2==0 &&Integer.parseInt(Character.toString(mang[i]))%2==0) {
						ketqua+=2;
					}else if(Integer.parseInt(Character.toString(mang[i]))%2==0 || Integer.parseInt(Character.toString(mang[i+1]))%2==0) {
						ketqua++;
					}
			}
			}
			System.out.println(ketqua);
		
	}

}
