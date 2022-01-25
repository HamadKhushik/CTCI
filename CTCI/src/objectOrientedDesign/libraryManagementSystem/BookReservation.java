/**
 * 
 */
package objectOrientedDesign.libraryManagementSystem;

import java.util.Date;

/**
 * BookReservation, BookLending and Fine classes
 * 
 * @author Hammad: 24-Jan-2022
 */
public class BookReservation {

	private Date creationDate;
	private ReservationStatus status;
	private String bookItemBarCode;
	private String memberId;

	public String getMemberId() {
		return memberId;
	}

	public static BookReservation fetchReservationDetails(String barcode) {
		System.out.println("No Reservatoin details");
		return null;
	}
}

class BookLending {
	private Date creationDate;
	private Date dueDate;
	private Date returnDate;
	private String bookItemBarcode;
	private String memberId;

	public static boolean lendBook(String barcode, String memberId) {
		System.out.println("Returning false from lendBook() from Class BookLending");
		return false;
	}

	public static BookLending fetchLendingDetails(String barcode) {
		System.out.println("returning null from BookLending() in class BookLending");
		return null;
	}

	public Date getDueDate() {
		return dueDate;
	}

}

class Fine {
	private Date creationDate;
	private double bookItemBarcode;
	private String memberId;

	public static void collectFine(String memberId, long days) {
		System.out.println("fine collected");
	}
}
