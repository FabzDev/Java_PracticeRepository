package coursePractice.inheritance;

import java.util.Objects;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
	
	
//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Point))
//			return false;
//		var otherPoint = (Point) obj;
//		return otherPoint.x == x && otherPoint.y == y;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(x, y);
//	}
}
