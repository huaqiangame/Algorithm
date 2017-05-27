import org.omg.CosNaming.IstringHelper;

public class RedBlackBSTree {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private class Node {
		Comparable value;
		Node left;
		Node right;
		boolean color;

		public Node(Comparable value) {
			this.value = value;
			this.left = null;
			this.right = null;
			this.color = RED;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + ", color=" + color + "]";
		}
	}

	private static Node root;

	public static Node search(Comparable target) {
		return search(root, target);
	}

	private static Node search(Node x, Comparable target) {
		if (x == null)
			return null;
		int compared = target.compareTo(x.value);
		if (compared > 0) {
			return search(x.right, target);
		} else if (compared < 0) {
			return search(x.left, target);
		}
		return x;
	}

	public static void put(Comparable key) {
		root = put(root, key);
		root.color = BLACK;
	}

	private static Node put(Node x, Comparable key) {
		if (x == null)
			return new RedBlackBSTree(). new Node(key);

		int compared = key.compareTo(x.value);
		if (compared > 0) {
			x.right = put(x.right, key);
		} else if (compared > 0) {
			x.left = put(x.left, key);
		}

		if (isRed(x.right) && !isRed(x.left)) { // 左旋转
			x = rotateLeft(x);
		}
		if (isRed(x.left) && isRed(x.left.left)) { // 右旋转
			x = rotateRight(x);
		}
		if (isRed(x.left) && isRed(x.right)) { // 颜色反转
			flipColor(x);
		}
		return x;
	}

	private static Node rotateLeft(Node h) {
		boolean temp = h.right.color;
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		if (temp != RED) {
			System.out.println("rotateLeft: !!!Not Red");
		}
		x.color = h.color;
		h.color = temp;
		return x;
	}

	private static Node rotateRight(Node h) {
		boolean temp = h.left.color;
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		if (temp != RED) {
			System.out.println("rotateRight: !!!Not Red");
		}
		x.color = h.color;
		h.color = temp;
		return x;
	}
	
	private static void flipColor(Node x) {
		x.color = !x.color;
		x.left.color = !x.left.color;
		x.right.color = !x.right.color;
	}

	private static boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}
	
	public static void printTree() {
		printTree(root);
	}
	
	private static void printTree(Node x) {
		if (x == null) return;
		printTree(x.left);
		System.out.println(x.toString());
		printTree(x.right);
	}
}
