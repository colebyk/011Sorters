
public class BubbleSort {
	
	static int[] list = {2,5,6,4,3,5,8,7};

	public static void main(String[] args) {
		System.out.println("Bubble Sort:");
	
		list = bubbleSort(list);
		for (int x: list) {
			System.out.println(x);
		}

	}
	private static int[] bubbleSort(int[] list) {

		int temp = 0;
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - 1 - i; j++) {
				if (list[j] < list[j + 1]) {
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;;
				}
			}
		}

		return list;
	} // end of bubbleSort

}
