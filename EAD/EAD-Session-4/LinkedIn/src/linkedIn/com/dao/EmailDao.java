package linkedIn.com.dao;

import java.util.List;

import linkedIn.com.model.dto.UserEmail;

public interface EmailDao {
	public List<UserEmail> getAllEmails();
	public void createConnection();
}
