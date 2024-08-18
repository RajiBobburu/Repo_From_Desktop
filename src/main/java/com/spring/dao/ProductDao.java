package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.Admin;
import com.spring.dto.Product;
@Repository
public class ProductDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	public void saveProduct(Product product) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
	}
	public List<Product> fetchAllProducts(){
		EntityManager em =entityManagerFactory.createEntityManager();
		Query query=em.createQuery("select product from Product product");
		return query.getResultList();		
	}
	public Product findProductById(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		return em.find(Product.class,id);
	}
	public void updateProduct(Product product) {
		EntityManager em= entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(product);
		et.commit();
	}
	public void deleteProduct(Product product) {
		EntityManager em= entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.remove(product);
		et.commit();
	}
}
