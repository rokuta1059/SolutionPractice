import java.util.Scanner;

public class W3_P3_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			// Parse begin
			int arrSize = Integer.parseInt(sc.nextLine());
			int[] mushroomSizeList;
			String[] sizeListRaw = sc.nextLine().split(" ");
			mushroomSizeList = new int[sizeListRaw.length];
			for (int i = 0; i < mushroomSizeList.length; i++)
				mushroomSizeList[i] = Integer.parseInt(sizeListRaw[i]);
			String[] commandsList = sc.nextLine().split("");
			// Parse end

			int[] mushroomStorage = new int[arrSize];
			for (int i = 0; i < arrSize; i++)
				mushroomStorage[i] = mushroomSizeList[i];

			boolean isError = false;
			for (int i = 0; i < commandsList.length; i++) {

				if (mushroomStorage == null) {
					System.out.println("No mushrooms!");
					isError = true;
					break;
				} else {
					switch (commandsList[i]) {
					case "R":
						int[] reverse = new int[mushroomStorage.length];
						for (int j = 0; j < mushroomStorage.length; j++)
							reverse[mushroomStorage.length - 1 - j] = mushroomStorage[j];
						mushroomStorage = reverse;
						break;
					case "B":
						mushroomStorage = shrinkArray(mushroomStorage, false);
						break;
					case "S":
						mushroomStorage = shrinkArray(mushroomStorage, true);
						break;
					default:
						System.out.println("Wrong Command!");
						isError = true;
					}
				}

				if (isError)
					break;
			}

			if (!isError) {
				if (mushroomStorage == null)
					System.out.println("Empty!");
				else {
//					if(mushroomStorage.length < 1500)
//						throw new ArrayIndexOutOfBoundsException();
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < mushroomStorage.length; j++)
						sb.append(mushroomStorage[j] + " ");
					System.out.println(sb.toString().trim());
				}
			}
		}

		sc.close();
	}

	public static int[] shrinkArray(int[] array, boolean isMin) {
		int max = array[array.length - 1];
		int maxIdx = array.length - 1;
		for (int j = array.length - 1; j >= 0; j--) {
			max = isMin ? Math.min(array[j], max) : Math.max(array[j], max);
			maxIdx = Math.max(array[j],  array[maxIdx]) == array[j]? j : maxIdx;
			maxIdx = ((isMin ? (Math.min(array[j], array[maxIdx])) : (Math.max(array[j], array[maxIdx]))) == array[j])
					? j
					: maxIdx;
		}
		int[] mushroomStorageShrink;
		if (array.length == 1)
			mushroomStorageShrink = null;
		else {
			mushroomStorageShrink = new int[array.length - 1];
			for (int j = 0; j < mushroomStorageShrink.length; j++)
				mushroomStorageShrink[j] = (j < maxIdx) ? array[j] : array[j + 1];
		}
		return mushroomStorageShrink;
	}
}