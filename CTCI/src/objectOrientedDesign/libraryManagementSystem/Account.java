package objectOrientedDesign.libraryManagementSystem;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Account class and sub-classes i-e Member and Librarian
 * 
 * @author Hammad: 23-Jan-2022
 */
public abstract class Account {

	String id;
	String password;
	AccountStatus status;
	Person person;

	public String getId() {
		return id;
	}

	public boolean resetPassword() {
		return false;
	}
}

class Librarian extends Account {

	public boolean addBookItem(BookItem bookItem) {
		return false;
	}

	public boolean blockMember(Member member) {
		return false;
	}

	public boolean unBlockMember(Member member) {
		return false;
	}
}

class Member extends Account {

	private Date dateOfMembership;
	private int totalBooksCheckedOut;

	public int getTotalBooksCheckedOut() {
		return totalBooksCheckedOut;
	}

	public boolean reserveBookItem(BookItem bookItem) {
		System.out.println("returning false from reserveBookItem() from Member class");
		return false;
	}

	private void incrementTotalBooksCheckedOut() {
		totalBooksCheckedOut++;
	}

	private void decrementTotalBooksCheckedOut() {
		totalBooksCheckedOut--;
	}

	public boolean checkoutBookItem(BookItem bookItem) {

		if (this.getTotalBooksCheckedOut() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
			System.out.println("The user has already checked out maximum number of books");
			return false;
		}
		BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
		if (bookReservation != null && bookReservation.getMemberId() != this.getId()) {
			// book item has a pending reservation from another user
			System.out.println("This book is reserved by another member");
			return false;
		} else if (bookReservation != null) {
			// book item has pending reservation from the given member, update it
			/* bookReservation.updateStatus(ReservationStatus.COMPLETED); */
		}

		if (!bookItem.checkout(this.getId())) {
			return false;
		}

		this.incrementTotalBooksCheckedOut();
		return true;
	}

	private void checkForFine(String bookItemBarcode) {
		BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
		Date dueDate = bookLending.getDueDate();
		Date today = new Date();
		// check if the book has been returned within due date
		if (today.compareTo(dueDate) > 0) {
			long diff = today.getTime() - dueDate.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);
			Fine.collectFine(this.getId(), diffDays); // collect fine from 'this' object
		}
	}

	public void returnBookItem(BookItem bookItem) {
		this.checkForFine(bookItem.getBarcode());
		BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
		if (bookReservation != null) {
			// book item has a pending reservation
			bookItem.updateBookItemStatus(BookStatus.RESERVED);
			/* bookReservation.sendBookAvailableNotification(); */
		}
		bookItem.updateBookItemStatus(BookStatus.AVAILABLE);
	}

	public boolean renewBookItem(BookItem bookItem) {
		this.checkForFine(bookItem.getBarcode());
		BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
		// check if this book item has a pending reservation from another member
		if (bookReservation != null && bookReservation.getMemberId() != this.getId()) {
			System.out.println("This book is reserved by another member");
			this.decrementTotalBooksCheckedOut();
			bookItem.updateBookItemStatus(BookStatus.RESERVED);
			/* bookReservation.sendBookAvailableNotification(); */
			return false;
		} else if (bookReservation != null) {
			// book item has a pending reservation from this member
			/* bookReservation.updateStatus(ReservationStatus.COMPLETED); */
		}
		BookLending.lendBook(bookItem.getBarcode(), this.getId());
		Date dueDate = Date.from(
				LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS).atStartOfDay(ZoneId.systemDefault()).toInstant());
		bookItem.updateDueDate(dueDate);
		return true;
	}

}