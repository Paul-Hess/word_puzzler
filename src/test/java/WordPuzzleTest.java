import org.junit.*;
import static org.junit.Assert.*;

public class WordPuzzleTest {
	@Test 
	public void WordPuzzle_shouldReturnAStringWithVowelsReplaced_String() {
		WordPuzzle testWordPuzzle = new WordPuzzle();
		String actual = testWordPuzzle.generatePuzzle("This is a test puzzle");
		String expected = "Th-s -s - t-st p-zzl-";
		assertEquals(expected, actual);
	}

	@Test 
	public void WordPuzzle_shouldReturnCaseInsensitiveMatches_String() {
		WordPuzzle testWordPuzzle = new WordPuzzle();
		String actual = testWordPuzzle.generatePuzzle("I am testing my regex under wAter");
		String expected = "- -m t-st-ng m- r-g-x -nd-r w-t-r";
		assertEquals(expected, actual);
	}


	@Test 
	public void WordPuzzle_shouldTreatLetterYAsConsonantAtStartOfPhrase_String() {
		WordPuzzle testWordPuzzle = new WordPuzzle();
		String actual = testWordPuzzle.generatePuzzle("Yellow gypsum by the Yonkers bridge");
		String expected = "Y-ll-w g-ps-m b- th- Y-nk-rs br-dg-";
		assertEquals(expected, actual);
	}

	@Test
	public void WordPuzzle_shouldAllowPuzzlesToBeSolved_boolean() {
		WordPuzzle testWordPuzzle = new WordPuzzle();
		String puzzle = "This is a test puzzle";
		String answer = "This is a test puzzle";
		boolean actual = testWordPuzzle.parseWin(puzzle, answer);
		assertEquals(true, actual);
	}

}