import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class W3_P1 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String card;
		
		while(a.hasNextLine()) {
			Stack<String> hands = new Stack<String>();
			card = a.nextLine();
			String[] cardCommend = card.split("");
			
			for(int i = 0; i < cardCommend.length; i++){
				if(!cardCommend[i].equals("*") && hands.size() < 10) {
					hands.push(cardCommend[i]);
				}
				else if(cardCommend[i].equals("*") && !hands.isEmpty()) {
					hands.pop();
				}
			}
			
			Collections.reverse(hands);
			
			while(!hands.isEmpty()) {
				System.out.print(hands.pop()+ "");
			}
			System.out.println();
		}
		
		a.close();

	}

}