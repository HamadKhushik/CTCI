/**
 * 
 */
package objectOrientedDesign.parkingLot;

/**
 * file containing all the enums for the parking mangement system
 * 
 * @author Hammad: 28-Jan-2022
 */
public enum VehicleType {

	CAR,
	TRUCK,
	ELECTRIC,
	VAN,
	MOTORBIKE
}

enum ParkingSpotType {

	HANDICAPPED,
	COMPACT,
	LARGE,
	MOTORBIKE,
	ELECTRIC
}

enum AccountStatus {

	ACTIVE,
	BLOCKED,
	BANNED,
	COMPROMISED,
	ARCHIVED,
	UNKNOWN
}

enum ParkingTicketStatus {

	ACTIVE,
	PAID,
	LOST
}

class Address {

	private String streetAddress;
	private String city;
	private String postcode;
	private String country;
}

class Person {

	private String name;
	private Address address;
	private String email;
	private String phone;
}
