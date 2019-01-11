import java.util.Scanner;
 
public class W5_P1 {
 
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        while(input.hasNext()) {
            
            String a = input.nextLine();
            String[] arr = a.split("");
            
            StringBuilder kor = new StringBuilder();
            int korleng = 0;
            StringBuilder eng = new StringBuilder();
            int engleng = 0;
            
            for(int i = 0; i < arr.length; i++) {
                
                int t = arr[i].charAt(0);
                
                if(t >= 0xAC00 && t <= 0xD7AF) {
                    kor.append(arr[i]);
                    korleng++;
                } else {
                    eng.append(arr[i]);
                    engleng++;
                }
            }
            
            System.out.print(eng.toString());
            System.out.println(kor.toString());
            
            System.out.println(engleng + " " + korleng + " " + arr.length);
        }
        
        input.close();
 
    }
 
}