import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class AnagramFinder {

	public static Map<AnagramWord, String> findAnagrams(File wordFile) {
		Map<AnagramWord, String> anagramList = new HashMap<AnagramWord, String>();
		List<AnagramWord> wordList = extractWords(wordFile);
		
		for (AnagramWord word : wordList) {
			if (anagramList.containsKey(word)) {
				String anagram = anagramList.get(word);
				anagram = anagram + " " + word.display();
				anagramList.put(word, anagram);
			} else {
				anagramList.put(word, word.display());
			}
		}

		for (Iterator<String> it = anagramList.values().iterator(); it.hasNext();) {
			String word = it.next();
			if(!wordHasAnagrams(word)) {
				it.remove();
			}
		}
		return anagramList;
	}


	private static boolean wordHasAnagrams(String word) {
		return word.contains(" ");
	}


	private static List<AnagramWord> extractWords(File wordFile) {
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
