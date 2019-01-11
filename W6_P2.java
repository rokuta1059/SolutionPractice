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
			
			quicksort(mush, 0, n-1);
			
			int[] ps = new int[n];
			int[] check = new int[n];
			int checkcount = 0;
			int pscount = 0;
			
			for(int i = 0; i < n; i++) {
				ps[0] = mush[i];
				check[i] = 1;
				checkcount++;
				boolean result = findArray(mush, ps, pscount, check, checkcount);
				if(result)
					break;
				else {
					check[i] = 0;
				}
				
			}
			
			for(int i = 0; i < ps.length; i++) {
				System.out.print(ps[i] + " ");
			}
			System.out.println();
		}
		
		input.close();
		
		
	}

	public static boolean findArray(int[] mush, int[] ps, int pscount, int[] check, int checkcount) {
		boolean result = false;
		if(ps.length == checkcount) {
			result = true;
			return result;
		} else {
			for(int i = 0; i < mush.length; i++) {
				if(check[i] != 1 && mush[i] != ps[pscount] + 1) {
					pscount++;
					ps[pscount] = mush[i];
					check[i] = 1;
					checkcount++;
					result = findArray(mush, ps, pscount, check, checkcount);
					if(!result) {
						check[i] = 0;
						checkcount--;
						ps[pscount] = 0;
						pscount--;
					} else {
						return result;
					}
				}
			}
			return result;
			
		}
	}
	
	public static void quicksort(int s[], int l, int h) {
		int p;
		if (l < h) {
			p = partition(s, l, h);
			quicksort(s, l, p-1);
			quicksort(s, p+1, h);
		}
	}
	
	public static int partition(int s[], int l, int h) {
		int i;
		int p;
		int firsthigh;
		
		p = h;
		firsthigh = l;
		for (i = l; i < h; i++) {
			if (s[i] < s[p]) {
				int temp = s[i];
				s[i] = s[firsthigh];
				s[firsthigh] = temp;
				firsthigh++;
			}
			
		}
		int temp = s[p];
		s[p] = s[firsthigh];
		s[firsthigh] = temp;
		return firsthigh;
	}

}
