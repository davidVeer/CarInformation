# Car information tracker
## introduction of the project
This project was set up to keep track of the fuel economy, and cost 
of my vintage VW Beetle. The application is going to run off of a GUI and
will make use of FileIO for loading in the data (this might be changed to a database if required in the future). 
everything is hand coded as I wanted to challenge myself to work with things I have a difficult time with like GUI's 
Enums, Interfaces, and auto testing (along with other topics I am likely forgetting).  
I wanted to create a digital way of keeping track of my car's data as well as keeping track of 
certain statistical data as I was calculating everything by hand using: a note pad, pen, and calculator. 

## features

> [!NOTE]
> these boxes should only be ticked after a thorough and dedicated test

The application will have the following statistical features:
- data
- [ ] one central data storage method 
- [ ] separate refuel tank & repair job method  
  <br />

- calculations
- [ ] getting highest values
- [ ] getting lowest values
- [ ] getting/ calculating median values
- [ ] calculating mean/average values
- [ ] calculating mode values (can return multiple values)
- [ ] calculating total (population) values
- [ ] calculating (population) standard deviation
- [ ] calculating (population) variance  
  <br />

- saving functionality/ file IO
- [ ] save function which writes all refuel tanks to a file (object output stream?)
- [ ] load function which loads in all saved data
- [ ] refresh function (recalls load function)  
- [ ] CarData class should be a Subject that calls its observers to update if something changes.
- [ ] Statistics calculator should have a constructor with the original refuel tanks as parameter,
  this should be linked to an attribute which should only be able to be change if updated (through observer pattern)
  <br />


## notes
### general 
- keep class diagrams up to date and versioned in separate version subdirectories in class diagram directory 
(/version1_0, version1_5, /version2_0 etc.). include a .txt file with why and how it was changed
to better analyse and improve future class diagrams.

### GUI
 - the GUI will be scrapped as I want to turn this into an app for ease of use. 

### Repair job 
figure out how the formatting and functionality (list?, one long string?, hashMap?, separately imported txt files?)

## test notes
### test 1 (statistics calculator)
right off the bat I found some pretty glaring issues with code structure and functionality that I barely got to test the 
actual calculation part of the code. I did start writing tests but this was a lot of copy-paste code which I wanted to avoid
so for the next test I will research how to create more solid tests.

below are some things I wanted fix before starting to actually write definitive tests, along with some actual bugs I
somehow managed to find through my still very crude tests.

- [x] Ordering a list should be done through the calculator rather than both in the calculator and CarData itself
- [X] Reorder Enum to be in the same order as the refuel tank (consistency)
- [X] CarData should not contain calculations (should only be used as data storage), except kilometers driven as which needs to be initialised in CarData  
- [X] a catch for empty lists should be added to statistics calculator constructor (throw NullPointerExeption)
- [X] remove 0 catch in calculateLowest method (these will be caught in the orderByType)
- [X] set kilometers driven to -1 if one of the two odometer readings is -1
- [X] Statistics calculator should have an isValid or something to check
  whether it can use a measurement in the calculations (figure out concrete max and min value for every type,
  make sure the values can be applied to modern cars). Filter the invalid values out of the calculation list
- [X] figure out a way to decrease code duplication for comparators
- [X] calculator should make use of an "original" list which all methods use to calculate their statistic

### test 2 (statistics calculator)
overall started with more solid code to test however figuring out a way to write solid tests was difficult.
I wanted to work with randomly generated data that would work reliably when testing code. generating the data was
the easy part but figuring out a way to write a test without reusing the code it's designed to test is more difficult.

- at first, I found a bug where the calculator would remove items from the original list it received which turned out to
be an initialisation error or my part (I didn't know how to properly initialize one arraylist using another)
- another issue I found was the possibility of every value for a given InformationType within the ArrayList<RefuelTank> to be
invalid, I fixed this by throwing a NullPointerException if this was the case.
I am trying to figure out a way t handle this exception in a logical way.
- I also found out that totalValue would always initialise its outcome at 0.0 which is fine enough however it made it 
more prone to allowing errors to pass through as it would just not add a number when the list was empty 

here are some bullet points to improve for the next test or iteration of the class.
- [ ] don't use random data in tests (as a main test, it's still okay to use as a secondary test)
- [ ] restructure Calculator (see diagrams v2_2)