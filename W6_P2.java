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
			
			int k = 0;
			for(int i = n-1; i > k; i--) {
				int j = i;
				boolean o = false;
				while((j > 0) && 
						(mush[j] == mush[j-1] || mush[j]-1 == mush[j-1])) {
					int t = mush[j];
					mush[j] = mush[j-1];
					mush[j-1] = t;
					j--;
					o = true;
				}
				if(o) {
					i++;
					k++;
				}
				
			}
			
			for(int i = 0; i < mush.length; i++) {
				System.out.print(mush[i] + " ");
			}
			System.out.println();
		}
		
		
	}

}
