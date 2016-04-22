public class WordPuzzle {
	public static String generatePuzzle(String phrase) {
		String regExVowel = "(?i)[aeiou]";
		String regExY = "(?<=\\w)y";
		String replacement = "-";
		String voweledPuzzle = phrase.replaceAll(regExVowel, replacement);
		String puzzled  = voweledPuzzle.replaceAll(regExY, replacement);

		return puzzled;
	}
}