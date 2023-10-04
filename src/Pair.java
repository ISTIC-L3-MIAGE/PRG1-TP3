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
	
	/*
	 * Construis une paire d'entiers à partir d'un tableau de chaines
	 * de caractères en se servant des deux premières valeurs.
	 */
	private void initWithArray(String[] XY) {
		try {
			x = Integer.parseInt(XY[0]);
			y = Integer.parseInt(XY[1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\nATTENTION: Le tableau " + Arrays.toString(XY) + " utilisé pour contruire la pair n'est pas valide.");
		} catch (NumberFormatException e) {
			System.out.println("\nATTENTION: L'une vos entrées n'est pas un entier, elle n'a pas été insérée.");
		}
	}
	
	/*
	 * Crée un tableau de Pair à partir d'un tableau de pairString.
	 * 
	 * @param array : le tableau de String contenant des paires sous
	 * 					la forme ["3 8", "1 4", "3 8", "1 3"]
	 * @return un tableau de Pair
	 */
	public static Pair[] fromStrArray(String[] array) {
		Pair[] pairs = new Pair[array.length];
		for (int i = 0; i < array.length; i++) {
			pairs[i] = new Pair(array[i].split(" "));
		}
		return pairs;
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
