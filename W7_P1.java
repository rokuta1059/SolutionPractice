import java.util.Scanner;
 
public class W7_P1 {
    
    static String line;
    static int when;
    
    public static String ant() {
        StringBuilder sb = new StringBuilder();
        int length = line.length();
        
        for(int i = 0; i < length; i++) {
            String a = line.substring(i, i+1);
            int count = 0;
            for(int j = i; j < length; j++) {
                String b = line.substring(j, j+1);
                if(a.compareTo(b) == 0) {
                    count++;
                } else {
                    break;
                }
            }
            sb.append(a);
            if(count != 0) {
                sb.append(count);
            }
            i = i + count - 1;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        line = "1";
        when = Integer.parseInt(input.nextLine()) - 1;
 
        for(int i = 0; i < when; i++) {
            line = ant();
 
        }
        System.out.println(line);
        
        input.close();
    }
 
}