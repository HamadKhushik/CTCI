package objectOrientedDesign.libraryManagementSystem;

/**
 * enums and data types for the library management stystem
 * 
 * @author Hammad: 23-Jan-2022
 */
public enum BookFormat {

	Hardcover,
	Paperback,
	Audiobook,
	Ebook,
	Journal,
	NewsPaper
}

enum BookStatus {

	Availble,
	Reserved,
	Checkedout,
	Lost
}

enum ReservationStatus {

	Waiting,
	Completed,
	Pending,
	Canceled,
	None
}

enum AccountStatus {

	Active,
	Closed,
	Cancelled,
	Blacklisted,
	None
}

class Address {

	String streetName;
	String city;
	String postcode;
	String country;
}

class Person {

	String name;
	Address address;
	String email;
	String phone;
}