package assignment03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ElectionSim {

	private String outputFile;
	private int population;
	private Candidate[] candidates;
	private Region[] regions;
	
	public ElectionSim(String inputFile, String outputFile) {
		/* your code */
		this.outputFile = outputFile;
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner (new FileInputStream(inputFile));
		} catch (FileNotFoundException e) {
			System.out.println("File inputFile was not found or could not be opened");
			System.exit(0);
		}
		int i = 0;
		String line = null;
		line = inputStream.next();
		int tempPopulation = inputStream.nextInt();
		this.population = tempPopulation;
		
		line = inputStream.next();
		int totalCandidates = inputStream.nextInt();
		candidates = new Candidate[totalCandidates];
		for (i = 0; i < totalCandidates; i++) {
			line = inputStream.next();
			candidates[i] = new Candidate(line, this.population);
		}
		
		line = inputStream.next();
		int totalRegions = inputStream.nextInt();
		regions = new Region[totalRegions];
		for (i = 0; i < totalRegions; i++) {
			line = inputStream.next();
			int regionIndex = inputStream.nextInt();
			int regionPopulation = inputStream.nextInt();
			regions[i] = new Region(line, regionIndex - 1, regionPopulation, candidates);
		}
		
		inputStream.close();
		
	} // ElectionSim constructor
	
	public void saveData() {
		/* your code */
		Arrays.sort(candidates);
		
		// print output
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter (new FileOutputStream(this.outputFile));
		} catch (FileNotFoundException e) {
			System.out.println("Output file cannot be created");
			System.exit(0);
		}
		
		int i = 0;
		int j = 0;
		for (i = 0; i < candidates.length; i++) {
			outputStream.println(candidates[i].toString());
			// region to string
			for (j = 0; j < regions.length; j++) {
				outputStream.println(regions[j].toString() + candidates[i].toRegionString(j));
			}
			outputStream.println();
			outputStream.println("=================================");
		}
		
		outputStream.close();
	}
	
	public void runSimulation() {
		/* your code */
		int i  = 0;
		
		for (i = 0; i < regions.length; i++) {
			regions[i].start();
			
			try {
				regions[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} // for
		
		this.saveData();
	}
}

