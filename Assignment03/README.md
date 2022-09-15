# **Programming Assignment #3**

### **Goal:**
Design a vote simulator that predicts the voting results of an election. The number of votes received by each candidate should be generated randomly.
- The concept of information hiding must be applied in this assignment, but privacy leak may be ignored. Variable and method can be added/changed in the template.

<br/>

`Class` Candidate
- Candidate class saves each candidates info & has 3 instance variables
    - String name: name of candidate
    - int numVotes: number of votes received by candidates
    - Votes[] votes: an array that stores the received votes
- a constructor that takes 2 arguments (String name, int maxVotes)
    - the 1st argument is set as candidate's name
    - after generating the array of type Vote, set the size of the array to maxVotes. this is the max number of votes a candidate can obtain
- Candidate class implements Comparable. Compare each candidate using the number of votes they received (numVotes) and sort the candidates in ascending order (of number of votes)
- toString method returns a string with name & total votes of candidate
- toRegionString()  method accepts user input for int regionNum (region index) and returns the number of votes obtained in that region
- create Vote class (inner class of Candidate class). Vote class must be declared private
    - Vote class increase the size of votes array every time the candidate receives a vote
    - Vote class has one instance variable (int regionNum: index of region)
    - make a constructor that takes 1 argument (int regionNum)
    - addVote() method takes int regionNum as argument. this method creates a Vote object and add the object into the candidate's votes array
        - addVote() method must be synchronized since it accesses multiple threads at the same time
- add callAddVotes() method in the Candidate class. this method invokes addVote() method of the Vote class. allAddVotes() method takes int regionNum as argument 

<br/>

`Class` Region
- Region class stores the information of voting region. Region class uses threads, so it either implements Runnable interface or inherits Thread class (using extends)
- Region class has 4 instance variables
    - String regionName: name of region
    - int regionNum: region index number
    - int population: population of region
    - Candidate[] candidates: array of candidates
- create a constructor that takes all instance variables as arguments
- create generateVotes() method. this method should satisfy the following requirements:
    - using this method, the voters of each region should vote for a random candidate
    - to vote for a random candidate, use Math or Random class and generate a random number (range: 0 ~ total number of candidates)
    - invoke callAddVotes() method to vote for the selected random candidate object 

<br/>

`Class` ElectionSim
- create ElectionSim class that will be used as the vote simulator. This class reads the input text file and carries out vote simulator
- ElectionSim class has 4 instance variables
    - String outputFile: output file path
    - int population: total population of all regions (max number of votes)
    - Candidate[] candidates: array of candidate names
    - Region[] regions: array of voting regions
- create a constructor that takes 2 arguments (String inputFile, String outputFile)
    - String inputFile: input file path
    - String outputFile: output file path
    - the constructor must carry out these actions:
        - set String outputFile from instance variable
        - carry out these actions using inputFile
            - set population from instance variable
            - create Candidate class object and add instance variable to candidates array
            - create Region class object and add instance variable to regions array
- create saveData() method
    - sort candidates array
    - prints result in output file
- create startSimulation() method. this method starts the voting simulation
    - all regions that are created must start
    - regions that are started must wait till all threads stop (use appropriate method that are related to Thread)
    - if all threads end, invoke saveData() method and record voting results in output file

<br/>

`Class` SimTest
- class that executes main method
- the path of input and output file are set as constants
- create object of ElectionSim class by taking input file path and output file path as arguments, then invoke startSimulation() method