package coursePractice.generics;

public class Util {

	public static <T extends Comparable<T>> T max(T first, T second) {
		return (first.compareTo(second) > 0) ? first : second;
	}
	
	public static <K, V> void printKey(K key, V value) {
		System.out.println(key +" = "+ value);
	}
	
}
