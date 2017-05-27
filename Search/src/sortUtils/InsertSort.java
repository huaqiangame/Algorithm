package sortUtils;


public class InsertSort {
	
	public static void sort(Comparable[] a, int begin, int end) {
		for (int i = begin + 1; i < end; i++) {
			int position = findPosition(a, i, begin); // 找到应该插入的位置
			Comparable tempI = a[i];
			for (int j = i - 1; j >= position; j--) { // 为插入的位置腾出空间，向后挪动
				a[j + 1] = a[j];
			}
			a[position] = tempI; // 插入值
		}
	}
	
	public static int findPosition(Comparable[] a, int i, int begin) {
		for (int j = i - 1; j >= begin; j--) {
			if (less(a[j], a[i])) return j + 1;
		}
		return begin;
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
