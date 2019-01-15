
public class InsertionSort {
	static int[] list = {3,4,5,7,5,3,2,1,4,5,7};

	public static void main(String[] args) {
		list = insertionSort(list);
		for (int x: list) {
			System.out.println(x);
		}

	}
	private static int[] insertionSort(int[] frequency) {

		int temp, key, j;
		String tempStr;
		for (int i = 1; i < frequency.length; i++) {
			key = frequency[i];
			j = i - 1;
			while (j >= 0 && key > frequency[j]) {
				temp = frequency[j];
				frequency[j] = frequency[j + 1];
				frequency[j + 1] = temp;
				j--;
			}

		}
		return frequency;
	} // end of insertionSort
}
