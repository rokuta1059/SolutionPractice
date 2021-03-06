import java.util.Scanner;

public class W2_P1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String s = input.nextLine();
			int ans = 0;
			String adder = "";
			char beforechar = 0;
			int isbeforechar = 0; // char = 0, int = 1
			
			if(s.charAt(0) < 65 || s.charAt(0) > 74) {
				System.out.println("Error");
				continue;
			}
			
			for (int i = 0; i < s.length(); i++) {
				char k = s.charAt(i);
				if(k >= 65 && k <= 74) {
					k = (char) (k - 17);
					adder += k;
					isbeforechar = 1;
					continue;
				}
				else if(k == 'P' || k == 'S' || k == 'T' || k == 'V') {
					if(isbeforechar == 0) {
						break;
					}
					
					if(beforechar == 0) {
						beforechar = k;
						ans = Integer.parseInt(adder);
						adder = "";
						isbeforechar = 0;
					}
					else {
						if (beforechar == 'P') 
							ans += Integer.parseInt(adder);
						else if (beforechar == 'S')
							ans -= Integer.parseInt(adder);
						else if (beforechar == 'T')
							ans *= Integer.parseInt(adder);
						else if (beforechar == 'V')
							ans /= Integer.parseInt(adder);
						
						beforechar = k;
						adder = "";
						isbeforechar = 0;
					}
				}
				else {
					break;
				}
				
			}
			if(beforechar != 0 && adder != "") {
				if (beforechar == 'P') 
					ans += Integer.parseInt(adder);
				else if (beforechar == 'S')
					ans -= Integer.parseInt(adder);
				else if (beforechar == 'T')
					ans *= Integer.parseInt(adder);
				else if (beforechar == 'V')
					ans /= Integer.parseInt(adder);
				else
					ans = Integer.parseInt(adder);
				
				beforechar = 0;
				adder = "";
				System.out.println(ans);
				ans = 0;
			}
			else if (adder != ""){
				ans = Integer.parseInt(adder);
				beforechar = 0;
				adder = "";
				System.out.println(ans);
				ans = 0;
			}
			else {
				System.out.println("Error");
				beforechar = 0;
				adder = "";
				ans = 0;
				isbeforechar = 0;
			}
		}
		
		input.close();
	}
}