package mate.academy.hibernate.relations.dao.impl;

import java.util.Optional;
import mate.academy.hibernate.relations.exception.DataProcessingException;
import org.hibernate.SessionFactory;

public abstract class AbstractDao {
    protected final SessionFactory factory;

    protected AbstractDao(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    protected <T> T add(T entity) {
        try {
            return factory.fromTransaction(session -> {
                session.persist(entity);
                return entity;
            });
        } catch (Exception e) {
            throw new DataProcessingException("Failed to add entity '%s'".formatted(entity), e);
        }
    }

    protected <T> Optional<T> get(Class<T> entityClass, Long id) {
        try {
            return Optional.ofNullable(factory.fromSession(session ->
                    session.get(entityClass, id)));
        } catch (Exception e) {
            throw new DataProcessingException("Failed to find entity with id '%s'"
                    .formatted(id), e);
        }
    }
}
