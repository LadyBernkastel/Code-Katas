import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.Map;

import org.junit.Test;


public class AnagramFinderTest {
	private final File shortWordFile = new File("src/shortwordlist.txt");
	private final File noMatchesFile = new File("src/nomatchingwordlist.txt");
	private final File fullWordFile = new File("src/wordlist.txt");
	private Map<AnagramWord, String> anagrams;
	
	@Test
	public void findsAnagramsInShortWordFile() {
		anagrams = AnagramFinder.findAnagrams(shortWordFile);
		thenTheSizeOfTheAnagramListIs(11);
	}
	
	@Test
	public void findsNoAnagramsInFileWithNoMatches() {
		anagrams = AnagramFinder.findAnagrams(noMatchesFile);
		thenTheSizeOfTheAnagramListIs(0);
	}
	
	@Test
	public void findsAnagramsInFullWordFile() {
		anagrams = AnagramFinder.findAnagrams(fullWordFile);
		thenTheSizeOfTheAnagramListIs(20683);
	}
	
	private void thenTheSizeOfTheAnagramListIs(int size) {
		assertThat(anagrams.size(), is(size));
	}
	
}
