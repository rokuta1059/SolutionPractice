// Warning!
// This code is not valid
// Code which is corrected is W3_P3_2.

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class W3_P3 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);

		while (a.hasNext()) {

			int n = Integer.parseInt(a.nextLine());
			String xi = a.nextLine();
			String commend = a.nextLine();

			LinkedList<Integer> mush = new LinkedList<Integer>();
			boolean isErr = false;
			
			if (n != 0) {
				for (String m : xi.split(" ")) {
					int mi = Integer.parseInt(m);
					if (mush.size() >= n) {
						isErr = true;
						System.out.println("No mushrooms!");
						break;
					}
					else if (mi <= 100 && mi > 0) {
						mush.add(mi);
					}
				}
			}
			if(n > mush.size()) {
				isErr = true;
				System.out.println("No mushrooms!");
			}
			
			if (commend.length() > n || commend.length() > 100000 || commend.length() < 1) {
				System.out.println("No mushrooms!");
				isErr = true;
			} else if(!isErr) {
				try {
					int comCount = 0;
					for (String com : commend.split("")) {

						if (com.equals("R")) {
							Collections.reverse(mush);
						} else if (com.equals("B")) {
							Iterator<Integer> it = mush.iterator();
							int big = Collections.max(mush);
							it = mush.iterator();
							while (it.hasNext()) {
								int now = it.next();
								if (now == big) {
									it.remove();
									comCount++;
									break;
								}
							}
						} else if (com.equals("S")) {
							Iterator<Integer> it = mush.iterator();
							int sm = Collections.min(mush);
							it = mush.iterator();
							while (it.hasNext()) {
								int now = it.next();
								if (now == sm) {
									it.remove();
									comCount++;
									break;
								}
							}
						} else {
							System.out.println("Wrong Command!");
							isErr = true;
							comCount++;
							break;
						}

						if (comCount < com.length() && mush.isEmpty()) {
							System.out.println("No mushrooms!");
							isErr = true;
							break;
						}
						if (comCount >= com.length() - 1 && mush.isEmpty()) {
							System.out.println("Empty!");
							break;
						}
					}
				} catch (Exception e) {
					System.out.println("No mushrooms!");
					isErr = true;
				}
			}

			if (!isErr) {
				if (!mush.isEmpty()) {
					Iterator<Integer> it = mush.iterator();
					while (it.hasNext()) {
						System.out.print(it.next() + " ");
					}
					System.out.println();
				}

			}

		}

	}

}
