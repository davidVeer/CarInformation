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

- FileIO
- [ ] save function which writes all refuel tanks to a file (object output stream?)
- [ ] load function which loads in all saved data
- [ ] refresh function (recalls load function)  
  <br />

- GUI
- [ ] showing latest measurement on startup
- [ ] table showing every measurement (can be ordered in different ways)
- [ ] tab showing statistics
- [ ] C.R.U.D buttons for new repair job and refuel tank
- [ ] save and load will be done automatically (attempt observer pattern)
- [ ] tab containing different repair job notes (this should be developed and thought out further)

## notes
### general 
- keep class diagrams up to date and versioned in separate version subdirectories in class diagram directory 
(/version1_0, version1_5, /version2_0 etc.). include a .txt file with why and how it was changed
to better analyse and improve future class diagrams.
- figure out a way to decrease code duplication for comparators

### GUI
 - the GUI will be scrapped as I want to turn this into an app for ease of use. 

### Repair job 
figure out how the formatting and functionality (list?, one long string?, hashMap?, separately imported txt files?)

## test notes
### test 1 (statistics calculator)
- [ ] Ordering a list should be done through the calculator rather than both in the calculator and CarData itself
- [ ] Reorder Enum to be in the same order as the refuel tank (consistency)
- [ ] CarData should not contain calculations (should only be used as data storage)
- [ ] Statistics calculator should have an isValid or something to check
  whether it can use a measurement in the calculations (figure out concrete max and min value for every type,
  make sure the values can be applied to modern cars). Filter the invalid values out of the calculation list
- [ ] CarData class should be a Subject that calls its observers to update if something changes.
- [ ] Statistics calculator should have a constructor with the original refuel tanks as parameter,
  this should be linked to an attribute which should only be able to be change if updated (through observer pattern)
- [ ] a catch for empty lists should be added to statistics calculator constructor (throw NullPointerExeption)
- [ ] remove 0 catch in calculateLowest method (these will be caught in the orderByType)
- [ ] set kilometers driven to -1 if one of the two odometer readings is -1
- [ ] change Calculation parrameter "RefuelTanks" to "values" and add a getValues() method that extracts all the InformationType
  values and puts them in an array of doubles. this might also minimise the use of custom comparators.