import java.util.Scanner;

public class W6_P2 {

public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()) {
			
			int n = Integer.parseInt(input.nextLine());
			
			String line = input.nextLine();
			
			int[] mush = new int[n];
			String[] mushS = line.split(" ");
			
			for(int i = 0; i < n; i++) {
				mush[i] = Integer.parseInt(mushS[i]);
			}
			
			for (int i = 0; i < mush.length; i++) {
				for (int j = i + 1; j < mush.length; j++) {
					if(mush[i] == mush[j] || mush[i]+1 == mush[j]) {
						int temp = mush[i];
						mush[i] = mush[j];
						mush[j] = temp;
					} 
				}
			}
			
			for(int i = 0; i < mush.length; i++) {
				System.out.print(mush[i] + " ");
			}
			System.out.println();
		}
		
		
	}
}
