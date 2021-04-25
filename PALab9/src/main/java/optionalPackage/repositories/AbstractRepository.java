package optionalPackage.repositories;

import java.util.List;

public abstract class AbstractRepository<T> {
    public abstract void create(T object);

    public abstract T findById(long id);

    public abstract List<T> findByName(String name);
}
