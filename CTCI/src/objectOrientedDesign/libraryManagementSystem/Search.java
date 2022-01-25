package objectOrientedDesign.libraryManagementSystem;

import java.util.HashMap;
import java.util.List;

/**
 * Search interface and Catalogue
 * 
 * @author Hammad: 24-Jan-2022
 */
public interface Search {
	public List<Book> searchByTitle(String title);

	public List<Book> searchByAuthor(String title);

	public List<Book> searchBySubject(String title);

	public List<Book> searchByPubDate(String title);
}

class Catalogue implements Search {

	private HashMap<String, List<Book>> bookTitles;
	private HashMap<String, List<Book>> bookAuthors;
	private HashMap<String, List<Book>> bookSubjects;
	private HashMap<String, List<Book>> bookPublicationDate;

	public List<Book> searchByTitle(String title) {
		return bookTitles.get(title);
	}

	public List<Book> searchByAuthor(String author) {
		return bookAuthors.get(author);
	}

	public List<Book> searchBySubject(String subject) {
		return bookSubjects.get(subject);
	}

	public List<Book> searchByPubDate(String publicationDate) {
		return bookPublicationDate.get(publicationDate);
	}
}
