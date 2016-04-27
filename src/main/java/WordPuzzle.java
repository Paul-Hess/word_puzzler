public class WordPuzzle {
	public static String generatePuzzle(String phrase) {
		String regExVowel = "(?i)[aeiou]";
		String regExY = "(?<=\\w)y";
		String replacement = "-";
		String voweledPuzzle = phrase.replaceAll(regExVowel, replacement);
		String puzzled  = voweledPuzzle.replaceAll(regExY, replacement);

		return puzzled;
	}

	public static boolean parseWin(String phrase, String answer) {
		boolean win = false;
		String loweredPhrase = phrase.toLowerCase();
		String loweredAnswer = answer.toLowerCase();
		if(loweredPhrase.equals(loweredAnswer)) {
			win = true;
		}
		return win;
	}
}
