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

#### initial sorting troubles
a difficult choice I had to make halfway through testing was something I had not considered when setting up the project,
as I personally keep track of both the refuel count and the date I refueled my vehicle I figured these would always be tied together as variables.
however I hadn't considered the possibility that someone might not keep track of how many times they 
refueled their vehicle, or the date they refueled their vehicle.
what this now means is that I have to choose whether I make the calculator require both of these variables, which allows for 
the possibility of "skipping" a refueling (let's say someone might have forgotten to get the receipt, this means they now
cant add that refueling to the list which will also drastically and untruthfully increase the fuel economy for the next
refueling as the gap in distance is unaccounted for), but could also raise issues if the date does not line up with the 
refuel number's position in lineup.
or have only the date required and setting the refuel number based on the order of dates, this simplifies the sorting
but would also raise the issue of not being able to "skip" a refueling like mentioned in previous option.
this also removes the option of having mismatched variables.  

the solution I came up with was the following: 
I wil make a custom comparator that initially sorts by date, if there is no date given it will sort based on the refueling number.
the reason being: if both the date and refueling number match the pre-entered position nothing will change regardless and if they don't 
match the date is likely more reliable. if the refueling is added (for example) at a later date and the date is unknown
the date is set to null and the refueling number is used to place the refueling in the highest likely correct position.
if neither a date nor a refueling number is given (in this case the refueling number is set to -1) the refueling's
location is based on the odometer. 

after the list is sorted the remaining incorrect refueling numbers are corrected (for example any negative numbers or 
relocated refuelings) the main function for this sorting system is optimising the chance of the distance driven (and by 
extension fuel economy) to be correct


#### Todo's for during (of after) testing
- [X] don't use random data in tests (as a main test, it's still okay to use as a secondary test)
- [X] restructure tests (create diagram in diagram v2_2)
- [X] write tests that test: when all values are valid but all are different.
- [X] write tests that test: when all values are invalid.
- [X] write tests that test: when all values are identical (and valid).
- [X] write tests that test: when there are no values (empty list)
- [ ] write tests that test: when about half of the values are valid and the other half is invalid
- [ ] write tests that test: when all values are valid with some identical values
- [ ] write tests that test: when all values are close together 
- [ ] write test that tests: whether no values are removed from the originalList when filtered
- [ ] use total calculation in mean calculation
- [ ] total for (specifically) kilometers driven is last - first valid number (more accurate total this way)
- [ ] for: Liter price, and fuel economy. if any variable in calculation is negative the value should be NaN
- [ ] for kilometers driven: if odometer is lower (or by extention a negative number) the odometer should be set to -1 
  to avoid setting the next invalid driven kilometers
- [ ] sort refuelings by their refuel number before calculating kilometers driven (this allows for new older refuelings to be added)
- [ ] restructure Calculator (see classDiagram/diagrams v2/diagrams v2_2)
- [ ] implement initial sort (for optimal distance driven calculations)
- [ ] add estimated carbon emissions to refueling data
- [ ] add price per kilometer to refueling data
