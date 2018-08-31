package linkedIn.com.dao;

import java.util.List;

import linkedIn.com.enums.Status;
import linkedIn.com.model.pojo.MyUser;

public interface MyUserDao extends EmailDao{
	//public List<MyUser> getAllEmployees();
	//public List<MyUser> searchEmployees(String searchQuery);
	public Status addEmployee(MyUser employee); 
	public Status updateEmployee(int id, MyUser employee);
	public MyUser searchEmployeeByID(String searchQuery);
}
