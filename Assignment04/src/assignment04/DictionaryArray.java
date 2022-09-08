package assignment04;

import java.util.ArrayList;

public class DictionaryArray implements Dictionary {
	
	private ArrayList <WordDefinitionPair> DicList;
	
	public DictionaryArray() {
		DicList = new ArrayList<WordDefinitionPair>();
	}
	
	public ArrayList <WordDefinitionPair> getDicList() {
		return this.DicList;
	}
	
	public boolean isEmpty() {
		return this.DicList.isEmpty();
	}
	
	public void insertEntry (String word, String definition) 
			throws AlreadyExistInDicException 
	{		
			WordDefinitionPair temp = new WordDefinitionPair(word, definition);
			
			if (this.DicList.contains(temp))
				throw new AlreadyExistInDicException();
			
			this.DicList.add(temp);
	}
	
	public void getDefinition (String word) 
			throws EmptyException, NotInDicException
	{
		if (this.DicList.isEmpty())
			throw new EmptyException();
		
		boolean noWord = true;
		
		for (WordDefinitionPair a: DicList) {
			if (a.getWord().equals(word)) {
				System.out.println(a.getWord() + " means : " + a.getDefinition());
				noWord = false;
				break;
			}
		} // for
		
		if (noWord)
			throw new NotInDicException();
	}
	
	public void removeWord (String word) 
			throws EmptyException, NotInDicException
	{
		if (this.DicList.isEmpty())
			throw new EmptyException();
		
		boolean noWord = true;
		
		for (WordDefinitionPair a: DicList) {
			if (a.getWord().equals(word)) {
				this.DicList.remove(a);
				noWord = false;
				break;
			}
		} // for
		
		if (noWord)
			throw new NotInDicException();
	}
	
	public void printWords() throws EmptyException 
	{
		if (this.DicList.isEmpty())
			throw new EmptyException();
		int i = 1;
		for (WordDefinitionPair a: DicList) {
			System.out.println(i + ". " + a.getWord());
			i++;
		}
	}
	
	public void printAll() throws EmptyException
	{
		if (this.DicList.isEmpty())
			throw new EmptyException();
		
		for (WordDefinitionPair a: DicList) {
			System.out.println("*****************************************");
			System.out.println("Word : " + a.getWord());
			System.out.println("Definition : " + a.getDefinition());
		}
	}
	
	public String toString() {
		String list = "", temp = "";
		int i = 1;
		
		for (WordDefinitionPair a: DicList) {
			temp = i + ". " + a.toString() + "\n";
			list += temp;
			i++;
		}
		return list;
	}
	
} // DictionaryArray
