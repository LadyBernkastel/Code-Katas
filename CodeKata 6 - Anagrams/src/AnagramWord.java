import java.util.HashMap;


public class AnagramWord {
	private HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();
	private String word;
	
	public AnagramWord(String word) {
		this.word = word;
		extractCharacterList();
	}

	private void extractCharacterList() {
		char[] characters = null;
		word.getChars(0, word.length(), characters, 0);
		for (char c : characters) {
			if (!characterMap.containsKey(c)) {
				characterMap.put(c, 1);
			} else {
				characterMap.put(c, characterMap.get(c) + 1);
			}
		}
	}
	
	public String display() {
		return word;
	}
	
	@Override
	public String toString() {
		return "AnagramWord [word=" + word + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((characterMap == null) ? 0 : characterMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnagramWord other = (AnagramWord) obj;
		if (characterMap == null) {
			if (other.characterMap != null)
				return false;
		} else if (!characterMap.equals(other.characterMap))
			return false;
		return true;
	}
	
	
}
