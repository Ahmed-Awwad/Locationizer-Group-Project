package com.revature.main;

import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.domain.Users;

public class Driver {

	// Driver for the Hibernate database.
	public static void main(String[] args) {

		// User Test
//		userTest();
	}
	
	public static void userTest() {
		UserDaoImpl udi = new UserDaoImpl();

		Users u1 = new Users("tester", "test");

		udi.createUser(u1);

		udi.getUserById(1);

		List<Users> ul = udi.getUsers();
		for (Users u : ul) {
			System.out.println(u.getUsername());
		}
	}
}
