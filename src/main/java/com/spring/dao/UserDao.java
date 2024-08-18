package com.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.Product;
import com.spring.dto.User;
@Repository
public class UserDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	public void saveUser(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
}
	public User findUserBYEmailAndPassword(String email, String password) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select user from User user where user.email=?1 and user.password=?2);");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			return(User)query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
		public void updateUser(User user) {
			EntityManager em= entityManagerFactory.createEntityManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.merge(user);
			et.commit();
		}
	}


