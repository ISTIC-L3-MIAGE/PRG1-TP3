
public class Fourmis {
	public static String next(String ui) {
		String resultat = "";
		//On compte la plus grande suite d'un nombre
		int compteur = 1;
		for(int i = 0; i<ui.length()-1;i++) {
			if(ui.charAt(i)==ui.charAt(i+1)) {
				compteur = compteur + 1;
			} else {
				resultat = resultat+compteur + ui.charAt(i);
				compteur = 1;
			}
		}
		resultat = resultat + compteur + ui.charAt(ui.length()-1);
		return resultat;
	}
}
