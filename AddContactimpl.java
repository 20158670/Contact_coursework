package contactManager;

/**
 * @author Sam Malcolm
 * @since 10 Dec 2015 | 11:52:55
 * Description: setting the different variables from the users input into the interface... I think :/
 */

public class AddContactimpl implements Contact {

	int d = 0;
	String name = null;
	String notes = null;


	public void setId(int newId) {
		d = newId;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setNotes(String newNotes) {
		notes = newNotes;
	}
	public void printContacts(){
		System.out.println("Id = " + d + ", Name = " + name + ", notes = " + notes);
	}


}
