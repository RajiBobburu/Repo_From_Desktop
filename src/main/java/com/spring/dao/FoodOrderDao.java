package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.Admin;
import com.spring.dto.FoodOrder;
import com.spring.dto.Product;
@Repository
public class FoodOrderDao {
	
/*savefoodorder*/
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	public void saveFoodOrder(FoodOrder fo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(fo);
		entityTransaction.commit();
	}
/*displayallfoodorders*/
	
	public List<FoodOrder> fetchAllFoodOrders(){
		EntityManager em =entityManagerFactory.createEntityManager();
		Query query=em.createQuery("select fo from FoodOrder FoodOrder");
		return query.getResultList();		
	}
	
/*Update*/
	
	public void updateFoodOrder(FoodOrder fo) {
		EntityManager em= entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(fo);
		et.commit();
	}
/*Delete*/
	
	public void deleteFoodOrder(FoodOrder fo) {
		EntityManager em= entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.remove(fo);
		et.commit();
	}
}
