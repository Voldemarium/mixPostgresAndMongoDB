package ru.synergy.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;
import ru.synergy.models.Contact;
import ru.synergy.models.User;

import java.io.Closeable;


public class EntityService implements Closeable {
    private final EntityManagerFactory entityManagerFactory;
    @Getter
    private final EntityManager em;

    public EntityService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("user_pu");
        em = entityManagerFactory.createEntityManager();
    }
    public void add(User user, Contact contact) {
        contact.setUser(user);
        em.getTransaction().begin();
        em.persist(contact);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        em.close();
        entityManagerFactory.close();
    }
}