import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AnagramFinder {
	private final File fullWordFile = new File("src/wordlist.txt");

	public List<String> findAnagrams(File wordFile) {
		ArrayList<String> anagramList = new ArrayList<String>();
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
