package objectOrientedDesign.parkingLot;

/**
 * implementation of Vehicle and its child classes
 * 
 * @author Hammad: 29-Jan-2022
 */
public abstract class Vehicle {

	private String licenseNumber;
	private final VehicleType type;
	private ParkingTicket ticket;

	public Vehicle(VehicleType type) {
		this.type = type;
	}

	public void assignParkingTicket(ParkingTicket ticket) {
		this.ticket = ticket;
	}
}

class Car extends Vehicle {
	public Car() {
		super(VehicleType.CAR);
	}
}

class Truck extends Vehicle {
	public Truck() {
		super(VehicleType.TRUCK);
	}
}

class Electric extends Vehicle {
	public Electric() {
		super(VehicleType.ELECTRIC);
	}
}

class Van extends Vehicle {
	public Van() {
		super(VehicleType.VAN);
	}
}

class Motorbike extends Vehicle {
	public Motorbike() {
		super(VehicleType.MOTORBIKE);
	}
}
