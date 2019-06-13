# RentalBike

RentalBike runs as a simple Java Application. When it starts, it displays an 
option menu which allows you to choose certain actions, such as:
- Insert a new User: Each rental is associated with a client, and one client can be associated to many rentals.
- Rent a bike: Lets you rent a new bike, where you can choose between some rental options (hourly, weekly , dayly or even a special promotion)
- Calculate rental costs: you can ask for the current day's charges for some rental, or you can estimate charged for a specific date.
            
About the application's logic, I'm using three design patterns
 - Singleton: for the Platform (which manages the main functions), and for the Menu that communicates with the user
 - Abstract Factory: in order to generate the rentals.
 - Composition: in order to relate all the different types of rental options.
          
For the tests, the system checks the correct generation of charges for all rental types 
and what would happen if you were to add more rentals or include fewer rentals to the Family Promotion than is allowed
          
          
          
