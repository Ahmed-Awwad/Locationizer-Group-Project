package com.revature.dao;

import java.util.List;

import com.revature.domain.Users;

public interface UserDao {

	public List<Users> getUsers();
	
	public Users login(String username, String password);

	public Users getUserById(int id);

	public int createUser(Users u);

	public int updateUser(Users u);

	public int deleteUser(Users u);

}
