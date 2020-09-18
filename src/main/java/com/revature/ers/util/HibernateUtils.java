package com.revature.ers.util;

import com.revature.ers.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.cfg.Configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    private static Properties props = new Properties();

    public static SessionFactory getSessionFactoryProgrammaticConfig() {

        if (sessionFactory != null)
            return sessionFactory;

        try {
            // props.load(new FileReader("./src/main/resources/application.properties"));

            /*
            Configuration cfg = new...
            cfg.addA...


             */

            props.load(HibernateUtils.class.getClassLoader().getResourceAsStream("application.properties"));
            Configuration config = new Configuration()
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                    .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                    .setProperty("hibernate.connection.url", props.getProperty("url"))
                    .setProperty("hibernate.connection.username", props.getProperty("username"))
                    .setProperty("hibernate.connection.password", props.getProperty("password"))
                    .addAnnotatedClass(ErsReimbursementStatus.class)
                    .addAnnotatedClass(ErsReimbursementType.class)
                    .addAnnotatedClass(ErsUserRole.class)
                    .addAnnotatedClass(ErsUser.class)
                    .addAnnotatedClass(ErsReimbursement.class);


            config.setImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE);

            sessionFactory = config.buildSessionFactory();
            return sessionFactory;

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.err.println("[ERROR] - " + ioe.getMessage() + ". Shutting down application");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;

            //throw new ExceptionInInitializerError to halt app
        }

        return null;
    }
    // getSessionFactory to make the sessionfactory a singleton
    // we dont rly need a hibernateConfic instance since all methods are static


}