
public class InsertionInteger {
	private static final int SIZE_MAX = 10;
	private int size; // 0 <= size <= SIZE_MAX
	private int[] array = new int[SIZE_MAX];
	
	public InsertionInteger() {
		
	}
	
	public int getSize() {
		return this.size;
	}
	
	/*
	 * @return copie de la partie remplie du tableau
	 */
	public int[] toArray() {
		int[] copy = new int[this.size];
		for (int i = 0; i < this.size; i++) {
			copy[i] = this.array[i];
		}
		return copy;
	}
	
	/*
	 * @param value : valeur à insérer
	 * @return false si value appartient à array[0..size-1] ou si array est complètement rempli;
	 * 			true si value n'appartient pas à array[0..size-1]
	 */
	public boolean insert(int value) {
		// Cas où array est complètement rempli
		if (this.array[SIZE_MAX-1] != 0) {
			return false;
		}
		// Cas où array est complètement vide
		if (this.size == 0) {
			this.array[0] = value;
			this.size = 1;
			return true;
		}
		int i = 0;
		while (i< size && this.array[i] <= value) {
			if (this.array[i] == value) {
				return false;
			}
			i++;
			
		}
		if (i == size) {
			this.array[i] = value;
		} else {
			for (int j = i; j <= size; j++) {
				int temp = this.array[j];
				this.array[j] = value;
				value = temp;
			}
		}
		size += 1;
		return true;

	}
}
