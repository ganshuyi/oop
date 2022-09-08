package assignment02;

import java.util.Random;

public class Diesel extends Oil {
	private int price;
	private double VAT;
	private double envTax;
	
	public Diesel() {
		super();
		this.price = 0;
		this.VAT = 0;
		this.envTax = 0;
	}
	
	public Diesel (int price, String company) {
		super(company, "diesel");
		this.price = price;
		this.envTax = 500;
		
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
		return this.price + envTax + (this.price * this.VAT);
	}
		
	public String toString() {
		String newLine = "\n";
		return (super.toString() + "Supply price	: " + this.price + newLine); 
	}
}
