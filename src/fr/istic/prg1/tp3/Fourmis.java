package fr.istic.prg1.tp3;

/**
 * @author Antonella Atterey <antonella.atterey@etudiant.univ-rennes1.fr>
 * @author Ezan Tahi <ezan.tahi@etudiant.univ-rennes1.fr>
 * @class L3 MIAGE 2023/2024
 */

public class Fourmis {

	/**
	 * @param ui un terme de la suite des fourmis
	 * @pre ui.length() > 0
	 * @return le terme suivant de la suite des fourmis
	 */
	public static String next(String ui) {
		String resultat = "";
		// On compte la plus grande suite d'un nombre
		int compteur = 1;
		for (int i = 0; i < ui.length() - 1; i++) {
			if (ui.charAt(i) == ui.charAt(i + 1)) {
				compteur += 1;
			} else {
				resultat = resultat + compteur + ui.charAt(i);
				compteur = 1;
			}
		}
		return resultat + compteur + ui.charAt(ui.length() - 1);
	}
}