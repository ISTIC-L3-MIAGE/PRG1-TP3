
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
	
	public Pair(String[] pairStrTab) {
		this.x = Integer.parseInt(pairStrTab[0]);
		this.y = Integer.parseInt(pairStrTab[1]);
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

}
