package org.example;

import jakarta.persistence.EntityManager;
import org.example.beans.Student;
import org.example.util.JPAHelper;

public class Main {
    public static void main(String[] args) {

        EntityManager entityManager = JPAHelper.getFactory().createEntityManager(); // It creates new application-managed EntityManager
        entityManager.getTransaction() // This method returns the resource-level EntityTransaction object.
                .begin(); // This method is used to start the transaction.

        Student student = new Student("Hamza", "Jaa", "hamzajaa@gmail.com");
        entityManager.persist(student); // This method is used to make an instance managed and persistent. An entity instance is passed within this method.
        entityManager.getTransaction().commit(); // Closing the transaction
        entityManager.close();

        JPAHelper.shutdown();
    }
}