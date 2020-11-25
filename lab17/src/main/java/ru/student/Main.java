package ru.student;

import ru.student.entity.Basket;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
    @PersistenceContext
    public static EntityManager em = Persistence.createEntityManagerFactory("Basket").createEntityManager();

    public static void main(String[] args) {
        Basket basket1 = new Basket("Корзина1", "рабочий стол1");
        em.getTransaction().begin();
        Basket basketFromDB = em.merge(basket1);
        em.getTransaction().commit();

        TypedQuery<Basket> namedQuery = em.createNamedQuery("getAll", Basket.class);
        List<Basket> baskets = namedQuery.getResultList();
        for (Basket basket : baskets) {
            System.out.println("Id: " + basket.getId() + " Имя: " + basket.getName() + " Путь: " + basket.getPath());
        }
    }
}
