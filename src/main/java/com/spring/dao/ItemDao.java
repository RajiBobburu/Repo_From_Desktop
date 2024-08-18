package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.Admin;
import com.spring.dto.FoodOrder;
import com.spring.dto.Item;
@Repository
public class ItemDao {
/*saveitem*/
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	public void saveAdmin(Item item) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
	}
	
/*displayallitems*/
	
	public List<Item> fetchAllItem(){
		EntityManager em =entityManagerFactory.createEntityManager();
		Query query=em.createQuery("select item from Item Item");
		return query.getResultList();		
	}
	
/*updateitem*/
	public void updateItem(Item item) {
		EntityManager em= entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(item);
		et.commit();
	}
	
/*deleteitem*/
	public void deleteItem(Item item) {
		EntityManager em= entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.remove(item);
		et.commit();
	}
}
