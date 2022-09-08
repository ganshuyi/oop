package assignment03;
import java.util.Random;

public class Region extends Thread{

	private String regionName;			// The name of the region
	private int regionNum;			// The number of the region
	private int population;			// The population of the region
	private Candidate[] candidates;	// An array of the candidates of the election
	
	public Region(/* your code */String regionName, int regionNum, int population, Candidate[] candidates) {
		/* your code */
		this.regionName = regionName;
		this.regionNum = regionNum;
		this.population = population;
		this.candidates = candidates;
	}
	
	public String getRegionName() {
		/* your code */
		return this.regionName; 
	}
	
	public int getRegionNum() {
		/* your code */
		return this.regionNum;
	}
	
	public String toString() {
		return this.regionName + ": ";
	}
	
	public void generateVotes() {
		/* your code */
		int i = 0;
		Random rand = new Random();
		int randInt = 0;
		
		for (i = 0; i < this.population; i++) {
			randInt = rand.nextInt(candidates.length);
			candidates[randInt].callAddVotes(this.getRegionNum());
		}
		
	}
	
	public void run() {
		/* your code */
		this.generateVotes();
	}
	
}
