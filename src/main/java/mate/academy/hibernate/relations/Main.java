package mate.academy.hibernate.relations;

import java.util.List;
import mate.academy.hibernate.relations.dao.impl.ActorDaoImpl;
import mate.academy.hibernate.relations.dao.impl.CountryDaoImpl;
import mate.academy.hibernate.relations.dao.impl.MovieDaoImpl;
import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.model.Country;
import mate.academy.hibernate.relations.model.Movie;
import mate.academy.hibernate.relations.service.ActorService;
import mate.academy.hibernate.relations.service.CountryService;
import mate.academy.hibernate.relations.service.MovieService;
import mate.academy.hibernate.relations.service.impl.ActorServiceImpl;
import mate.academy.hibernate.relations.service.impl.CountryServiceImpl;
import mate.academy.hibernate.relations.service.impl.MovieServiceImpl;
import mate.academy.hibernate.relations.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {
    private static final SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        // Services declaration and initialization
        final CountryService countryService = new CountryServiceImpl(new CountryDaoImpl(factory));
        final ActorService actorService = new ActorServiceImpl(new ActorDaoImpl(factory));
        final MovieService movieService = new MovieServiceImpl(new MovieDaoImpl(factory));

        // save country
        Country usa = new Country("USA");
        countryService.add(usa);

        // saving actor
        Actor vinDiesel = new Actor("Vin Diesel");
        vinDiesel.setCountry(usa);
        actorService.add(vinDiesel);

        // saving new movie
        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setActors(List.of(vinDiesel));
        movieService.add(fastAndFurious);

        System.out.println();
    }
}
