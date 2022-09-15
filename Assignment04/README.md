# **Programming Assignment #4**

### **Goal:**
Create a simple **dictionary** program. A total of 7 files are required:
- AlreadyExistInDicException.java
- NotInDicExcpetion.java
- EmptyException.java
- Dictionary.java
- WordDefinitionPair.java
- DictionaryArray.java
- Program.java

<br/>

Exception Classes
- AlreadyExistsInDicException is an exception class
    - exception occurs when vocab that is taken as input alrd exists in dictionary
        - no-argument constructor
        - constructor that takes a String argument
        - when exception occurs return "this word already exists in dictionary" using getMessage() method
- NotInDicException is an exception class
    - exception occurs when searched vocab doesnt exist in dictionary
        - no-argument constructor
        - constructor that takes a String argument
        - when exception occurs return "this word does not exist in dictionary" using getMessage() method
- EmptyException is an exception class
    - exception occurs when the list that stores vocab is empty
        - no-argument constructor
        - constructor that takes a String argument
        - when exception occurs return "List is empty" using getMessage() method
        - this exception handler must come first before other exception handlers

<br/>

Dictionary
- Dictionary is an interface
    - boolean isEmpty
    - void insertEntry (String word, String definition) throws AlreadyExistsInException
    - void getDefinition (String word) throws EmptyException , NotInDicException
    - void removeWord (String word) throws EmptyException , NotInDicException
    - void printWrods () throws EmptyException
    - void printAll () throws EmptyException

<br/>

`Class` WordDefinitionPair
- private String word
- private String definition
- constructor that takes word and definition as arguments
- getter and setter methods of both instance variables
- implements Dictionary
- private ArrayList\<WordDefinitionPair> DicList (use ArrayList with base type of WordDefinitionPair)
    - implement all methods of ArrayList (isEmpty, add, get, size)
- empty constructor that creates DicList
- DicList getter method
- isEmpty()
    - return true when list is empty
- InsertEntry()
    - parameter: word and its definition
    - check if the word exists in the dictionary, if yes, throw AlreadyExistsInDicException, if not add the word to list
- getDefinition()
    - parameter: word
    - check if word exists in the dictionary, if yes, print its definition, if no, throw NotInDicException
    - throw EmptyException if list is empty
- removeWord()
    - parameter: word
    - check if word exists in dictionary, if no, throw NotInDicException, if yes delete word from list
    - throw EmptyException if list is empty

<br/>

`Class` DictionaryArray
- printWord()
    - prints all words in dictionary
    - throw EmptyException if list is empty
- printAll()
    - print all words in the dictionary and their definitions 
    - throw EmptyException if list is empty

<br/>

`Class` Program
- Main method
- create DictionaryArray object
- use loop to create main menu (switch)
    1. Add a word to dictionary
    2. Show definition of word
    3. Show word list
    4. Remove word
    5. Print all content
    6. Exit program
- if a number besides 1~6 is entered, print "insert 1~6"
- all menus require a try-catch block
- **Case 1**
    - take user input for word and definition and add to dictionary
    - if the word already exists in dictionary then handle exception
    - use insertEntry()
- **Case 2**
    - print the definition of the word tht is taken as input
    - if the word doesnt not exist in the dictionary or if the dictionary is empty, handle exception
    - use getDefinition()
- **Case 3**
    - print word list in dictionary
    - if dictionary is empty, handle exception
    - use printWords()
- **Case 4**
    - find and delete word taken as user input
    - if dictionary is empty or if word does not exist then handle exception
    - use removeWord()
- **Case 5**
    - print all words in the dictionary and their definition
    - if dictionary is empty then handle exception
    - use printAll()
- **Case 6**
    - take output file name as input
    - print dictionary content in text file and end program
    - requires catch block tht handles FileNotFoundException