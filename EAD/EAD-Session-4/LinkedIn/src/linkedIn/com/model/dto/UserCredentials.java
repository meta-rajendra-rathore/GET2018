package linkedIn.com.model.dto;

public class UserCredentials {
	private String password;
	
	public UserCredentials(String password) {
		this.password = password;
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
}
