
public class OrderSearch {
	public static int search(Comparable[] array, int low, int high, Comparable target) {
		for (int i = low; i <= high; i++) {
			if (array[i].equals(target)) return i;
		}
		return -1;
	}
}
