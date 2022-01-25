package objectOrientedDesign.libraryManagementSystem;

/**
 * enums and data types for the library management stystem
 * 
 * @author Hammad: 23-Jan-2022
 */
public enum BookFormat {

	HAARDCOVER,
	PAPERBACK,
	AUDIOBOOK,
	EBOOK,
	JOURNAL,
	NEWSPAPER
}

enum BookStatus {

	AVAILABLE,
	RESERVED,
	LOANED,
	LOST
}

enum ReservationStatus {

	WAITING,
	COMPLETED,
	PENDING,
	CANCELLED,
	NONE
}

enum AccountStatus {

	ACTIVE,
	CLOSED,
	CANCELLED,
	BLACKLISTED,
	NONE
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

class Constants {

	public static final int MAX_BOOKS_ISSUED_TO_A_USER = 5;
	public static final int MAX_LENDING_DAYS = 10;
}
