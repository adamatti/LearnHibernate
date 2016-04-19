package adamatti;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String [] args){
        logger.info("Started");

        Configuration cfg = new Configuration().configure(); //check hibernate.cfg.xml
        cfg.addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        //Insert
        logger.info("Inserting");
        Person person = new Person("adamatti");
        session.save(person);

        //List
        logger.info("Listing");
        List<Person> list = session.createCriteria(Person.class).list();

        logger.info("End");
        System.exit(0);
    }
}
