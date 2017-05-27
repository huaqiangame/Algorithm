package jiahao.ye;

public class QuickSort {
	public static void sort1(Comparable[] a) {
		// 随机打乱数组
		for (int i = 0; i < a.length / 3; i++) {
			swap(a, i, (int) (Math.random() * a.length));
		}

		sort1(a, 0, a.length - 1);
	}

	public static void sort2(Comparable[] a) {
		sort2(a, 0, a.length - 1);
	}

	public static void sort1(Comparable[] a, int low, int high) {
		if (low >= high)
			return;
		int partition = partition1(a, low, high);
		sort1(a, low, partition - 1);
		sort1(a, partition + 1, high);
	}
	
	public static void sort2(Comparable[] a, int low, int high) {
		if (high - low <= 7) { // 改进1
			InsertSort.sort(a, low, high + 1);
			return;
		}
		int partition = partition2(a, low, high);
		sort2(a, low, partition - 1);
		sort2(a, partition + 1, high);
	}

	public static int partition1(Comparable[] a, int low, int high) {
		int i = low;
		int j = high + 1;
		Comparable compare = a[low];
		while (true) {
			while (less(a[++i], compare))
				if (i == high)
					break;
			while (less(compare, a[--j]))
				if (j == low)
					break;
			if (i >= j)
				break;
			swap(a, i, j);
		}
		swap(a, j, low);
		return j;
	}
	
	public static int partition2(Comparable[] a, int low, int high) {
		// 改进2
//		Comparable temp1 = a[low], temp2 = a[(low + high)/2], temp3 = a[high];
//		int midIndex = low;
//		if (less(temp1, temp2) && less(temp2, temp3)) midIndex = (low + high)/2;
//		if (less(temp2, temp1) && less(temp1, temp3)) midIndex = low;
//		if (less(temp1, temp3) && less(temp3, temp2)) midIndex = high;
//		swap(a, low, midIndex);
		swap(a, low, (int)(Math.random() * (high - low) + low));
		
		int i = low;
		int j = high + 1;
		Comparable compare = a[low];
		while (true) {
			while (less(a[++i], compare))
				if (i == high)
					break;
			while (less(compare, a[--j]))
				if (j == low)
					break;
			if (i >= j)
				break;
			swap(a, i, j);
		}
		swap(a, j, low);
		return j;
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
