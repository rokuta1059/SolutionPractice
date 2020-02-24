import java.util.Scanner;

public class W5_P2 {
	
	public static char[][] make2DArray(String a) {
		String b[] = a.split(" ");
		char[][] c = new char[b.length][];
		for(int i = 0; i < c.length; i++) {
			c[i] = b[i].toCharArray();
		}
		
		return c;
	}

	public static void main(String[] args) {
		
		char[][] foxkey = make2DArray("the quick brown fox jumps over the lazy dog");
		
		Scanner input = new Scanner(System.in);
		
		char[][] foxvalue = make2DArray(input.nextLine());
		char[][] keyWord = make2DArray(input.nextLine());
		char[][] valueWord = make2DArray(input.nextLine());
		
		char[] map = new char[255];
		char[] inv = new char[255];
		
		
		for (int i = 0; i < foxkey.length; i++) {
			for (int j = 0; j < foxkey[i].length; j++) {
				if(foxvalue[i][j] != '?') {
					map[foxkey[i][j]] = foxvalue[i][j];
					inv[foxvalue[i][j]] = foxkey[i][j];
				}
			}
		}
		
		boolean impossible = false;
		
		for (char[] first : keyWord) {
			for (char[] second : valueWord) {
				if (first.length != second.length)
					continue;
				for(int i = 0; i < first.length; i++) {
					if((map[first[i]] != 0 && map[first[i]] != second[i])
							|| (inv[second[i]] != 0 && inv[second[i]] != first[i])) {
						for(int j = 0; j < i; j++) {
							map[first[j]] = 0;
							inv[second[j]] = 0;
						}
						impossible = true;
						break;
						
					} else if (map[first[i]] == 0) {
						map[first[i]] = second[i];
						inv[second[i]] = first[i];
					}
				}
				if(!impossible) {
					break;
				}
			}
			
		}
		
		for (int i = 0; i < foxvalue.length; i++) {
			for (int j = 0; j < foxkey[i].length; j++) {
				if(map[foxkey[i][j]] != 0)
					System.out.print(map[foxkey[i][j]]);
				else
					System.out.print("?");
			}
			System.out.print(" ");
		}
		
		input.close();

	}

}
