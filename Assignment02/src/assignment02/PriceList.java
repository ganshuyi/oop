package assignment02;

public class PriceList {
	private Oil[][] priceList;
	private int vertical;
	
	public PriceList() {
		this.vertical = 2;
		this.priceList = new Oil[2][2];
	}
	
	public int getVertical() {
		return vertical;
	}
	
	public void setPriceList (int i, int j, Oil oil) {
		this.priceList[i][j] = oil;
		oil.setConsumerPrice(oil.getOilPrice());
	}
	
	public void extendList (int amount) {
		int i, j;
		int newVertical = amount + this.getVertical();
		
		Oil[][] tempList = new Oil[newVertical][2];
		
		for (i = 0; i < this.getVertical(); i++) {
			for (j = 0; j < 2; j++) {
				tempList[i][j] = this.priceList[i][j];
			}
		}
		
		this.vertical = newVertical;
		this.priceList = new Oil[this.vertical][2];
		
		for (i = 0; i < this.getVertical(); i++) {
			for (j = 0; j < 2; j++) {
				this.priceList[i][j] = tempList[i][j];
			}
		}

	} // extendList
	
	public String getRegionInfo (int i) {
		String newLine = "\n";
		return this.priceList[i][0].toString() + newLine + this.priceList[i][1].toString();
	}
	
	public void printList() {
		String[] arr = {" ", "Gasoline", "Diesel"};
		int i, j, length = 0;
		
		for (i = 0; i < this.getVertical(); i++) {
			for (j = 0; j < 2; j++) {
				if (this.priceList[i][j] != null) {
					length = i + 1;
				}
			}
		}
		
		for(i = 0; i < 3; i++) {
			System.out.printf("%13s", arr[i]);
		}
		
		System.out.println();
		System.out.println("=========================================");
		
		for (i = 0; i < length; i++) {
			for (j = 0; j < 3; j++) {
				if (j == 0) {
					String temp = "Region #" + (i + 1);
					System.out.printf("%-13s", temp);
				}
				else
				{
					if (this.priceList[i][j - 1] != null)
						System.out.printf("%13.2f", this.priceList[i][j - 1].getConsumerPrice());
					else
						break;
				}
			}
			System.out.println();
			System.out.println();
		} // for i
			
	} // printList()
	
}
