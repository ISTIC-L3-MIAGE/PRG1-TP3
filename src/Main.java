import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static InsertionInteger insertInt = new InsertionInteger();
	static InsertionPair insertPair = new InsertionPair();

	// Tests pour InsertionInteger
	public static void testToArrayII() {
		System.out.println(Arrays.toString(insertInt.toArray()));
		System.out.println("size -> " + insertInt.getSize());
		System.out.println(" ");

	}
	
	public static void testInsertII() {
		int[] entiers = {5, 2, 6, 8, 1, -1, 2, 17, 0, 3, 7, 4, 99, 98, 99};
		for (int i = 0; i < entiers.length; i++) {
			System.out.println(entiers[i] + " est inséré ? -> " + insertInt.insert(entiers[i]));
			insertInt.toString();
			System.out.println(" ");
		}
	}

	public static void testCreateArrayII() {
		insertInt.reset();
		insertInt.createArray(new Scanner(System.in));
		insertInt.toString();
	}
	
	// Tests pour InsertionInteger
	public static void testToArrayIP() {
		System.out.println(Arrays.toString(insertPair.toArray()));
		System.out.println("size -> " + insertPair.getSize());
		System.out.println(" ");

	}
	
	public static void testInsertIP() {
		Pair[] pairs = {
				new Pair(3,8),
				new Pair(1,4),
				new Pair(3,8),
				new Pair(2,2),
				new Pair(10,4),
				new Pair(8,1),
				new Pair(1,1),
				new Pair(3,0),
				new Pair(-1,1),
				new Pair(2,7),
				new Pair(7,2),
				new Pair(4,5),
				new Pair(4,4),
				new Pair(4,3),
		};
		for (int i = 0; i < pairs.length; i++) {
			System.out.println(pairs[i] + " est inséré ? -> " + insertPair.insert(pairs[i]));
			insertPair.toString();
			System.out.println(" ");
		}
	}

	public static void testCreateArrayIP() {
		insertPair.reset();
		insertPair.createArray(new Scanner(System.in));
		insertPair.toString();
	}
	//Test Suite Fourmis
	public static void testFourmis() {
		System.out.println(Fourmis.next("1211"));
		
	}

	public static void main(String[] args) {
		// Test InsertionInteger
		//testToArrayII();
		//testInsertII();
		//testCreateArrayII();
		
		// Test InsertionPair
		//Test Suite Fourmis

		testToArrayIP();
		testInsertIP();
		testCreateArrayIP();
		testFourmis();
	}

}
