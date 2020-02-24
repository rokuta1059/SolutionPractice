import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

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
			
			Stack<Integer> finalMush = new Stack<Integer>();
			LinkedList<Integer> mushroom = new LinkedList<Integer>();
			for (int i : mush) {
				mushroom.add(i);
			}
			
			int k = 0;
			while(finalMush.size() != n) {

				if(finalMush.isEmpty()) {
					finalMush.push(mushroom.removeFirst());
				} else {
					int j = 0;
					while (j < mushroom.size() - k && finalMush.peek() + 1 == mushroom.get(j)) {
						j++;
					} 
					if (mushroom.size() - k == j) {
						k++;
						mushroom.addLast(finalMush.pop());
					} else {
						finalMush.push(mushroom.get(j));
						mushroom.remove(j);
						k = 0;
						Collections.sort(mushroom);
					} 
					
				}
			}
			
			Collections.reverse(finalMush);
			
			while(!finalMush.empty()) {
				System.out.print(finalMush.pop() + " ");
			}
			System.out.println();
		}
		input.close();
		
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
