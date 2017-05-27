package jiahao.ye;

public class ShellSort {
	
	public static void sort(Comparable[] a) {
		int gap = 1;
		while (gap < a.length /3) gap = 3*gap + 1;
		while (gap >= 1) {
			
			for (int i = 0; i < gap; i++) {
				for (int j = i + gap; j < a.length; j += gap) {
					int position = findPosition(a, i, j, gap);
					Comparable tempJ = a[j];
					for (int k = j - gap; k >= position; k -= gap) {
						a[k + gap] = a[k];
					}
					a[position] = tempJ;
				}
			}
			
			gap /= 3;
		}
	}
	
	public static int findPosition(Comparable[] a, int begin, int current, int gap) {
		for (int i = current - gap; i >= begin; i -= gap) {
			if (less(a[i], a[current])) return i + gap;
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
