import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static InsertionInteger insertInt = new InsertionInteger();

	// Tests pour InsertionInteger
	public static void testToArray() {
		System.out.println(Arrays.toString(insertInt.toArray()));
		System.out.println("size -> " + insertInt.getSize());
		System.out.println(" ");

	}
	
	public static void testInsert() {
		int[] entiers = {5, 2, 6, 8, 1, -1, 2, 17, 0, 3, 7, 4, 99, 98, 99};
		for (int i = 0; i < entiers.length; i++) {
			System.out.println(entiers[i] + " est inséré ? -> " + insertInt.insert(entiers[i]));
			insertInt.toString();
			System.out.println(" ");
		}
	}

	public static void testCreateArray() {
		insertInt.reset();
		insertInt.createArray(new Scanner(System.in));
		insertInt.toString();
	}

	public static void main(String[] args) {
		testToArray();
		testInsert();
		//testCreateArray();
	}

}
