package linkedIn.com.model.dto;

public class UserEmail {
	private String email;

	public UserEmail(String email) {
		this.email = email;
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

}
