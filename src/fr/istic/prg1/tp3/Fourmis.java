/**
 * @author Antonella Atterey <antonella.atterey@etudiant.univ-rennes1.fr>
 * @author Ezan Tahi <ezan.tahi@etudiant.univ-rennes1.fr>
 * @class L3 MIAGE 2023/2024
 */

package fr.istic.prg1.tp3;

public class Fourmis {

	/**
	 * @param ui un terme de la suite des fourmis
	 * @pre ui.length() > 0
	 * @return le terme suivant de la suite des fourmis
	 */
	public static String next(String ui) {
		StringBuilder resultat = new StringBuilder();
		// On compte la plus grande suite d'un nombre
		int compteur = 1;
		int i;
		for (i = 0; i < ui.length() - 1; i++) {
			if (ui.charAt(i) == ui.charAt(i + 1)) {
				compteur += 1;
			} else {
				resultat.append(compteur);
				resultat.append(ui.charAt(i));
				compteur = 1;
			}
		}
		resultat.append(compteur);
		resultat.append(ui.charAt(i));
		return resultat.toString();
	}
}
