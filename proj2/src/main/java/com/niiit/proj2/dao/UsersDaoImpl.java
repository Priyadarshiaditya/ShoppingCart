package com.niiit.proj2.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niiit.proj2.model.Product;
import com.niiit.proj2.model.Users;



@Repository("usersDao")
@Transactional
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public void addUsers(Users users) {
		// TODO Auto-generated method stub

		Session session = getSession();

		String s = users.getUserName();
		
		
		users.setEnabled(true);
		users.setUserRole("ROLE_USER");
		users.setDiscontinue(false);
		session.save(users);

		session.flush();

		session.close();

	}

	public Users getUsersById(String userId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		
		Query query = session.createQuery("from Users where userId = '"+ userId+"'"+" and discontinue=false");
		List<Users> userList = query.list();
        session.close();

		if(userList ==null || userList.size()==0)
		{
			return null;
		}
		else
		{
			return userList.get(0);
		}
	}

	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Users where discontinue=false");
		List<Users> customerList = query.list();

		return customerList;

	}

	public Users getUsersByUsername(String userName) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Users where username = ? and discontinue=false");
		query.setString(0, userName);

		return (Users) query.uniqueResult();

	}

	public void updateUsers(Users users) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String s = users.getUserName();

		session.update(users);

		session.flush();

		session.close();
	}

	public void deleteUsers(String userId) {
		// TODO Auto-generated method stub
		
		Session session = getSession();

		Query query = session.createQuery("from Users where userId = ? and discontinue=false");
		query.setString(0, userId);

		Users u=(Users) query.uniqueResult();
		u.setDiscontinue(true);
		session.save(u);
		session.flush();

		session.close();
		
	}


	public void editUsers(Users users)
	 {
		 //Transaction tx = getSession().beginTransaction();
		 Session s=getSession();
		 
		 users.setEnabled(true);
		 s.update(users);
		 s.flush();
		 s.close();
		// tx.commit();
	 }


}
