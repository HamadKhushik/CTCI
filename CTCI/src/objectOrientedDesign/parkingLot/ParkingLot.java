package objectOrientedDesign.parkingLot;

import java.util.HashMap;

/**
 * class representing the whole parking lot. There will only be one instance of
 * this class. This is enforced using the singleton design pattern
 * 
 * @author Hammad: 29-Jan-2022
 */
public class ParkingLot {
	private String name;
	private Address address;
	private ParkingRate parkingRate;

	private int compactSpotCount;
	private int largeSpotCount;
	private int motorbikeSpotCount;
	private int electricSpotCount;
	private final int maxCompactCount;
	private final int maxLargeCount;
	private final int maxMotorbikeCount;
	private final int maxElectricCount;

	private HashMap<String, EntrancePanel> entrancePanels;
	private HashMap<String, ExitPanel> exitPanels;
	private HashMap<String, ParkingFloor> parkingFloors;

	private HashMap<String, ParkingTicket> activeTickets; // all active parking tickets

	private static ParkingLot parkingLot = null; // to enforce singleton pattern

	// private constructor to restrict for singleton
	private ParkingLot() {
		// initialize all the variables
	}

	// static method to get the singleton instance
	public static ParkingLot getInstance() {
		if (parkingLot == null) {
			parkingLot = new ParkingLot();
		} else
			return parkingLot;
	}

	// following method is synchronised to allow multiple entrances to issue the
	// parking ticket without interfering with each other
	public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException {
		if (this.isFull(vehicle.getType())) {
			throw new ParkingFullException();
		}
		ParkingTicket ticket = new ParkingTicket();
		vehicle.assignParkingTicket(ticket);
		ticket.saveInDB();
		// if ticket is successfully saved in DB, increment the parking spot count
		this.incrementSpotCount(vehicle.getType());
		this.activeTickets.put(ticket.getTicketNumber(), ticket);
		return ticket;
	}

	public boolean isFull(VehicleType type) {
		if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
			return largeSpotCount >= maxLargeCount;
		}

		if (type == VehicleType.MOTORBIKE) {
			return motorbikeSpotCount >= maxMotorbikeCount;
		}

		if (type == VehicleType.CAR) {
			return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
					+ maxElectricCount);
		}
	}

	public boolean isFull() {
		for (String key : parkingFloors.keySet()) {
			if (!parkingFloors.get(key).isFull()) {
				return false;
			}
		}
		return true;
	}

	private boolean incrementSpotCount(VehicleType type) {
		if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
			largeSpotCount++;
		} else if (type == VehicleType.MOTORBIKE) {
			motorbikeSpotCount++;
		} else if (type == VehicleType.CAR) {
			if (compactSpotCount < maxCompactCount) {
				compactSpotCount++;
			} else {
				largeSpotCount++;
			}
		} else { // electric car
			if (electricSpotCount < maxElectricCount) {
				electricSpotCount++;
			} else if (compactSpotCount < maxCompactCount) {
				compactSpotCount++;
			} else {
				largeSpotCount++;
			}
		}
	}

	public void addParkingFloor(ParkingFloor parkingFloor) {
		/* store in DB */
	}

	public void addEntrancePanel(EntrancePanel entrancePanel) {
		/* store in DB */
	}

	public void addExitPanel(ExitPanel exitPanel) {
		/* store in DB */
	}

}
