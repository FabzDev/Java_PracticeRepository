package coursePractice.generics;

public class List {
	private int[] numbers = new int[10];
	private int count;
	
	public void add(int num) {
		numbers[count++] = num;
	}
	
	public int getNum(int index) {
		return numbers[index];
	}
}
