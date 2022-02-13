package objectOrientedDesign.parkingLot;

import java.util.HashMap;

/**
 * @author Hammad: 29-Jan-2022
 */
public class ParkingFloor {

	private String name;
	private HashMap<String, HandicappedSpot> handicappedSpots;
	private HashMap<String, CompactSpot> compactSpots;
	private HashMap<String, LargeSpot> largeSpots;
	private HashMap<String, MotorbikeSpot> motorbikeSpots;
	private HashMap<String, ElectricSpot> electricSpots;
	private HashMap<String, CustomerInfoPortal> infoPortals;
	private ParkingDisplayBoard displayBoard;

	public ParkingFloor(String name) {
		this.name = name;
	}

	public void addParkingSpot(ParkingSpot spot) {
		switch (spot.getType()) {
		case HANDICAPPED:
			handicappedSpots.put(spot.getNumber(), ((HandicappedSpot) spot));
			break;
		case COMPACT:
			compactSpots.put(spot.getNumber(), ((CompactSpot) spot));
			break;
		case LARGE:
			largeSpots.put(spot.getNumber(), ((LargeSpot) spot));
			break;
		case MOTORBIKE:
			motorbikeSpots.put(spot.getNumber(), ((MotorbikeSpot) spot));
			break;
		case ELECTRIC:
			electricSpots.put(spot.getNumber(), ((ElectricSpot) spot));
			break;
		default:
			System.out.println("wrong parking spot type!");
		}
	}

	public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
		spot.assignVehicle(vehicle);
		switch (spot.getType()) {
		case HANDICAPPED:
			updateDisplayBoardForHandicapped(spot);
			break;
		case COMPACT:
			updateDisplayBoardForCompact(spot);
			break;
		case LARGE:
			updateDisplayBoardForLarge(spot);
			break;
		case MOTORBIKE:
			updateDisplayBoardForMotorbike(spot);
			break;
		case ELECTRIC:
			updateDisplayBoardForElectric(spot);
			break;
		default:
			System.out.println("wrong parking spot type!");
		}
	}

	private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
		if (this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()) { // if current spot is assigned
			// find another free handicapped spot and assign it to diaplayBoard
			for (String key : handicappedSpots.keySet()) {
				if (handicappedSpots.get(key).isFree()) {
					this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
				}
			}
			this.displayBoard.showEmptySpotNumber();
		}
	}

	private void updateDisplayBoardForCompact(ParkingSpot spot) {
		if (this.displayBoard.getCompactFreeSpot().getNumber() == spot.getNumber()) { // if current spot is assigned
			// find another free handicapped spot and assign it to diaplayBoard
			for (String key : compactSpots.keySet()) {
				if (compactSpots.get(key).isFree()) {
					this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
				}
			}
			this.displayBoard.showEmptySpotNumber();
		}
	}

	private void updateDisplayBoardForLarge(ParkingSpot spot) {
		if (this.displayBoard.getLargeFreeSpot().getNumber() == spot.getNumber()) { // if current spot is assigned
			// find another free handicapped spot and assign it to diaplayBoard
			for (String key : largeSpots.keySet()) {
				if (largeSpots.get(key).isFree()) {
					this.displayBoard.setLargeFreeSpot(largeSpots.get(key));
				}
			}
			this.displayBoard.showEmptySpotNumber();
		}
	}

	private void updateDisplayBoardForMotorbike(ParkingSpot spot) {
		if (this.displayBoard.getMotorbikeFreeSpot().getNumber() == spot.getNumber()) { // if current spot is assigned
			// find another free handicapped spot and assign it to diaplayBoard
			for (String key : motorbikeSpots.keySet()) {
				if (motorbikeSpots.get(key).isFree()) {
					this.displayBoard.setMotorbikeFreeSpot(motorbikeSpots.get(key));
				}
			}
			this.displayBoard.showEmptySpotNumber();
		}
	}

	private void updateDisplayBoardForElectric(ParkingSpot spot) {
		if (this.displayBoard.getElectricFreeSpot().getNumber() == spot.getNumber()) { // if current spot is assigned
			// find another free handicapped spot and assign it to diaplayBoard
			for (String key : electricSpots.keySet()) {
				if (electricSpots.get(key).isFree()) {
					this.displayBoard.setElectricFreeSpot(electricSpots.get(key));
				}
			}
			this.displayBoard.showEmptySpotNumber();
		}
	}

	public void freeSpot(ParkingSpot spot) {
		spot.removeVehicle();
		switch (spot.getType()) {
		case HANDICAPPED:
			displayBoard.handicappedFreeSpot++;
			break;
		case COMPACT:
			displayBoard.compactFreeSpot++;
			break;
		case LARGE:
			displayBoard.largeFreeSpot++;
			break;
		case MOTORBIKE:
			displayBoard.motorbikeFreeSpot++;
			break;
		case ELECTRIC:
			displayBoard.electricFreeSpot++;
			break;
		default:
			System.out.println("wrong parking spot type!");
		}
	}

}
