
public class LinearProbeHashST {
	
	private static final int DEFAULT_SIZE = 16;
	
	private int N; // 当前键数目
	private int M; // 数组大小
	
	private Comparable[] keys;
	private String[] values;
	
	public LinearProbeHashST() {
		this(DEFAULT_SIZE);
	}
	
	public LinearProbeHashST(int M) {
		this.M = M;
		N = 0;
		keys = new Comparable[M];
		values = new String[M];
	}
	
	private int hash(Comparable key) {
		return (key.hashCode() & 0x0fffffff) % M;
	}
	
	public void put(Comparable key, String value) {
		int keyPos = hash(key);
		while (keys[keyPos] != null) {
			if (keys[keyPos].equals(key)) {
				values[keyPos] = value;
				return;
			}
			keyPos = (keyPos + 1)%M;
		}
		keys[keyPos] = key;
		values[keyPos] = value;
		N++;
		if (N > 0 && N >= M/2) resize(M*2);
	}
	
	public String get(Comparable key) {
		int keyPos = hash(key);
		while (keys[keyPos] != null) {
			if (keys[keyPos].equals(key)) {
				return values[keyPos];
			}
			keyPos = (keyPos + 1) % M;
		}
		return null;
	}
	
	public void delete(Comparable key) {
		int keyPos = hash(key);
		while (keys[keyPos] != null) {
			if (keys[keyPos].equals(key)) {
				keys[keyPos] = null;
				values[keyPos] = null;
				N--;
				break;
			}
			keyPos = (keyPos + 1) % M;
		}
		int i = (keyPos + 1) % M;
		while (keys[i] != null) {
			Comparable tempKey = keys[i];
			String tempValue = values[i];
			keys[i] = null;
			values[i] = null;
			N--;
			put(tempKey, tempValue);
			
			i = (i + 1) % M;
		}
		
		if (N > 0 && N <= M/8) resize(M/2);
	}
	
	
	private void resize(int size) {
		LinearProbeHashST t = new LinearProbeHashST(size);
		for (int i = 0; i < M; i++) {
			if (keys[i] != null) {
				t.put(keys[i], values[i]);
			}
		}
		keys = t.keys;
		values = t.values;
		M = t.M;
	}
	
	public int getN() {
		return N;
	}
	
	public int getM() {
		return M;
	}
	
}
