package com.backend.LOS.Repository.Impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.backend.LOS.DTO.UserDTO;
import com.backend.LOS.Entity.User;
import com.backend.LOS.ExceptionHandling.ResourceAlreadyExistsException;
import com.backend.LOS.ExceptionHandling.ResourceNotFoundException;
import com.backend.LOS.Repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User registerUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(user);
			session.getTransaction().commit();
		} catch (ConstraintViolationException | DataIntegrityViolationException e) {
			session.getTransaction().rollback();
			throw new ResourceAlreadyExistsException("User with this username and email already exists");
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public User getUserbyId(long id) {
		User user = null;
		// Use try-with-resources to ensure the session is closed properly
		try (Session session = sessionFactory.openSession()) {
			user = session.get(User.class, id);
			if (user == null) {
				throw new ResourceNotFoundException("User with ID " + id + " not found.");
			}
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (HibernateException e) {
			throw new RuntimeException("Error retrieving user by ID: " + id, e);
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException("An unexpected error occurred while retrieving user by ID: " + id, e);
		}
		return user;
	}

	@Override
	public User updateUser(long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
