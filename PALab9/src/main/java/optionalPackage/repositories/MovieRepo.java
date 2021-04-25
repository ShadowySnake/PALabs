package optionalPackage.repositories;

import optionalPackage.entity.OPTMOVIE;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class MovieRepo extends AbstractRepository<OPTMOVIE>{
    private final EntityManagerFactory entityManagerFactory;

    public MovieRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create(OPTMOVIE movie) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<OPTMOVIE> findByName(String movieName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select m from OPTMOVIE m where m.title like :title");

        List<OPTMOVIE> movies = query.setParameter("title", movieName).getResultList();
        entityManager.close();

        return movies.isEmpty() ? null : movies;
    }

    public OPTMOVIE findById(long movieId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select m from OPTMOVIE m where m.id = :movieId");

        List<OPTMOVIE> person = query.setParameter("movieId", movieId).getResultList();
        entityManager.close();

        return person.isEmpty() ? null : person.get(0);
    }

    public List<OPTMOVIE> getAllMovies(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select m from OPTMOVIE m");

        List<OPTMOVIE> movies = query.getResultList();
        entityManager.close();

        return movies.isEmpty() ? null : movies;
    }
}
