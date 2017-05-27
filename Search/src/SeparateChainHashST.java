
public class SeparateChainHashST {
	
	private final static int DEFAULT_SIZE = 5;

	private int M; // 数组大小
	private BSTSearch[] array;
//	private int[] listCount;
	
	public SeparateChainHashST() {
		this(DEFAULT_SIZE);
	}
	
	public SeparateChainHashST(int M) {
		this.M = M;
		array = new BSTSearch[M];
//		listCount = new int[M];
		for (int i = 0; i < M; i++) {
			array[i] = new BSTSearch();
//			listCount[i] = 0;
		}
	}
	
	private int hash(Comparable key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public String get(Comparable key) {
		return array[hash(key)].search(key);
	}
	
	public void put(Comparable key, String value) {
		array[hash(key)].put(key, value);
//		listCount[hash(key)]++;
	}
	
	public void delete(Comparable key) {
		array[hash(key)].delete(key);
//		listCount[hash(key)]--;
	}
	
//	public int getListCount(int num) {
//		if (num >= M) return -1;
//		return listCount[num];
//	}
	

}
