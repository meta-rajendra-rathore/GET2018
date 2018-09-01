package linkedIn.com.model.pojo;

public class MyUser {
	private String firstName, lastName, email, dob, password, contact, organisation, image;
	private int id;
	
	public MyUser(int id, String fName, String lName, String email, String dob, String password, String contact, String organisation, String image) {
		this.id = id;
		firstName = fName;
		lastName = lName;
		this.email = email;
		this.dob = dob;
		this.password = password;
		this.contact = contact;
		this.organisation = organisation;
		this.image = image;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dob
	 */
	public synchronized String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public synchronized void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the password
	 */
	public synchronized String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public synchronized void setPassword(String password) {
		this.password = password;
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
	 * @return the organisation
	 */
	public synchronized String getOrganisation() {
		return organisation;
	}

	/**
	 * @param organisation the organisation to set
	 */
	public synchronized void setOrganisation(String organisation) {
		this.organisation = organisation;
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
