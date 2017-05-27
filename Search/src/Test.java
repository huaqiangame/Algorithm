import java.util.Scanner;

import sortUtils.QuickSort;

public class Test {
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] a = sc.nextLine().split(" ");
		
		LinearProbeHashST st = new LinearProbeHashST();
		
		for (int i = 0; i < a.length; i++) {
			st.put(i, a[i]);
		}
		
//		st.delete(0);
//		st.delete(1);
//		st.delete(2);
//		st.delete(3);
//		st.delete(4);
//		st.delete(5);
//		st.delete(6);
		for (int i = 0; i < a.length; i++) {
			System.out.println(st.get(i));
		}
		System.out.println(st.getN());
		System.out.println(st.getM());
	}
}
