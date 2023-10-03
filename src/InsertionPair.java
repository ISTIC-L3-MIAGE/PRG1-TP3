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
	
	public Pair[] toArray() {
		Pair[] copy = new Pair[size];
		for (int i = 0; i < size; i++) {
			copy[i] = array[i];
		}
		return copy;
	}
	
	public boolean insert(Pair value) {
		// Cas particulier: array est complètement rempli ou value <= 0
		if (size == SIZE_MAX || value.lessThanZero()) { return false; }
		
		// Recherche de value dans array
		int i = 0;
		while (i < size && array[i].lessOrEquals(value)) {
			if (array[i] == value) { return false; }
			i++;
		}
		
		// Insertion et tri si value n'a pas été trouvé dans array
		while (i <= size) {
			Pair temp = array[i];
			array[i] = value;
			value = temp;
			i++;
		}
		size += 1;
		return true;
	}
	
	public void createArray(Scanner scanner) {
		String userInput = "", totalUserInput = "";
		System.out.println("Entrez une suite paire d'entiers à insérer et -1 pour arrêter: ");

		while (!userInput.equals("-1")) {
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
