package mate.academy.hibernate.relations.util;

import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.model.Country;
import mate.academy.hibernate.relations.model.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = initFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory initFactory() {
        return new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Movie.class)
                .buildSessionFactory();
    }
}
