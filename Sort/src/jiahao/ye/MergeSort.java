package jiahao.ye;

public class MergeSort {

	private static Comparable[] arrayTemp;

	public static void sort1(Comparable[] a) {
		arrayTemp = new Comparable[a.length];

		sort1(a, 0, a.length - 1);
	}
	
	public static void sort2(Comparable[] a) {
		arrayTemp = new Comparable[a.length];

		sort2(a, 0, a.length - 1);
	}

	private static void sort1(Comparable[] a, int begin, int end) {
		if (begin >= end)
			return;
		int mid = (begin + end) / 2;
		sort1(a, begin, mid);
		sort1(a, mid + 1, end);
		merge(a, begin, mid, end);
	}
	
	private static void sort2(Comparable[] a, int begin, int end) {
		// 改进1
		if (end - begin <= 7) {
			InsertSort.sort(a, begin, end + 1);
			return;
		}
		int mid = (begin + end) / 2;
		sort2(a, begin, mid);
		sort2(a, mid + 1, end);
		// 改进2
		if (less(a[mid], a[mid+1])) return;
		merge(a, begin, mid, end);
	}

	private static void merge(Comparable[] a, int low, int mid, int high) {
		int j = low;
		int k = mid + 1;
		for (int i = low; i <= high; i++) {
			arrayTemp[i] = a[i];
		}
		for (int i = low; i <= high; i++) {
			if (j >= mid + 1) {
				a[i] = arrayTemp[k++];
			} else if (k >= high + 1) {
				a[i] = arrayTemp[j++];
			} else if (less(arrayTemp[j], arrayTemp[k])) {
				a[i] = arrayTemp[j++];
			} else {
				a[i] = arrayTemp[k++];
			}
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
