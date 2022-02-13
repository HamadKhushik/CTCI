package objectOrientedDesign.amazonShoppingSystem;

import java.util.Date;
import java.util.List;

/**
 * File containing classes for Shipment, ShipmentLog and Notifications
 * 
 * @author Hammad: 06-Feb-2022
 */
public class Shipment {
	private String shipmentNumber;
	private Date shipmentDate;
	private Date estimatedArrival;
	private String shipmentMethod;
	private List<ShipmentLog> shipmentLogs;

	public boolean addShipmentLog(ShipmentLog shipmentLog) {
		System.out.println("Returning false from addShipmentLog() in Shipment class");
		return false;
	}
}

class ShipmentLog {
	private String shipmentNumber;
	private Date shipmentDate;
	private ShipmentStatus status;
}

abstract class Notification {
	private int notificationId;
	private Date notificationDate;
	private String content;

	public boolean sendNotification(Account account) {
		System.out.println("Returning false from sendNotification() in Notification class");
		return false;
	}
}
