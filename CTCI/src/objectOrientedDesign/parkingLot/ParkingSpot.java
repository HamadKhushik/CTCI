package objectOrientedDesign.parkingLot;

/**
 * Implementation of Parking spot and its child classes
 * 
 * @author Hammad: 29-Jan-2022
 */
public abstract class ParkingSpot {

	private String number;
	private boolean free;
	private Vehicle vehicle;
	private final ParkingSpotType type;

	public ParkingSpot(ParkingSpotType type) {
		this.type = type;
	}

	public boolean isFree() {
		System.out.println("Returning false from isFree() in ParkingSpot class");
		return free;
	}

	public boolean assignVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		free = false;
	}

	public boolean removeVehicle() {
		this.vehicle = null;
		free = true;
	}

	public ParkingSpotType getType() {
		return type;
	}

	public String getNumber() {
		return number;
	}

}

class HandicappedSpot extends ParkingSpot {
	public HandicappedSpot() {
		super(ParkingSpotType.HANDICAPPED);
	}
}

class CompactSpot extends ParkingSpot {
	public CompactSpot() {
		super(ParkingSpotType.COMPACT);
	}
}

class LargeSpot extends ParkingSpot {
	public LargeSpot() {
		super(ParkingSpotType.LARGE);
	}
}

class MotorbikeSpot extends ParkingSpot {
	public MotorbikeSpot() {
		super(ParkingSpotType.MOTORBIKE);
	}
}

class ElectricSpot extends ParkingSpot {
	public ElectricSpot() {
		super(ParkingSpotType.ELECTRIC);
	}
}