package com.revature.repo;

import com.revature.models.ErsUser;
import com.revature.models.ErsUserRole;
import com.revature.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class ErsUserRepository {

    static CriteriaBuilder cb;
    static Transaction tx = null;
    static Session session;

    public static void printErsUsers(){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try{
            //HQL
            tx = session.beginTransaction();
            List<ErsUser> ersUsers = session.createQuery("FROM ErsUser ", ErsUser.class).list();

            for (ErsUser ersu : ersUsers) {
                System.out.println(ersu.toString());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx!= null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void printErsUsersCriteria(){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try{

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();
            CriteriaQuery<ErsUser> cq = cb.createQuery(ErsUser.class);
            Root<ErsUser> root = cq.from(ErsUser.class);
            cq.select(root);

            Query query = session.createQuery(cq);

            List<ErsUser> ersUsers = query.getResultList();

            for (ErsUser ersu : ersUsers) {
                System.out.println(ersu.toString());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx!= null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteUserCriteria(){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try {

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();
            CriteriaDelete<ErsUser> cd = cb.createCriteriaDelete(ErsUser.class);
            Root<ErsUser> root = cd.from(ErsUser.class);

            Query query = session.createQuery(cd);

            query.executeUpdate();


        } catch (Exception e){

        } finally {
            session.close();
        }

    }

    public static void deleteUserByUsername(String username){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try {

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();
            CriteriaDelete<ErsUser> cd = cb.createCriteriaDelete(ErsUser.class);
            Root<ErsUser> root = cd.from(ErsUser.class);
            cd.where(cb.equal(root.get("username"), username));

            //TODO this returns an int so we can make this return int to debug
            session.createQuery(cd).executeUpdate();

        } catch (Exception e){

            System.out.println(e.getStackTrace());
        } finally {
            session.close();
        }

    }

    public Optional<ErsUser> findUserByCredentials(String username, String password){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        Optional<ErsUser> _user = Optional.empty();

        try{

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();

            CriteriaQuery<ErsUser> cq = cb.createQuery(ErsUser.class);
            Root<ErsUser> root = cq.from(ErsUser.class);
            cq.select(root);

            cq.where(cb.equal(root.get("username"), username), cb.equal(root.get("password"), password));

            Query query = session.createQuery(cq);

            _user = (Optional<ErsUser>) query.getResultList().stream().findFirst();

            tx.commit();

        } catch (Exception e) {
            if (tx!= null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return (_user);
    }
}
