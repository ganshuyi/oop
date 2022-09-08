package assignment04;

public class WordDefinitionPair {
	
	private String word;
	private String definition;
	
	public WordDefinitionPair() {
		this.word = "";
		this.definition = "";
	}
	
	public WordDefinitionPair (String word, String definition) {
		this.word = word;
		this.definition = definition;
	}
	
	public String getWord() {
		return this.word;
	}
	
	public void setWord (String word) {
		this.word = word;
	}
	
	public String getDefinition() {
		return this.definition;
	}
	
	public void setDefinition (String definition) {
		this.definition = definition;
	}
	
	public String toString() {
		return "Word : " + this.getWord() + "\n   Definition : " + this.getDefinition();
	}
}
