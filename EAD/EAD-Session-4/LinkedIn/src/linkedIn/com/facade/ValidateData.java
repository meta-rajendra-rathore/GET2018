package linkedIn.com.facade;

import java.util.List;

import linkedIn.com.dao.EmailDao;
import linkedIn.com.dao.EmailDaoMySQL;
import linkedIn.com.dao.MyUserDaoMySQL;
import linkedIn.com.model.dto.UserEmail;
import linkedIn.com.model.pojo.MyUser;

public class ValidateData {

	public boolean validateUserForSignup(MyUser user) {
		List<UserEmail> listOfEmails = EmailDaoMySQL.getInstance().getAllEmails();
		for (UserEmail userEmail : listOfEmails) {
			if (user.getEmail() == userEmail.getEmail()) {
				return false;
			}
		}
		MyUserDaoMySQL.getInstance().addEmployee(user);
		return true;
	}
	
}
