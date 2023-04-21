package coursePractice.generics;

public class KeyValue<K, V> {
	private K key;
	private V value;

	public KeyValue(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public void printKey() {
		System.out.println(key +" = "+value);
	}

}
