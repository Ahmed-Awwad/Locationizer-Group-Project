package com.revature.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Users;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public List<Users> getUsers() {
		Session s = HibernateUtil.getSession();
		
		List<Users> u = s.createQuery("from Users").list();
		
		s.close();
		return u;
	}

	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createUser(Users u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		int id = (int) s.save(u);
		
		tx.commit();
		s.close();
		
		return id;
	}

	@Override
	public int updateUser(Users u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Users u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
