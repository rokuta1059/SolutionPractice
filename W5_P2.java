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
		char[][] foxarr = make2DArray("the quick brown fox jumps over the lazy dog");
		
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()) {
			
			char[][] unfoxarr = make2DArray(input.nextLine());
			char[][] aarr = make2DArray(input.nextLine());
			char[][] barr = make2DArray(input.nextLine());
			
			// set map
			
			char[] map = new char[255];
			char[] unmap = new char[255];
			for (int i = 'a'; i <= 'z'; i++) {
				map[i] = '?';
				unmap[i] = '?';
			}
			
			for(int i = 0; i < unfoxarr.length; i++){
				for(int j = 0; j < unfoxarr[i].length; j++) {
					if(unfoxarr[i][j] != '?') {
						unmap[foxarr[i][j]] = unfoxarr[i][j];
					}
				}
			}
			
			for(int i = 0; i < barr.length; i++) {
				
				for(int k = 0; k < aarr.length; k++) {
					boolean possible = false;
					if(barr[i].length == aarr[k].length) {
						for(int j = 0; j < barr[i].length; j++) {
							if(unmap[aarr[k][j]] != '?' && barr[i][j] == unmap[aarr[k][j]]) {
								possible = true;
								map[aarr[k][j]] = barr[i][j];
								continue;
							} else if (unmap[aarr[k][j]] == '?') {
								map[aarr[k][j]] = barr[i][j];
								possible = true;
								continue;
							}
							possible = false;
							break;
						}
					}
					for(int t = 'a'; t<='z'; t++) {
						for(int u = t+1; u < 'z'; u++) {
							if(map[t] != 0 && map[u] != 0 && map[t] != '?' && map[t] != '?' && map[t] == map[u]) {
								possible = false;
								break;
							}
						}
					}
					
					map = new char[255];
					
					if (possible) {
						
						if(aarr[k].length <= barr[i].length) {
							for(int a1 = 0; a1 < aarr[k].length; a1++) {
								unmap[aarr[k][a1]] = barr[i][a1];
							}
						} else {
							for(int a1 = 0; a1 < barr[i].length; a1++) {
								unmap[aarr[k][a1]] = barr[i][a1];
							}
						}
						
					}
				}
			} 
			

			for(int i = 'a'; i <= 'z'; i++) {
				System.out.print((char)i);
			}
			System.out.println();
			for(int i = 'a'; i <= 'z'; i++) {
				System.out.print(unmap[i]);
			}
			System.out.println();
			
			for (int i = 0; i < foxarr.length; i++) {
				for (int j = 0; j < foxarr[i].length; j++) {
					System.out.print(unmap[foxarr[i][j]]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}

	}
	

}