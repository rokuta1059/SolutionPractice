import java.util.Scanner;

public class Work_9095 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int arr[] = new int[11];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4; i < arr.length; i++) {
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
        }

        int count = input.nextInt();
        for(int i = 0; i < count; i++) {
            System.out.println(arr[input.nextInt()]);
        }

    }

}
