package assignment03;

public class Candidate /* your code */ implements Comparable {

	private String name;
	private int numVotes = 0;
	private Vote[] votes;
	
	public Candidate(/* your code */String name, int maxVotes) {
		/* your code */
		this.name = name;
		votes = new Vote[maxVotes];
	}
	
	public String toString() {
		/* your code */
		String newLine = "\n";
		return "------------Candidate------------" + newLine + 
				"Name: " + this.name + newLine + 
				"Total Votes: " + this.numVotes;
	}
	
	public int toRegionString(/* your code */int regionNum) {
		/* your code */
		int i = 0;
		int voteCount = 0;
		for (i = 0; i < this.numVotes; i++) {
			if (this.votes[i].regionNum == regionNum)
				voteCount++;
		}
		return voteCount;
	}
	
	public void callAddVotes(/* your code */int regionNum) {
		/* your code */
		Vote tempVote = this.new Vote(0);
		tempVote.addVote(regionNum);
	}
	
	@Override
	public int compareTo(Object obj) {
		/* your code */
		if (obj == null) 
			throw new NullPointerException("Object is null");
		if (!this.getClass().equals(obj.getClass()))
			throw new ClassCastException ("Object is not of the same type");
		
		Candidate temp = (Candidate) obj;
		if (this.numVotes > temp.numVotes)
			return -1;
		else if (this.numVotes == temp.numVotes)
			return 0;
		else
			return 1;
	}
	
	private class Vote {

		private int regionNum;
		
		public Vote(/* your code */int regionNum) {
			/* your code */
			this.regionNum = regionNum;
		}
		
		public /* your code */synchronized void addVote(/* your code */int regionNum) {
			/* your code */
			Vote tempVote = new Vote(regionNum);
			Candidate.this.votes[Candidate.this.numVotes] = tempVote;
			Candidate.this.numVotes++;
		}
	}
}
