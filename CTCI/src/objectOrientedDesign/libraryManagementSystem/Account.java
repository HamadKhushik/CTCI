package objectOrientedDesign.libraryManagementSystem;

/**
 * @author Hammad: 23-Jan-2022
 */
public abstract class Account {

	String id;
	String password;
	AccountStatus status;
	Person person;

	public boolean resetPassword() {
		System.out.println("returning false from resetPassword() in Account class!");
		return false;
	}

}
