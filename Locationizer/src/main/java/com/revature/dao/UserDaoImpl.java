package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.domain.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getUsers() {
		Session s = HibernateUtil.getSession();
		
		List<User> u = s.createQuery("from User").list();
		
		
		return u;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
