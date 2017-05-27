
public class BinarySearch {
	
	public static int recurSearch(Comparable[] orderArray, int low, int high, Comparable target) {
		if (low > high) return -1;
		int mid = (low + high) / 2;
		int compared = orderArray[mid].compareTo(target);
		if (compared > 0) { // 中值比目标大
			return recurSearch(orderArray, low, mid - 1, target);
		} else if (compared < 0) { // 中值比目标小
			return recurSearch(orderArray, mid + 1, high, target);
		} else {
			return mid;
		}
	}
	
	public static int iteratorSearch(Comparable[] orderArray, int low, int high, Comparable target) {
		while (low <= high) {
			int mid = (low + high) / 2;
			int compared = orderArray[mid].compareTo(target);
			if (compared > 0) {
				high = mid - 1;
			} else if (compared < 0) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
