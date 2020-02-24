import java.util.Scanner;

public class W3_P2 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		
		while(a.hasNext()) {
			
			int n = Integer.parseInt(a.nextLine());
			
			int[] line = new int[n];
			
			for(int i = 0; i < n; i++) {
				line[i] = i+1;
			}

			String xi = a.nextLine();
			int timenow = 0;
			int i = 0;
			for(String timetable : xi.split(" ")) {
				int time = Integer.parseInt(timetable);
				while(time != timenow) {
					while(line[i] == 0) {
						i++;
						if(i >= line.length) i=0;
					}
					timenow++;
					i++;
					if(i >= line.length) i=0;
					while(line[i] == 0) {
						i++;
						if(i >= line.length) i=0;
					}
				}
				if(time % 2 != 0) {
					int k = i-1;
					if(k <0) k = (line.length - 1);
					while (line[k] == 0) {
						if(k >0) k--;
						else k=(line.length - 1);
					}
					line[k] = 0;
				}
				else {
					int k = i+1;
					if(k >= line.length) k=0;
					while (line[k] == 0) {
						if(k < line.length) k++;
						else k=0;
					}
					line[k] = 0;
				}
				
			}
			
			for(int k = 0; k < line.length; k++) {
				if(line[k] != 0) {
					System.out.print(line[k] + " ");
				}
			}
			System.out.println();
		}
		a.close();

	}

}
