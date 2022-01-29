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

}
