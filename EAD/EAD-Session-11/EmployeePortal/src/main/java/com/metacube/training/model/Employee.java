package com.metacube.training.model;

public class Employee {
	private String emp_code;
	private String firstName;
	private String lastName;
	private String date;
	private char gender;
	private String contactNumber;
	private String secondaryContactNumber;
	private String email;
	private String password;
	private String skypeId;
	private String profileImage;
	private boolean isEnable;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param emp_code
	 * @param firstName
	 * @param lastName
	 * @param date
	 * @param gender
	 * @param contactNumber
	 * @param secondaryContactNumber
	 * @param email
	 * @param password
	 * @param skypeId
	 * @param profileImage
	 * @param isEnable
	 */
	public Employee(String emp_code, String firstName, String lastName,
			String date, char gender, String contactNumber,
			String secondaryContactNumber, String email, String password,
			String skypeId, String profileImage, boolean isEnable) {
		this.emp_code = emp_code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.secondaryContactNumber = secondaryContactNumber;
		this.email = email;
		this.password = password;
		this.skypeId = skypeId;
		this.profileImage = profileImage;
		this.isEnable = isEnable;
	}

	/**
	 * @return the emp_code
	 */
	public String getEmp_code() {
		return emp_code;
	}

	/**
	 * @param emp_code the emp_code to set
	 */
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the secondaryContactNumber
	 */
	public String getSecondaryContactNumber() {
		return secondaryContactNumber;
	}

	/**
	 * @param secondaryContactNumber the secondaryContactNumber to set
	 */
	public void setSecondaryContactNumber(String secondaryContactNumber) {
		this.secondaryContactNumber = secondaryContactNumber;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the skypeId
	 */
	public String getSkypeId() {
		return skypeId;
	}

	/**
	 * @param skypeId the skypeId to set
	 */
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	/**
	 * @return the profileImage
	 */
	public String getProfileImage() {
		return profileImage;
	}

	/**
	 * @param profileImage the profileImage to set
	 */
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	/**
	 * @return the isEnable
	 */
	public boolean isEnable() {
		return isEnable;
	}

	/**
	 * @param isEnable the isEnable to set
	 */
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
}