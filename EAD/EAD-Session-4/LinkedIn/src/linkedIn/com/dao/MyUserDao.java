package linkedIn.com.dao;

import java.util.List;

import linkedIn.com.enums.Status;
import linkedIn.com.model.dto.UserDto;
import linkedIn.com.model.pojo.MyUser;

public interface MyUserDao {
	//public List<MyUser> getAllEmployees();
	//public List<MyUser> searchEmployees(String searchQuery);
	public Status addEmployee(MyUser employee); 
	public Status updateEmployee(int id, MyUser employee);
	public Status uploadImage(String imageURL, String email);
	public UserDto searchEmployeeByEmail(String searchQuery); 
}
