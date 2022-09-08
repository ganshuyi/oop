package assignment02;

import java.util.Random;

public class Gasoline extends Oil {
	private int price;
	private double VAT;
	
	public Gasoline() {
		super();
		this.price = 0;
		this.VAT = 0;
	}
	
	public Gasoline (int price, String company) {
		super (company, "gasoline");
		this.price = price;
		
		Random rand = new Random();
		int randomInt = 0;
		
		do {
			randomInt = rand.nextInt(31);
			if (randomInt != 0)
				break;
		} while (randomInt == 0);
		
		this.VAT = randomInt / 100.0;
	}
	
	public double getOilPrice() {
		return this.price + (this.price * this.VAT);
	}
	
	public String toString() {
		String newLine = "\n";
		return (super.toString() + "Supply price	: " + this.price + newLine);
	}
}
