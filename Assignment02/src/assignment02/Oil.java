package assignment02;

public abstract class Oil {
	private String company;
	private String oilType;
	private double consumerPrice;
	
	public Oil() {
		this.company = "";
		this.oilType = "";
		this.consumerPrice = 0;
	}
	
	public Oil (String company, String oilType) {
		this.company = company;
		this.oilType = oilType;
		this.consumerPrice = 0;
	}
	
	public double getConsumerPrice() {
		return this.consumerPrice;
	}
	
	public void setConsumerPrice(double consumerPrice) {
		this.consumerPrice = consumerPrice;
	}
	
	public String toString() {
		String newLine = "\n";
		return ("Company		: " + this.company + newLine +"Oil type	: " + this.oilType + newLine);
	}
	
	public abstract double getOilPrice();

}
