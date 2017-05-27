package jiahao.ye;

public class Test {

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
//		 Scanner sc = new Scanner(System.in);
//		 String[] a = sc.nextLine().split(" ");
		final int NUM = 1000000;
		Integer[] a1 = new Integer[NUM];
		Integer[] a2 = new Integer[NUM];
		Integer[] a3 = new Integer[NUM];
		Integer[] a4 = new Integer[NUM];
		a1[0] = a2[0] = a3[0] = a4[0] = -1;
		for (int i = 1; i < NUM; i++) {
			a1[i] = (int) (Math.random() * NUM);
			a2[i] = a1[i];
			a3[i] = a1[i];
			a4[i] = a1[i];
		}

		long startTime;
		long endTime;
		
		startTime = System.currentTimeMillis(); // ��ȡ��ʼʱ��
		QuickSort.sort2(a2);
		assert isSorted(a2);
		endTime = System.currentTimeMillis();
		System.out.println("Quick����cost: " + (endTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis(); // ��ȡ��ʼʱ��
		MergeSort.sort2(a3);
		assert isSorted(a3);
		endTime = System.currentTimeMillis();
		System.out.println("Merge����cost: " + (endTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis(); // ��ȡ��ʼʱ��
		HeapSort.sort(a1);
		assert isSorted(a1);
		endTime = System.currentTimeMillis();
		System.out.println("Heap����cost: " + (endTime - startTime) + " ms");
	}

}
