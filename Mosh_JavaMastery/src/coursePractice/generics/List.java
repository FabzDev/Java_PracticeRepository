package coursePractice.generics;

public class List {
	int[] numbers = new int[10];
	int count;
	
	public void add(int num) {
		numbers[count++] = num;
	}
	
	public void getNum(int index) {
		System.out.println(numbers[index]);
	}
}
