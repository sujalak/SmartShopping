package com.niit.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.UserDao;
import com.niit.Model.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	List<User> users;
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}

	public UserDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	public List<User> list() {

		return users;
	}

	public boolean save(User user) {
		try {
			getCurrentSession().save(user);

			System.out.println("successfully created");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public boolean update(User user) {
		try {
			getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(User user) {
		try {
			getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

}
