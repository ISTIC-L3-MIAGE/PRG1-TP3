import java.util.Arrays;

public class Pair {
	private int x, y;
	
	public Pair() {
		x = 0;
		y = 0;
	}
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Pair(String[] XY) {
		initWithArray(XY);
	}
	
	private void initWithArray(String[] XY) {
		try {
			x = Integer.parseInt(XY[0]);
			y = Integer.parseInt(XY[1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\nATTENTION: Le tableau " + Arrays.toString(XY) + " utilisé pour contruire la pair n'est pas valide.");
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean equals(Pair p) {
		return x == p.getX() && y == p.getY();
	}
	
	public boolean less(Pair p) {
		return x < p.getX() || (x == p.getX() && y < p.getY());
	}
	
	public boolean lessOrEquals(Pair p) {
		return less(p) || equals(p);
	}
	
	public boolean lessThanZero() {
		return x <= 0 || y <= 0;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}
