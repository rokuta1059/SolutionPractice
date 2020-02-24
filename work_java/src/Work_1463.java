import java.util.Scanner;

public class Work_1463 {

    static int minCount = 65535;
    static int count = 0;

    public static void calcValue(int value) {

        if (count >= minCount) {
            count--;
            return;
        } else {
            if(value == 1) {
                minCount = count;
            }

            if(value % 3 == 0) {
                count++;
                calcValue(value / 3);
            }

            if(value % 2 == 0) {
                count++;
                calcValue(value / 2);
            }
            if(value != 1) {
                count++;
                calcValue(value - 1);
            }

        }

        count--;
        return;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tmp = input.nextInt();
        calcValue(tmp);
        System.out.println(minCount);

    }
}
