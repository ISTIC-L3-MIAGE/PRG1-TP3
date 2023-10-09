/**
 * @author Antonella Atterey <antonella.atterey@etudiant.univ-rennes1.fr>
 * @author Ezan Tahi <ezan.tahi@etudiant.univ-rennes1.fr>
 * @class L3 MIAGE 2023/2024
 * 
 *        Partie II
 *
 *        Lecture, au clavier, d'une suite de doublets d'entiers terminée par -1
 *
 *        Cette suite peut comporter des doublets identiques.
 * 
 *        Construction et affichage d'un tableau contenant les doublets
 *        distincts triés selon l'ordre croissant des doublets, à savoir : (x1,
 *        y1) < (x2, y2) <==> (x1<x2) ou (x1==x2 et y1<y2)
 * 
 *        En entrée : 3 8 1 4 3 8 1 3 -1 ==> En sortie : [1 3] [1 4] [3 8]
 */

package fr.istic.prg1.tp3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertionPair {

	private static final int SIZE_MAX = 10;
	private static final int END_MARKER = -1;
	/**
	 * nombre de doublets présents dans t, 0 <= size <= SIZE_MAX
	 */
	private int size;
	private Pair[] array;

	public InsertionPair() {
		size = 0;
		array = new Pair[SIZE_MAX];
	}

	/**
	 * @return copie de la partie remplie du tableau
	 */
	public Pair[] toArray() {
		Pair[] copy = new Pair[size];
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
			int e1 = scanner.nextInt(), e2 = scanner.nextInt();
			while (e1 != END_MARKER && e2 != END_MARKER) {
				insert(new Pair(e1, e2));
				e1 = scanner.nextInt();
				if (e1 != END_MARKER) {
					e2 = scanner.nextInt();
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("\nATTENTION: L'une de vos saisies n'est pas un entier.");
		}
	}
	
	/**
	 * array est rempli, par ordre croissant, en utilisant la fonction insert, avec
	 * les valeurs lues dans le fichier dont le nom a été saisi au clavier.
	 */
	public void createArrayFromFile() {
		Scanner scanner = new Scanner(FileManager.openInputFile());
		createArray(scanner);
	}

	/**
	 * Si pair n'appartient pas à array[0..size-1] et size < SIZE_MAX, size est
	 * incrémenté de 1, pair est inséré dans array et les entiers array[0..size]
	 * sont triés par ordre croissant. Sinon array est inchangé.
	 * 
	 * @param pair doublet à insérer
	 * 
	 * @pre les doublets de array[0..size-1] sont triés par ordre croissant
	 * 
	 * @return false si pair appartient à array[0..size-1] ou si array est
	 *         complètement rempli; true si pair n’appartient pas à array[0..size-1]
	 */
	public boolean insert(Pair pair) {
		// Cas particulier: array est complètement rempli ou value <= 0
		if (size == SIZE_MAX || pair.lessThanZero()) {
			return false;
		}

		// Recherche de value dans array
		int i = 0;
		while (i <= size) {
			if (pair.equals(array[i])) {
				return false;
			}
			// Insertion et tri si value n'a pas été trouvé dans array
			if ((array[i] != null && array[i].compareTo(pair) > 0) || i == size) {
				Pair temp = array[i];
				array[i] = pair;
				pair = temp;
			}
			i++;
		}
		size += 1;
		return true;
	}

	@Override
	public String toString() {
		return Arrays.toString(toArray());
	}
}