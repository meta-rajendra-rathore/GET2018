package linkedIn.com.facade;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.xml.ws.Response;

import linkedIn.com.dao.CredentialsDaoMySQL;
import linkedIn.com.dao.EmailDaoMySQL;
import linkedIn.com.dao.MyUserDaoMySQL;
import linkedIn.com.enums.Status;
import linkedIn.com.model.dto.UserEmail;
import linkedIn.com.model.pojo.MyUser;

public class ValidateData {

	public static Status validateUserForSignup(MyUser user) {
		List<UserEmail> listOfEmails = EmailDaoMySQL.getInstance().getAllEmails();
		for (UserEmail userEmail : listOfEmails) {
			if (user.getEmail() == userEmail.getEmail()) {
				return Status.DUPLICATE;
			}
		}
		Status status = MyUserDaoMySQL.getInstance().addEmployee(user);
		return status; 
	}
	
	public static Status checkUserExistence(String email, String password) {
		List<UserEmail> listOfEmails = new ArrayList<UserEmail>();
		listOfEmails = EmailDaoMySQL.getInstance().getAllEmails();
		for (UserEmail userEmail : listOfEmails) {
			if (userEmail.getEmail().equals(email)) {
				String userPassword = CredentialsDaoMySQL.getInstance().getCredentialsByEmail(email).getPassword();
				if (userPassword.equals(password)) {
					return Status.OK;
				} else {
					return Status.FAILURE;
				}
			}
		} 
		
		return Status.FAILURE;
	}
}
