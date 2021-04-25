package optionalPackage.repositories;

import optionalPackage.entity.People;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class PeopleRepo extends AbstractRepository<People>{
    private final EntityManagerFactory entityManagerFactory;

    public PeopleRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create(People person) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<People> findByName(String personName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select t from People t where t.name like :name");

        List<People> persons = query.setParameter("name", personName).getResultList();
        entityManager.close();

        return persons.isEmpty() ? null : persons;
    }

    public People findById(long personId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select t from People t where t.id = :personId");

        List<People> person = query.setParameter("personId", personId).getResultList();
        entityManager.close();

        return person.isEmpty() ? null : person.get(0);
    }
}
