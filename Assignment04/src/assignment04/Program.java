package assignment04;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DictionaryArray dicArray = new DictionaryArray();
		
		int input = 0;
		String word, definition, junk;
		Scanner keyboard = new Scanner(System.in);
		
		do {
			showMenu();
			System.out.print("Choose a menu : ");
			input = keyboard.nextInt();
	
			switch(input) {
			case 1:
				System.out.print("Word : ");
				junk = keyboard.nextLine();
				word = keyboard.nextLine();
				
				System.out.print("Definition : ");
				definition = keyboard.nextLine();
				
				try {
					dicArray.insertEntry(word, definition);
					System.out.println("Word is successfully added");
				} 
				catch (AlreadyExistInDicException e) {
					System.out.println(e.getMessage());
				}
				finally {
					System.out.println();
				}
				
				break;
				
			case 2:
				System.out.print("Word to search for : ");
				junk = keyboard.nextLine();
				word = keyboard.nextLine();
				
				try {
					dicArray.getDefinition(word);
				}
				catch (EmptyException e) {
					System.out.println(e.getMessage());
				}
				catch (NotInDicException e) {
					System.out.println(e.getMessage());
				}
				finally {
					System.out.println();
				}
				
				break;
			
			case 3:
				try {
					dicArray.printWords();
				}
				catch (EmptyException e) {
					System.out.println(e.getMessage());
				}
				finally {
					System.out.println();
				}
				
				break;
			
			case 4:
				System.out.print("Word to be removed : ");
				junk = keyboard.nextLine();
				word = keyboard.nextLine();
				
				try {
					dicArray.removeWord(word);
					System.out.println("\"" + word + "\" is successfully removed");
				}
				catch (EmptyException e) {
					System.out.println(e.getMessage());
				}
				catch (NotInDicException e) {
					System.out.println(e.getMessage());
				}
				finally {
					System.out.println();
				}
				
				break;
				
			case 5:
				try {
					dicArray.printAll();
				}
				catch (EmptyException e) {
					System.out.println(e.getMessage());
				}
				finally {
					System.out.println();
				}
				
				break;
				
			case 6:
				System.out.print("Enter file name : ");
				junk = keyboard.nextLine();
				String file = keyboard.next();
				PrintWriter outputStream = null;
				
				try {
					outputStream = new PrintWriter(new FileOutputStream (file));
					
					outputStream.println(dicArray.toString());
					System.out.println("Saved as " + file);
				}
				catch (FileNotFoundException e) {
					System.out.println("File could not be created");
					System.out.println("Aborting program");
					System.exit(0);
				}
				outputStream.close();
				System.out.println("Exit program");
				System.exit(0);
				break;
				
			default:
				System.out.println("Enter 1~6");
				System.out.println();
				break;
				
			} // switch
		} while (true);
		
	} // main
	
	public static void showMenu() {
		System.out.println("================Main Menu================");
		System.out.println("(1) Add a word to dictionary");
		System.out.println("(2) Show definition of word");
		System.out.println("(3) Show word list");
		System.out.println("(4) Remove word");
		System.out.println("(5) Print all content");
		System.out.println("(6) Exit program");
		System.out.println("=========================================");
	}
	
} // program
