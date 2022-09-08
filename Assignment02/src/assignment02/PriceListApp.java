package assignment02;

import java.util.Scanner;

public class PriceListApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard =  new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		PriceList thisPriceList = new PriceList();
		int input = 0;
		int rowCount = 2;
		int index = 0;
		
		do {
			showMainMenu();
			System.out.print("Choose a menu : ");
			
			input = keyboard.nextInt();
			
			switch(input) {
			case 1:
				String gCompany, dCompany;
				int gPrice, dPrice;
				index++;
				
				try {
					if (index > rowCount)
						throw new FullArrayException();
				}
				catch (FullArrayException e){
					int extendSize = 0;
					
					System.out.println(e.getMessage());
					
					extendSize = keyboard.nextInt();
					thisPriceList.extendList(extendSize);
					rowCount += extendSize;
					
					System.out.println("List is extended.");
					System.out.println();
				}
				
				// get user input for gasoline
				System.out.print("Company : ");
				gCompany = scan.nextLine();
				gCompany.trim();
				
				System.out.print("Supply price : ");
				gPrice = keyboard.nextInt();
				
				Gasoline newGasoline = new Gasoline(gPrice, gCompany);
				thisPriceList.setPriceList(index - 1, 0, newGasoline);
				System.out.println("Gasoline added.\n");
				
				// get user input for diesel
				System.out.print("Company : ");
				dCompany = scan.nextLine();
				dCompany.trim();
				
				System.out.print("Supply price : ");
				dPrice = keyboard.nextInt();
				
				Diesel newDiesel = new Diesel(dPrice, dCompany);
				thisPriceList.setPriceList(index - 1, 1, newDiesel);
				System.out.println("Diesel added.\n");
				
				break; // case 1
				
			case 2:
				int viewIndex = 0;
				
				System.out.print("Region number to view (1~total): ");
				viewIndex = keyboard.nextInt();
				
				if (viewIndex > index) {
					System.out.println("Out of index.");
					System.out.println();
					break;
				}
				
				System.out.println();
				System.out.println(thisPriceList.getRegionInfo(viewIndex - 1));
				
				break; // case 2
				
			case 3:
				thisPriceList.printList();
				break;
				
			case 4:
				System.out.println("Exit application.");
				System.exit(0);
				break;
				
			default:
				System.out.println("Insert 1~4\n");
				break;
				
			} // switch 
		} while (true);
		
		
	} // main
	
	private static void showMainMenu() {
		System.out.println("================Main Menu================");
		System.out.println("(1) Add oil to price list");
		System.out.println("(2) View region information");
		System.out.println("(3) Print the entire price list");
		System.out.println("(4) Exit program");
		System.out.println("=========================================");
	}
}
