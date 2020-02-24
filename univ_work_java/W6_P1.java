import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
 
class KD {
    
    String name;
    int K;
    int D;
    int A;
    int index;
    
    public KD(String a, int t) {
        String[] list = a.split(" |/");
        name = list[0];
        K = Integer.parseInt(list[1]);
        D = Integer.parseInt(list[2]);
        A = Integer.parseInt(list[3]);
        index = t;
    }
    
    public String getName() {
        return name;
    }
    
    public int getK() {
        return K;
    }
    
    public int getD() {
        return D;
    }
    
    public int getA() {
        return A;
    }
    
    public int getIndex() {
        return index;
    }
    
    public String toString() {
        return name + " " + K + "/" + D + "/" + A;
    }
}
 
public class W6_P1 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int a = Integer.parseInt(input.nextLine());
        KD[] list = new KD[a];
        
        for (int i = 0; i < a; i++) {
            list[i] = new KD(input.nextLine(), i);
        }
        
        int length = a;
        
        for (int i = 0; i < length; i++) {
            if (list[i].getK() + list[i].getA() < list[i].getD()) {
                Collections.swap(Arrays.asList(list), i, length-1);
                length--;
            }
        }
        
        int f,g;
        
        for(f = 1; f < length; f++) {
            g = f;
            while ((g > 0) && list[g].getName().compareTo(list[g-1].getName()) < 0) {
                Collections.swap(Arrays.asList(list), g, g-1);
                g = g-1;
            }
        }
        
        for(f = 1; f < length; f++) {
            g = f;
            while ((g > 0) && (list[g].getD() < list[g-1].getD())) {
                Collections.swap(Arrays.asList(list), g, g-1);
                g = g-1;
            }
        }
        
        for(f = 1; f < length; f++) {
            g = f;
            boolean o = true;
            while (g > 0 && o) {
                if(list[g].getD() == 0 && list[g-1].getD() == 0) {
                    if(list[g].getA() + list[g].getK() > list[g-1].getA() + list[g-1].getK()) {
                        Collections.swap(Arrays.asList(list), g, g-1);
                        g = g-1;
                    } else {
                        o = false;
                    }
                } else if(list[g].getD() == 0 && list[g-1].getD() != 0) {
                    Collections.swap(Arrays.asList(list), g, g-1);
                    g = g-1;
                } else if(list[g].getD() != 0 && list[g-1].getD() != 0) {
                    if((list[g].getA() + list[g].getK()) / list[g].getD() > (list[g-1].getA() + list[g-1].getK()) / list[g-1].getD()) {
                        Collections.swap(Arrays.asList(list), g, g-1);
                        g = g-1;
                    } else {
                        o = false;
                    }
                } else {
                    o = false;
                }
                
            }
        }
        
        for (int i = 0; i < length; i++) {
            System.out.println(list[i]);
        }
        
        input.close();
 
    }
 
}