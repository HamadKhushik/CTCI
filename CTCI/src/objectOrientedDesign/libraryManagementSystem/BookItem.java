package objectOrientedDesign.libraryManagementSystem;

import java.util.Date;

/**
 * BookItem and Rack classes
 * 
 * @author Hammad: 24-Jan-2022
 */
public class BookItem {
	private String barcode;
	private boolean isReferenceOnly;
	private Date borrowed;
	private Date dueDate;
	private double price;
	private BookFormat format;
	private BookStatus status;
	private Date dateOfPurchase;
	private Date publicationDate;
	private Rack placedAt;

	public String getBarcode() {
		return barcode;
	}

	public boolean getIsReferenceOnly() {
		return isReferenceOnly;
	}

	public boolean checkout(String memberId) {
		if (this.getIsReferenceOnly()) {
			System.out.println("This book is Reference only and can't be issued");
			return false;
		}
		if (!BookLending.lendBook(this.getBarcode(), memberId)) {
			return false;
		}
		this.updateBookItemStatus(BookStatus.LOANED);
		return true;
	}

	public void updateBookItemStatus(BookStatus status) {
		this.status = status;
	}

	public void updateDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
}

class Rack {
	private int number;
	private String locationIdentifier;
}
