package com.niiit.proj2.dao;

import java.util.List;

import com.niiit.proj2.model.Users;



public interface UsersDao {
	
	public void addUsers(Users users);
	public void updateUsers(Users users);
	public void deleteUsers(String userId);
	public Users getUsersById(String userId);

	public List<Users> getAllUsers();

	public Users getUsersByUsername(String userName);
	public void editUsers(Users users);
	

}
