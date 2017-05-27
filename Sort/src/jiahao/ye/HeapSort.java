package jiahao.ye;

public class HeapSort {
	public static void sort(Comparable[] a) {
		// 先构造堆
		int N = a.length;
		for (int i = N / 2; i >= 1; i--) {
			sink(a, i, N);
		}
		// 排序，销毁堆
		while (N-- > 1) {
			swap(a, 1, N);
			sink(a, 1, N);
		}
	}

	public static void sink(Comparable[] a, int begin, int length) {
		while (begin * 2 < length) {
			int maxIndex = begin * 2;
			if (maxIndex + 1 < length && less(a[maxIndex], a[maxIndex + 1])) { // 如果有两个子节点,选择较大的子节点
				maxIndex++;
			}

			if (!less(a[begin], a[maxIndex]))
				break;
			swap(a, begin, maxIndex);
			begin = maxIndex;
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
