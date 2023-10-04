/**
 * @author Antonella Atterey <antonella.atterey@etudiant.univ-rennes1.fr>
 * @author Ezan Tahi <ezan.tahi@etudiant.univ-rennes1.fr>
 * @class L3 MIAGE 2023/2024
 */

package fr.istic.prg1.tp3;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

abstract class FileManager {
	private final static Scanner stdIn = new Scanner(System.in);
	
	/*
	 * Lis le nom d'un fichier au clavier, crée et retourne un flux
	 * lecture du fichier saisi.
	 * 
	 * @return flux de lecture du fichier
	 */
	public static InputStream openInputFile() {
		InputStream fileStream = null;
		while (fileStream == null) {
			System.out.print("Saisissez le nom du fichier: ");
			String filename = stdIn.nextLine();
			try {
				File file = new File("src/" + filename);
				fileStream = new FileInputStream(file.getAbsolutePath());
			} catch (FileNotFoundException e) {
				System.out.println("\nATTENTION: Le fichier " + filename + " n'a pas été trouvé.");
			}
		}
		return fileStream;
	}
}
