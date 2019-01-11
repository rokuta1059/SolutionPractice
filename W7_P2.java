import java.util.ArrayList;
import java.util.Scanner;

public class W7_P2 {
	
	static String[] a;
	static int count = 0;
	
	public static void anagram(String[] b, int index, ArrayList<String> FL) {
		b[index] = "";
		ArrayList<String> finalList = new ArrayList<String>(FL);
		finalList.add(a[index]);
		if(finalList.size() == a.length) {
			print(finalList);
		} else {
			ArrayList<String> nowList = new ArrayList<String>();
			for(int i = 0; i < b.length; i++) {
				if(b[i] != "") {
					if(!nowList.contains(b[i])) {
						nowList.add(b[i]);
						anagram(b, i, finalList);
					}
				}
				if(count >= 100) {
					break;
				}
			}
		}
		b[index] = a[index];
		
	}
	
	public static void print(ArrayList<String> a) {
		StringBuilder sb = new StringBuilder();
		for(String t : a) {
			sb.append(t);
		}
		System.out.print(sb.toString() + " ");
		count++;
		
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String word = input.nextLine();
		
		a = word.split("");
		String[] b = new String[a.length];
		for(int i = 0; i < b.length; i++) {
			b[i] = a[i];
		}
		
		ArrayList<String> finalList = new ArrayList<String>();
		
		ArrayList<String> nowList = new ArrayList<String>();
		for(int i = 0; i < a.length; i++) {
			if(!nowList.contains(a[i])) {
				nowList.add(a[i]);
				anagram(b, i, finalList);
			}
			if(count >= 100) {
				break;
			}
		}
		
	}

}
