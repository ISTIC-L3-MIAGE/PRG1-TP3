import java.util.Arrays;
import java.util.Scanner;

public class InsertionPair {
	private static final int SIZE_MAX = 10;
	private int size; // 0 <= size <= SIZE_MAX
	private Pair[] array = new Pair[SIZE_MAX];
	
	public InsertionPair() {}
	
	public int getSize() {
		return size;
	}
	
	public void reset() {
		size = 0;
		array = new Pair[SIZE_MAX];
	}
	
	@Override
	public String toString() {
		String str = Arrays.toString(toArray());
		System.out.println("Tableau trié : " + str);
		System.out.println("size -> " + getSize());
		return str;
	}
	
	/*
	 * @return copie de la partie remplie du tableau
	 */
	public Pair[] toArray() {
		Pair[] copy = new Pair[size];
		for (int i = 0; i < size; i++) {
			copy[i] = array[i];
		}
		return copy;
	}
	
	/*
	 * Insert la valeur "value" dans le tableau "array" en
	 * le gardant trié par ordre croissant.
	 * 
	 * @param value : valeur à insérer
	 * @return false si value appartient à array[0..size-1] ou si array est complètement rempli;
	 * 			true si value n'appartient pas à array[0..size-1]
	 */
	public boolean insert(Pair value) {
		// Cas particulier: array est complètement rempli ou value <= 0
		if (size == SIZE_MAX || value.lessThanZero()) { return false; }
		
		// Parcours du tableau
		int i = 0;
		while (i < size && array[i].lessOrEquals(value)) {
			if (array[i].equals(value)) { return false; }
			i++;
		}
		
		// Insertion et tri si value n'a pas été trouvé dans array
		for (int j = i; j <= size; j++) {
			Pair temp = array[j];
			array[j] = value;
			value = temp;
		}
		size += 1;
		return true;
	}
	
	/*
	 * Rempli le tableau array par ordre croissant en utilisant
	 * la méthode insert() avec les valeurs lues par scanner.
	 * 
	 * @param scanner
	 */
	public void createArray(Scanner scanner) {
		String userInput = "", totalUserInput = "";
		while (!userInput.equals("-1")) {
			System.out.print("Entrez une paire d'entiers à insérer et -1 pour arrêter: ");
			userInput = scanner.nextLine();
			totalUserInput += userInput + ";";
		}
		
		int i = 0;
		String[] pairs = totalUserInput.split(";");
		try {
			while (i < pairs.length && !pairs[i].equals("-1")) {
				String[] pairStr = pairs[i].split(" ");
				insert(new Pair(pairStr));
				i++;
			}
		} catch (NumberFormatException e) {
			System.out.println("\nL'une vos entrée n'est pas un entier, elle n'a pas été insérée.");
		}
	}
}
