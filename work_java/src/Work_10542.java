import java.util.Scanner;

public class Work_10542 {

    static int n;
    static int[] peopleSelect;
    static int[] selectedCount;
    static boolean[] mafia;
    static boolean[] isChecked;

    public static void findMafia(int person, boolean isMafia) {
        if(!isChecked[person]) {
            isChecked[person] = true;
            if(isMafia) {
                mafia[person] = true;
            }
            selectedCount[peopleSelect[person]]--;
            if(selectedCount[peopleSelect[person]] == 0 || isMafia) {
                findMafia(peopleSelect[person], !isMafia);
            }

        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNext()) {
            int n = input.nextInt();
            peopleSelect = new int[n];
            selectedCount = new int[n];
            mafia = new boolean[n];
            isChecked = new boolean[n];

            for (int t = 0; t < n; t++) {
                int temp = input.nextInt() - 1;
                peopleSelect[t] = temp;
                selectedCount[temp]++;
            }

            for(int i = 0; i < n; i++) {
                if(selectedCount[i] == 0) {
                    findMafia(i, true);
                }
            }

            for(int i = 0; i < n; i++) {
                findMafia(i, false);
            }

            int count = 0;
            for(int i = 0; i < n; i++) {
                if(mafia[i] == true)
                    count++;
            }

            System.out.println(count);

        }
        input.close();

    }

}
