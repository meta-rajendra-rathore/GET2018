/**
 * 
 */
package linkedIn.com.model.dto;

/**
 * @author User18
 *
 */
public class FriendDto {
	String firstName, lastName, email, contact, image;

	public FriendDto(String firstName, String lastName, String email, String contact, String image) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
		this.image = image;
	}

	/**
	 * @return the firstName
	 */
	public synchronized String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public synchronized void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public synchronized String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public synchronized void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public synchronized String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public synchronized void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contact
	 */
	public synchronized String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public synchronized void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the image
	 */
	public synchronized String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public synchronized void setImage(String image) {
		this.image = image;
	}
}
