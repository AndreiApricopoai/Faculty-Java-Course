package org.example.repository;

import org.example.manager.PersistenceManager;
import org.example.models.AlbumJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractRepository<T> {

    protected EntityManager entityManager;
    private final Class<T> persistentClass;

    public AbstractRepository(EntityManagerFactory emf)
    {
        entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        Type t = getClass().getGenericSuperclass();
        if(t instanceof ParameterizedType)
        {
            persistentClass = (Class<T>) ((ParameterizedType) t).getActualTypeArguments()[0];
        }
        else
        {
            throw new IllegalArgumentException("Could not guess entity class by reflection");
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void create(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public T findById(Long id) {
        return entityManager.find(persistentClass, id);
    }

    public List<T> findByName(String namePattern) {
        TypedQuery<T> query = entityManager.createNamedQuery(persistentClass.getSimpleName() + ".findByName", persistentClass);
        query.setParameter("name", "%" + namePattern + "%");
        return query.getResultList();
    }
    public void close()
    {
        entityManager.close();
    }
}
