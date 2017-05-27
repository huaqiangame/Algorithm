package jiahao.ye;

import java.rmi.server.SocketSecurityException;
import java.util.Comparator;
import java.util.Scanner;

public class BubbleSort {
	
	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (less(a[j + 1], a[j])) {
					swap(a, j, j + 1);
				}
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
