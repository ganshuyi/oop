# **Programming Assignment #2**

### **Goal:**
Create a **price list program** that records the price of oil for different regions (grouped by type of oil)
- Assume the following situation:
    - price of gasoline = supply price + supply price * % of value-added tax (VAT)
    - price of diesel = supply price + environmental tax + supply price * % of value-added tax (VAT)
    - the value-added tax (VAT) for each state/region is different

<br/>

`Class` Oil
- private String company
- private String oilType
- private double consumerPrice
- a constructor that takes Company, oilType as arguments (consumerPrice is initialized to 0)
- getter of consumerPrice (accessor)
- setter of consumerPrice (mutator)
- toString() method tht returns the supplier name and oil type as String type
    - format
        - company:
        - oil type:
- double getOilPrice(): abstract class (calculate the consumer's price)

<br/>

`Class` Gasoline
- Extends Oil 
- private int price (supplier price)
- private double VAT (rate of value-added tax)
- a constructor that takes price, company as arguments 
    - initialize the value of price and company using the value given in arguments
    - intialize oilType to gasoline
    - initialize VAT to an arbitrary integer between 1~30 / 100 (eg. 25/100)
- write method getOilPrice() tht returns price
- toString() method tht returns supplier's name, oil type, supply price as String type
    - format
        - company:
        - oil type:
        - supply price:

`Class` Diesel
- Extends Oil
- private int price (supplier price)
- private double VAT <-- generated randomly (N%, where N is an int between 1~30)
- private double envTax <-- initialized to 500 when constructor is called
- a constructor tht takes price, company as arguments
    - initialize values of price and company using the values given as arguments
    - oilType is initialized as diesel
    - initialize VAT to an arbitrary integer between 1~30 / 100 (eg. 25/100)
    - envTax is initialized to 500
- write getOilPrice() method tht returns price
- toString() method tht returns supplier's name, oil type, supply price as String type
    - format
        - company:
        - oil type:
        - supply price:

<br/>

`Class` FullArrayException
- FullArrayException is an exception class
- occurs when ListArray is Full
    - no-argument constructor
    - constructor that takes a String type argument
    - when Exception occurs, print the following:
        - List is full!
        - Try to expand..
        - How much will it expand?

<br/>

`Class` PriceList
- private Oil[][] pricelist (2d array class type tht saves object)
- private int vertical (vertical length of array)
- priceList's row is the regions; 1st column is gasoline, 2nd column is diesel
- no-argument constructor
    - vertical is initialized as 2
    - priceList is declared as 2x2 array
- getter of vertical (accessor)
- setPriceList
    - parameter : int i , int j, Oil oil
    - return : void
    - initialize oil object at priceList[i][j] and initialize consumer price (setOilPrice())
- extendList
    - parameter : int amount
    - return : void
    - increase the rows of priceList by the value of amount argument (eg., if amount = 2, then the existing priceList[2][2] will be expanded to priceList[4][2])
- method getRegionInfo()
    - parameter : int i
    - return the region's information in String type using toString() method
- method printList()
    - parameter, return : void
    - print the whole priceList

<br/>

`Class` PriceListApp
- `main` method
    - get input using Scanner
    - create PriceList object
    - create main menu
        1. Add a oil to price list
        2. View Region Information
        3. Print the entire price list
        4. Exit the program
    - when numbers other than 1~4 is entered, print "insert 1~4" 
- **Case 1:** Add oil to price list
    - use try-catch blocks; when list is full, throw an exception
    - when handling exception, expand the list and print "list is extended"
    - get user input about oil information using Scanner
    - get gasoline, diesel inputs in sequence and initialize them -> print "added" after initialization
- **Case 2:** View region information
    - get user input for region's index 
    - print region's information
- **Case 3:** Print entire price list
    - print price list
- **Case 4:** Exit program
    - print "Exit application" and end program
