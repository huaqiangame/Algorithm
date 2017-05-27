
public class BSTSearch {

	class Node {
		Comparable key;
		String value;
		Node left;
		Node right;

		public Node(Comparable key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	private static Node root;

	public static String search(Comparable target) {
		return search(root, target);
	}

	private static String search(Node x, Comparable target) {
		if (x == null)
			return null;
		int compared = target.compareTo(x.key);
		if (compared > 0) { // 目标比当前大
			return search(x.right, target);
		} else if (compared < 0) { // 目标比当前小
			return search(x.left, target);
		} else {
			return x.value;
		}
	}

	public static void put(Comparable key, String value) {
		root = put(root, key, value);
	}

	private static Node put(Node x, Comparable key, String value) {
		if (x == null)
			return new BSTSearch().new Node(key, value);
		int compared = key.compareTo(x.key);
		if (compared > 0) {
			x.right = put(x.right, key, value);
		} else if (compared < 0) {
			x.left = put(x.left, key, value);
		} else {
			x.value = value;
		}
		return x;
	}

	public static Node min() {
		return min(root);
	}

	private static Node min(Node x) {
		if (x == null)
			return null;
		if (x.left != null)
			return min(x.left);
		return x;
	}

	public static void delMin() {
		root = delMin(root);
	}

	private static Node delMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = delMin(x.left);
		return x;
	}

	public static Node max() {
		return max(root);
	}

	private static Node max(Node x) {
		if (x == null)
			return null;
		if (x.right != null)
			return max(x.right);
		return x;
	}

	public static void delMax() {
		root = delMax(root);
	}

	private static Node delMax(Node x) {
		if (x.right == null)
			return x.left;
		x.right = delMax(x.right);
		return x;
	}

	public static void delete(Comparable key) {
		root = delete(root, key);
	}

	private static Node delete(Node x, Comparable key) {
		if (x == null)
			return null;
		int compared = key.compareTo(x.key);
		if (compared > 0) { // 删除的东西比当前大
			x.right = delete(x.right, key);
		} else if (compared < 0) {
			x.left = delete(x.left, key);
		} else {
			// 找到了要删除的key
			if (x.left == null) { // 如果要删除的key左边为null
				return x.right;
			}
			if (x.right == null) { // 如果要删除的key右边为null
				return x.left;
			}
			// 如果左右都不为null
			if (Math.random() > 0.5) {
				Node temp = x;
				x = min(x.right);
				x.right = delMin(temp.right);
				x.left = temp.left;
			} else {
				Node temp = x;
				x = max(x.left);
				x.left = delMin(temp.left);
				x.right = temp.right;
			}
		}
		return x;
	}

	public static void printTree() {
		printTree(root);
		System.out.println();
	}

	private static void printTree(Node x) {
		if (x == null)
			return;
		printTree(x.left);
		System.out.print(x.key + " ");
		printTree(x.right);
	}
}
