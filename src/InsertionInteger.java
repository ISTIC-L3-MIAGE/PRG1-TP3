import java.util.Arrays;
import java.util.Scanner;

public class InsertionInteger {
	private static final int SIZE_MAX = 10;
	private int size; // 0 <= size <= SIZE_MAX
	private int[] array = new int[SIZE_MAX];
	
	public InsertionInteger() {}
	
	public int getSize() {
		return size;
	}
	
	public void reset() {
		size = 0;
		array = new int[SIZE_MAX];
	}
	
	@Override
	public String toString() {
		String str = Arrays.toString(toArray());
		System.out.println("Tableau trié : " + str);
		System.out.println("size -> " + getSize());
		return str;
	}
	
	public int[] toArray() {
		int[] copy = new int[size];
		for (int i = 0; i < size; i++) {
			copy[i] = array[i];
		}
		return copy;
	}
	
	public boolean insert(int value) {
		// Cas particulier: array est complètement rempli ou value <= 0
		if (size == SIZE_MAX || value <= 0) { return false; }
		
		// Recherche de value dans array
		int i = 0;
		while (i < size && array[i] <= value) {
			if (array[i] == value) { return false; }
			i++;
		}
		
		// Insertion et tri si value n'a pas été trouvé dans array
		while (i <= size) {
			int temp = array[i];
			array[i] = value;
			value = temp;
			i++;
		}
		size += 1;
		return true;
	}
	
	public void createArray(Scanner scanner) {
		System.out.println("Entrez la séquence de nombre entiers à insérer: ");
		String[] entiers = scanner.nextLine().split(" ");
		
		int i = 0;
		try {
			while (i < entiers.length && !entiers[i].equals("-1")) {
				insert(Integer.parseInt(entiers[i]));
				i++;
			}
		} catch (NumberFormatException e) {
			System.out.println("\nATTENTION: L'une vos entrée n'est pas un entier, elle n'a pas été insérée.");
		}
	}
}
