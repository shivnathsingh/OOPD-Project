Information about each File-- SqlUtil.java, App.java and Payment.java


----> SqlUtil.java file.
To run this file:-
	
	Install MySQL in your system and download a SQLyog software that makes it easy to create and visualize tables in the database.
	Install JDK on the system, if do not have.
	Open vscode, import necessary libraries and create a new file named 'SqlUtil.java'. Connect the file with MySQL database 
	using 5 simple steps using code. 
	
	


----> Payment.java file.
File Content:-
	This file contains the necessary components of OOPS concept like abstraction, polymorphism for pay method in payment class, 
	inheritance by extending payment class and encapsulation by making the variables private and protected.
 

----> App.java file.
To run this file:-
        Open vscode, import necessary libraries and create a new file named 'App.java'.
	Install JDK on the system, if do not have.
	Connect this 'App.java' file with database by calling the SqlUtil.java file. Code the program, including features and 
	classes of payment.java.
	Run the 'App.java' file and give inputs whereever required in the output terminal and the outputs will
	be displayed on the terminal itself.
	
	



Information about Database: MySQL SQLyog

----> Database Name- "food_database":
	This database is created in Sqlyog and consists of tables that contains different attributes of different datatypes.
	The database can be viewed by opening the SQLyog in your system --> double click on "food_database"(On the left panel 
	of the software interface)--> double click on 'Tables' ---> table names appear --> double click on table names to view
	the tables.

	Tables Content:
	1. address table attributes- Address(varchar, Primary Key), coordinate(integer) 
	2. city table attributes- city_name(varchar), city_id(varchar, Primary Key)
	3. city_restaurent table attributes- city_id(varchar), restaurent_id(varchar)
	4. item table attributes- item_id(varchar, Primary Key), item_name(varchar), price(integer)
	5. login table attributes- username(varchar),phone_no(varchar, Primary Key), address(varchar), password(varchar)
	6. restaurent table attributes- restaurent_id(varchar, Primary Key), restaurent_name(varchar),coordinate(integer)
	7. restaurent_item table attributes- restaurent_id(varchar),item_id(varchar)
	8. wishlist table attributes- items(varchar)
