/**
 * @author Antonella Atterey <antonella.atterey@etudiant.univ-rennes1.fr>
 * @author Ezan Tahi <ezan.tahi@etudiant.univ-rennes1.fr>
 * @class L3 MIAGE 2023/2024
 */

import java.util.Scanner;
import fr.istic.prg1.tp3.*;

public class Main {
	static InsertionInteger insertInt = new InsertionInteger();
	static InsertionPair insertPair = new InsertionPair();
	
	// Test Suite Fourmis
	public static void testFourmis() {
		String ui = "1";
		for (int i = 0; i < 10; i++) {
			System.out.println("u" + i + " = " + ui);
			ui = Fourmis.next(ui);
		}
	}

	// Tests pour InsertionInteger
	public static void testInsertII() {
		int[] entiers = { 5, 2, 6, 8, 1, -1, 2, 17, 0, 3, 7, 4, 99, 98, 99 };
		for (int i = 0; i < entiers.length; i++) {
			System.out.println(entiers[i] + " est inséré ? -> " + insertInt.insert(entiers[i]));
			System.out.println("Tableau trié: " + insertInt.toString());
			System.out.println(" ");
		}
	}

	public static void testCreateArrayII() {
		insertInt = new InsertionInteger();
		System.out.println("Entrez une séquence d'entiers terminée par -1");
		insertInt.createArray(new Scanner(System.in));
		System.out.println("Tableau trié: " + insertInt.toString());
	}

	// Tests pour InsertionPair
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
			new Pair(4,3)
		};
		for (int i = 0; i < pairs.length; i++) {
			System.out.println(pairs[i] + " est inséré ? -> " + insertPair.insert(pairs[i]));
			System.out.println("Tableau trié: " + insertPair.toString());
			System.out.println(" ");
		}
	}

	public static void testCreateArrayIP() {
		insertPair = new InsertionPair();
		System.out.println("Entrez une séquence d'entiers terminée par -1");
		insertPair.createArray(new Scanner(System.in));
		System.out.println("Tableau trié: " + insertPair.toString());
	}

	public static void testCreateArrayFromFileIP() {
		insertPair = new InsertionPair();
		insertPair.createArrayFromFile();
		System.out.println("Tableau trié: " + insertPair.toString());
	}

	// Main
	public static void main(String[] args) {
		// Test Suite Fourmis
		System.out.println("\nTEST SUITE FOURMIS");
		testFourmis();
				
		// Test Insertion Integer
		System.out.println("\nTEST INSERTION INTEGER");
		testInsertII();
		testCreateArrayII();

		// Test Insertion Pair
		System.out.println("\nTEST INSERTION PAIR");
		testInsertIP();
		testCreateArrayIP();
		testCreateArrayFromFileIP();
	}

}
