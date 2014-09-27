import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class AnagramFinder {
	private final File fullWordFile = new File("src/wordlist.txt");
	private final Map<AnagramWord, String> anagramList = new HashMap<AnagramWord, String>();

	public Map<AnagramWord, String> findAnagrams(File wordFile) {
		List<AnagramWord> wordList = extractWords(wordFile);
		
		for (AnagramWord word : wordList) {
			
		}
		
		return anagramList;
	}


	private List<AnagramWord> extractWords(File wordFile) {
		Scanner scanner = null;
		List<AnagramWord> wordList = new ArrayList<AnagramWord>();
		try {
			scanner = new Scanner(wordFile);
			while(scanner.hasNext()) {
				wordList.add(new AnagramWord(scanner.next()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return wordList;
	}
}
