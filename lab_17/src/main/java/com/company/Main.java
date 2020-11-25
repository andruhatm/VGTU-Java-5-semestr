package com.company;

import com.company.entity.Basket;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
	@PersistenceContext
	public static EntityManager manager = Persistence.createEntityManagerFactory("Basket").createEntityManager();

	public static void main(String[] args) {
		Basket simpleBasket = new Basket("test","C://..");
		manager.getTransaction().begin();
		Basket var = manager.merge(simpleBasket);
		manager.getTransaction().commit();

		TypedQuery<Basket> query = manager.createNamedQuery("getAllRows",Basket.class);
		List<Basket> baskets = query.getResultList();

	}
}
