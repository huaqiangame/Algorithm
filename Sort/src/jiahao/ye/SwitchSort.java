package jiahao.ye;

public class SwitchSort {
	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[minIndex])) {
					minIndex = j;
				}
			}
			swap(a, minIndex, i);
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
