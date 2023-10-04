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
	private static InputStream openInputFile() {
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
	
	/*
	 * Lis les pairs contenu dans un fichier.
	 * 
	 * @return un tableau de pairs sous forme de chaine de caractère
	 * 			Exemple: ["3 8", "1 4", "3 8", "1 3"]
	 */
	public static String[] readFile() {
		InputStream file = openInputFile();
		Scanner scan = new Scanner(file);
		String currentInput = "", totalInput = "";
		do {
			currentInput = scan.nextLine();
			totalInput += currentInput + ";";
		} while (!currentInput.equals("-1"));
		scan.close();
		return totalInput.replace("-1;", "").split(";");
		
	}
}
