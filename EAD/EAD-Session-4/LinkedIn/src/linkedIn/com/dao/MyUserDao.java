package linkedIn.com.dao;

import java.util.List;

import linkedIn.com.enums.Status;
import linkedIn.com.model.dto.FriendDto;
import linkedIn.com.model.dto.UserDto;
import linkedIn.com.model.pojo.MyUser;

public interface MyUserDao {
	//public List<MyUser> getAllEmployees();
	//public List<MyUser> searchEmployees(String searchQuery);
	public Status addUser(MyUser employee); 
	public Status updateUser(int id, UserDto user);
	public Status uploadImage(String imageURL, String email);
	public UserDto searchUserByEmail(String searchQuery);
	public List<FriendDto> getFriends(UserDto user);
}
