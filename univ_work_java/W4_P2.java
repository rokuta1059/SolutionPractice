import java.util.Scanner;

public class W4_P2 {
	
	public static int[] di = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int[] dj = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static char[] teemo = {'t', 'e', 'e', 'm', 'o'};
	
	static int m;
	static int n;
	
	static char[][] field;
	
	public static int findChar(int si, int sj) {
		int direction = 0;
		for(;direction < 8; direction++) {
			int i = si;
			int j = sj;
			int k = 0; // teemo counter
			int nonT = 0; // Wrong Char counter
			int chainT = 0; // is That Wrong Char is Chain?
			while (i >= 0 && i < m && j >= 0 && j < n) {
				char a = field[i][j];
				if(a >= 'A' && a <= 'Z') {
					a += ('a' - 'A');
				}
				if(a == teemo[k]) {
					i += di[direction];
					j += dj[direction];
					k++;
					chainT = 0;
				} else {
					nonT++;
					i += di[direction];
					j += dj[direction];
					k++;
					chainT++;
					if(chainT > 1 || nonT > 2)
						break;
				}
				if (k == 5 && chainT < 2 && nonT < 3)
					return direction;
			}
			
		}
		return 8;
	}
	
	public static int findunChar(int si, int sj) {
		int direction = 0;
		for(;direction < 8; direction++) {
			int i = si;
			int j = sj;
			int k = 4; // teemo counter
			int nonT = 0; // Wrong Char counter
			int chainT = 0; // is That Wrong Char is Chain?
			while (i >= 0 && i < m && j >= 0 && j < n) {
				char a = field[i][j];
				if(a >= 'A' && a <= 'Z') {
					a += ('a' - 'A');
				}
				if(a == teemo[k]) {
					i += di[direction];
					j += dj[direction];
					k--;
					chainT = 0;
				} else {
					nonT++;
					i += di[direction];
					j += dj[direction];
					k--;
					chainT++;
					if(chainT > 1 || nonT > 2)
						break;
					
				}
				if (k == -1 && chainT < 2 && nonT < 3)
					return direction;
			}
			
		}
		return 8;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()) {
			
			String size = input.nextLine();
			String[] sizeint = size.split(" ");
			
			m = Integer.parseInt(sizeint[0]);
			n = Integer.parseInt(sizeint[1]);
			
			field = new char[m][n];
			char[][] printfield = new char[m][n];
			
			for(int i = 0; i < m; i++) {
				String arr = input.nextLine();
				String[] a = arr.split("");
				for(int j = 0; j < n; j++) {
					field[i][j] = a[j].charAt(0);
				}
			}
			
			for(int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					printfield[i][j] = field[i][j];
				}
			}
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					
					int k = findChar(i, j);
					
					if(k < 8) {
						int ci = i;
						int cj = j;
						for (int c = 0; c < 5; c++) {
							printfield[ci][cj] = '#';
							ci += di[k];
							cj += dj[k];
						}
					}
					
					k = findunChar(i, j);
					
					if(k < 8) {
						int ci = i;
						int cj = j;
						for (int c = 0; c < 5; c++) {
							printfield[ci][cj] = '#';
							ci += di[k];
							cj += dj[k];
						}
					}
				}
			}
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(printfield[i][j] != '#')
						printfield[i][j] = field[i][j];
				}
			}
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(printfield[i][j]);
				}
				System.out.println();
			}
		}
		
		input.close();

	}

}
