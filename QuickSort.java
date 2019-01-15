import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] a = { 9, 0, 1, 3, 4, 5, 2, 9, 8, 7, 6, 5, 9, 1, 0, 9 };
		System.out.println(Arrays.toString(a));
		qs.quickSort(a);
		System.out.println(Arrays.toString(a));
	}

	private void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private void quickSort(int[] a, int low, int high) {
		if (low < high + 1) {
			int p = partition(a, low, high);
			quickSort(a, low, p - 1);
			quickSort(a, p + 1, high);
		}
	}

	private void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	// returns random pivot index between low and high inclusive.
	private int getPivot(int low, int high) {
		Random rand = new Random();
		return rand.nextInt((high - low) + 1) + low;
	}

	// moves all n < pivot to left of pivot and all n > pivot
	// to right of pivot, then returns pivot index
	private int partition(int[] a, int low, int high) {
		swap(a, low, getPivot(low, high));
		int border = low + 1;
		for (int i = border; i <= high; i++) {
			if (a[i] < a[low]) {
				swap(a, i, border++);
			}
		}
		swap(a, low, border - 1);
		return border - 1;

	}
}
