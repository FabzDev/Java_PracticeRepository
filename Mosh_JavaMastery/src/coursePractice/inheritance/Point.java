package coursePractice.inheritance;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			var otherPoint = (Point) obj;
			return otherPoint.x == x && otherPoint.y == y;
		}
		return false;
	}

}
