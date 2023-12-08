/**
 * @author Antonella Atterey <antonella.atterey@etudiant.univ-rennes1.fr>
 * @author Ezan Tahi <ezan.tahi@etudiant.univ-rennes1.fr>
 * @class L3 MIAGE 2023/2024
 * 
 *        Partie I
 * 
 *        Lecture, au clavier, d'une suite d'entiers terminée par -1
 * 
 *        Cette suite peut comporter des valeurs doubles.
 * 
 *        Construction et affichage d'un tableau contenant les entiers distincts
 *        triés par valeur croissante.
 * 
 *        Exemple. En entrée : 3 8 1 4 3 2 1 3 -1 ==> En sortie : 1 2 3 4 8
 */

package fr.istic.prg1.tp3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertionInteger {

	private static final int SIZE_MAX = 10;
	private static final int END_MARKER = -1;
	/**
	 * nombre d’entiers présents dans t, 0 <= size <= SIZE_MAX
	 */
	private int size;
	private int[] array;

	public InsertionInteger() {
		size = 0;
		array = new int[SIZE_MAX];
	}

	/**
	 * @return copie de la partie remplie du tableau
	 */
	public int[] toArray() {
		int[] copy = new int[size];
		for (int i = 0; i < size; i++) {
			copy[i] = array[i];
		}
		return copy;
	}

	/**
	 * array est rempli, par ordre croissant, en utilisant la fonction insert, avec
	 * les valeurs lues par scanner.
	 * 
	 * @param scanner
	 */
	public void createArray(Scanner scanner) {
		try {
			int entier = scanner.nextInt();
			while (entier != END_MARKER) {
				insert(entier);
				entier = scanner.nextInt();
			}
		} catch (InputMismatchException e) {
			System.out.println("\nATTENTION: L'une de vos saisies n'est pas un entier.");
		}
	}

	/**
	 * Si value n'appartient pas à array[0..size-1] et size < SIZE_MAX, size est
	 * incrémenté de 1, value est inséré dans array et les entiers array[0..size]
	 * sont triés par ordre croissant. Sinon array est inchangé.
	 * 
	 * Exemple :
	 * 
	 * pour x = 5, size = 3, array[0] = 1, array[1] = 6, array[2] = 8
	 * 
	 * insertion délivre true, size = 4,
	 * 
	 * array[0] = 1, array[1] = 5, array[2] = 6, array[3] = 8
	 * 
	 * @param value valeur à insérer
	 * 
	 * @pre les valeurs de array[0..size-1] sont triées par ordre croissant
	 * 
	 * @return false si value appartient à array[0..size-1] ou si array est
	 *         complètement rempli; true si value n’appartient pas à
	 *         array[0..size-1]
	 */
	public boolean insert(int value) {
		// Cas particulier: array est complètement rempli ou value <= 0
		if (size == SIZE_MAX || value <= 0) { return false; }
		
		// Recherche de value dans array
		int i = 0;
		while (i < size && array[i] < value) {
			i++;
		}
		
		if (array[i] == value) { 
			return false;
		}
		
		// Insertion et tri si value n'a pas été trouvé dans array
		for (int j = size; j > i; j--) {
			array[j] = array[j-1];
		}
		array[i] = value;
		size += 1;
		return true;
	}

	@Override
	public String toString() {
		return Arrays.toString(toArray());
	}
}
