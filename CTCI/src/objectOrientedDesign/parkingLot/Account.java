/**
 * 
 */
package objectOrientedDesign.parkingLot;

/**
 * implementation of Account class and child classes
 * 
 * @author Hammad: 29-Jan-2022
 */
public abstract class Account {

	private String userName;
	private String password;
	private AccountStatus status;
	private Person person;

	public boolean resetPassword() {
		System.out.println("Returning false from resetPassword() in Account class");
		return false;
	}
}

class Admin extends Account {

	public boolean addParkingFloor(ParkingFloor parkingFloor) {
		System.out.println("Adding parking floor from addParkingFloor() and returning false");
		return false;
	}

	public boolean addParkingSpot(ParkingFloor parkingFloor, ParkingSpot parkingSpot) {
		System.out.println("Adding parking spot from addParkingSpot() and returning false");
		return false;
	}

	public boolean addParkingDisplayBoard(ParkingFloor parkingFloor, ParkingDisplayBoard displayBoard) {
		System.out.println("Adding Parking Display Board from addParkingDisplayBoard() and returning false");
		return false;
	}

	public boolean addCustomerInfoPanel(ParkingFloor parkingFloor, CustomerInfoPanel infoPanel) {
		System.out.println("Adding Customer Info Panel from addCustomerInfoPanel() and returning false");
		return false;
	}

	public boolean addEntrancePanel(EntrancePanel entrancePanel) {
		System.out.println("Adding Entrance Panel from addEntrancePanel() and returning false");
		return false;
	}

	public boolean addExitPanel(ExitPanel exitPanel) {
		System.out.println("Adding Exit Panel from addExitPanel() and returning false");
		return false;
	}
}

class ParkingAttendent extends Account {

	public boolean processTicket(String ticketNumber) {
		System.out.println("Processing Ticket from processTicket() and returning false");
		return false;
	}
}