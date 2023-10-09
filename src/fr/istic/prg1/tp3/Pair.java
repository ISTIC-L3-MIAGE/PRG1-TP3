/**
 * @author Antonella Atterey <antonella.atterey@etudiant.univ-rennes1.fr>
 * @author Ezan Tahi <ezan.tahi@etudiant.univ-rennes1.fr>
 * @class L3 MIAGE 2023/2024
 * 
 *        Classe représentant des doublets *non modifiables*
 */

package fr.istic.prg1.tp3;

public class Pair implements Comparable<Pair> {

	private int x, y;

	public Pair() {
		x = 0;
		y = 0;
	}

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int compareTo(Pair d) {
		/*
		 * @return -1 si this < d
		 * 
		 * @return 0 si this == d
		 * 
		 * @return 1 si this > d
		 */
		if (x < d.getX() || (x == d.getX() && y < d.getY())) {
			return -1;
		}
		if (x > d.getX() || (x == d.getX() && y > d.getY())) {
			return 1;
		}
		return 0;
	}

	public boolean lessThanZero() {
		return x < 0 || y < 0;
	}

	public Pair copyOf() {
		return new Pair(x, y);
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pair)) {
			return false;
		}
		Pair p = (Pair) obj;
		return x == p.getX() && y == p.getY();
	}
}