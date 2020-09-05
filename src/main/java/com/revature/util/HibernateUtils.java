package com.revature.util;

import com.revature.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    private static Properties props = new Properties();

    public static SessionFactory getSessionFactoryProgrammaticConfig() {

        if (sessionFactory != null)
            return sessionFactory;

        try {
            props.load(new FileReader("./src/main/resources/application.properties"));
            Configuration config = new Configuration()
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                    .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                    .setProperty("hibernate.connection.url", props.getProperty("url"))
                    .setProperty("hibernate.connection.username", props.getProperty("username"))
                    .setProperty("hibernate.connection.password", props.getProperty("password"))
                    .addAnnotatedClass(ErsReimbursementStatuses.class);


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
        }

        return null;
    }

}