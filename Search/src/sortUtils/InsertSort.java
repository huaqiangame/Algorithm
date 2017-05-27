package sortUtils;


public class InsertSort {
	
	public static void sort(Comparable[] a, int begin, int end) {
		for (int i = begin + 1; i < end; i++) {
			int position = findPosition(a, i, begin); // �ҵ�Ӧ�ò����λ��
			Comparable tempI = a[i];
			for (int j = i - 1; j >= position; j--) { // Ϊ�����λ���ڳ��ռ䣬���Ų��
				a[j + 1] = a[j];
			}
			a[position] = tempI; // ����ֵ
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
