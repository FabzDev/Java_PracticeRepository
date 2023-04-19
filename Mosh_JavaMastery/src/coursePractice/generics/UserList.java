package coursePractice.generics;

public class UserList {
	private Object[] users = new Object[10];
	private int count;
	
	public void add(Object user) {
		users[count++] = user;
	}
	
	public Object get(int index) {
		return users[index];
	}
}
