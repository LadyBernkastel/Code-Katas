import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;


public class AnagramFinderTest {
	private final File shortWordFile = new File("src/shortwordlist.txt");
	private final File noMatchesFile = new File("src/nomatchingwordlist.txt");
	private AnagramFinder anagramFinder = null;
	
	@Before
	public void beforeTest() {
		anagramFinder = new AnagramFinder();
	}
	
	@Test
	public void findsAnagramsInShortWordFile() {
		Map<AnagramWord, String> anagrams = anagramFinder.findAnagrams(shortWordFile);
		assertThat(anagrams.isEmpty(), Matchers.is(false));
		assertThat(anagrams.values(), containsInAnyOrder("kinship pinkish", "enlist inlets listen silent"));
	}
	
}
