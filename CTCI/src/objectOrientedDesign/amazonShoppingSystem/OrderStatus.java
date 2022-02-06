package objectOrientedDesign.amazonShoppingSystem;

/**
 * File containing all the enums and data types for the shopping system
 * 
 * @author Hammad: 05-Feb-2022
 */
public enum OrderStatus {
	UNSHIPPED,
	PENDING,
	SHIPPED,
	COMPLETED,
	CANCELLED,
	REFUND_APPLIED
}

enum AccountStatus {
	ACTIVE,
	BLOCKED,
	BANNED,
	COMPROMISED,
	ARCHIVED,
	UNKNOWN
}

enum ShipmentStatus {
	PENDING,
	SHIPPED,
	DELIVERED,
	ON_HOLD
}

enum PaymentStatus {
	UNPAID,
	PENDING,
	COMPLETED,
	FILLED,
	DECLINED,
	CANCELLED,
	BANDONED,
	SETTLING,
	SETTLED,
	REFUNDED
}

class Address {
	private String streetAddress;
	private String city;
	private String postcode;
	private String country;
}