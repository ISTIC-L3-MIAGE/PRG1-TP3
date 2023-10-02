import java.util.Arrays;

public class Main {
	
	public static void testInsertionInteger() {
		InsertionInteger insertInt = new InsertionInteger();
		
		// Test toArray()
		int[] array = insertInt.toArray();
		System.out.println(Arrays.toString(insertInt.toArray()));
		System.out.println("size -> " + insertInt.getSize());
		System.out.println(" ");

		// Test insert(int value)
		int[] entiers = {5, 2, 6, 8, 1};
		for (int i = 0; i < entiers.length; i++) {
			// Complete this
			System.out.println(entiers[i] + " est inséré ? -> " + insertInt.insert(entiers[i]));
			System.out.println("size -> " + insertInt.getSize());
			System.out.println(Arrays.toString(insertInt.toArray()));
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		testInsertionInteger();
	}

}
