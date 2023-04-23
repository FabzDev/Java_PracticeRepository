package coursePractice.generics;

public class User implements Comparable<User> {
	  private int points;

	  public User(int points) {
	    this.points = points;
	  }

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}
}