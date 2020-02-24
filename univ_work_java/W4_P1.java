import java.util.Arrays;
import java.util.Scanner;

public class W4_P1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()) {
		
			String a = input.nextLine();
			String b = input.nextLine();
			
			String[] aArray = a.split("");
			String[] bArray = b.split("");
			
			Arrays.sort(aArray);
			Arrays.sort(bArray);
			
			for (int i = 0; i < aArray.length; i++) {
				for(int j = 0; j < bArray.length; j++) {
					if(aArray[i].charAt(0) == bArray[j].charAt(0) && bArray[j].charAt(0) != '0') {
						aArray[i] = "0";
						bArray[j] = "0";
					}
				}
			}
			
			int k = 0;
			for(int t = 0; t < aArray.length; t++) {
				if(!aArray[t].equals("0"))
					k++;
			}
			for(int t = 0; t < bArray.length; t++) {
				if(!bArray[t].equals("0"))
					k++;
			}
			
			System.out.println(k);
		}
		input.close();

	}

}