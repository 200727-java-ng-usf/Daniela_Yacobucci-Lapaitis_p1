package com.revature.ers.repo;

import com.revature.ers.models.ErsUser;
import com.revature.ers.models.ErsUserRole;
import com.revature.ers.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;



public class ErsUserRepository {

    static CriteriaBuilder cb;
    static Transaction tx = null;
    static Session session;

    public Optional<List<ErsUser>>  getAllErsUsers(){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
        Optional<List<ErsUser>> _ersUsers = Optional.empty();
        try{
            //HQL
            tx = session.beginTransaction();
            List<ErsUser> ersUsers = session.createQuery("FROM ErsUser ", ErsUser.class).list();
            _ersUsers = Optional.of(ersUsers);

            for (ErsUser ersu : _ersUsers.get()) {
                System.out.println(ersu.toString());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx!= null) tx.rollback();
            e.printStackTrace();
        }

        return _ersUsers;
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
        }

        //TODO remove breadcrumb
        System.out.println("User and credentials: ");
        if(_user.isPresent()){
            System.out.println(_user);
        }
        else {
            System.out.println("SOT PRESENT");
        }

        return (_user);
    }

    public Optional<ErsUser> findUserByUsername(String username){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        Optional<ErsUser> _user = Optional.empty();

        try{

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();

            CriteriaQuery<ErsUser> cq = cb.createQuery(ErsUser.class);
            Root<ErsUser> root = cq.from(ErsUser.class);
            cq.select(root);

            cq.where(cb.equal(root.get("username"), username));

            Query query = session.createQuery(cq);

            _user = (Optional<ErsUser>) query.getResultList().stream().findFirst();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return (_user);
    }

    public Optional<ErsUser> findUserByEmail(String email){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        Optional<ErsUser> _user = Optional.empty();

        try{

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();

            CriteriaQuery<ErsUser> cq = cb.createQuery(ErsUser.class);
            Root<ErsUser> root = cq.from(ErsUser.class);
            cq.select(root);

            cq.where(cb.equal(root.get("email"), email));

            Query query = session.createQuery(cq);

            _user = (Optional<ErsUser>) query.getResultList().stream().findFirst();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return (_user);
    }

    public Optional<ErsUser> findUserById(int id){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        Optional<ErsUser> _user = Optional.empty();

        try{

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();

            CriteriaQuery<ErsUser> cq = cb.createQuery(ErsUser.class);
            Root<ErsUser> root = cq.from(ErsUser.class);
            cq.select(root);

            cq.where(cb.equal(root.get("ersUserId"), id));

            Query query = session.createQuery(cq);

            _user = (Optional<ErsUser>) query.getResultList().stream().findFirst();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return (_user);
    }

    public boolean changeRoleToInactive (ErsUser ersUser) {

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try{

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();

            CriteriaUpdate<ErsUser> cu = cb.createCriteriaUpdate(ErsUser.class);
            Root<ErsUser> root = cu.from(ErsUser.class);

            cu.set("ersUserRole", new ErsUserRole(4,"Inactive"));

            cu.where(cb.equal(root.get("id"), ersUser.getErsUserId()));

            tx.commit();

            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

// kept this here for reference because it works
//    public void changeRoleToInactiveById (int id) {
//
//        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
//
//        try{
//
//            tx = session.beginTransaction();
//
//            cb = session.getCriteriaBuilder();
//
//            CriteriaUpdate<ErsUser> cu = cb.createCriteriaUpdate(ErsUser.class);
//            Root<ErsUser> root = cu.from(ErsUser.class);
//
//            cu.set( "firstName", "Delospalotes");
//
//
//            cu.where(cb.equal(root.get("ersUserId"), id));
//
//            Query query = session.createQuery(cu);
//            query.executeUpdate();
//            tx.commit();//DO NOT FORGET!!!!!!         //TODO DONT FORGET
//
//            //TODO print queries
//
//
//
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//
//        }
//    }


    public void changeRoleToInactiveById (int id) {

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try{

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();

            CriteriaUpdate<ErsUser> cu = cb.createCriteriaUpdate(ErsUser.class);
            Root<ErsUser> root = cu.from(ErsUser.class);

            cu.set( "ersUserRole", new ErsUserRole(4, "Inactive"));

            cu.where(cb.equal(root.get("ersUserId"), id));

            Query query = session.createQuery(cu);
            query.executeUpdate();
            tx.commit();//dont forget!!!


        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        }
    }


    public void changeFirstNameById (int id, String firstName) {

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try{
            tx = session.beginTransaction();
            cb = session.getCriteriaBuilder();

            CriteriaUpdate<ErsUser> cu = cb.createCriteriaUpdate(ErsUser.class);
            Root<ErsUser> root = cu.from(ErsUser.class);

            cu.set( "firstName", firstName).where(cb.equal(root.get("ersUserId"), id));

            session.createQuery(cu).executeUpdate();
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        }
    }

    public void changeLastNameById (int id, String lastName) {

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try{
            tx = session.beginTransaction();
            cb = session.getCriteriaBuilder();

            CriteriaUpdate<ErsUser> cu = cb.createCriteriaUpdate(ErsUser.class);
            Root<ErsUser> root = cu.from(ErsUser.class);

            cu.set( "lastName", lastName).where(cb.equal(root.get("ersUserId"), id));

            session.createQuery(cu).executeUpdate();
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        }
    }

    public void changeUsernameById (int id, String username) {

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try{
            tx = session.beginTransaction();
            cb = session.getCriteriaBuilder();

            CriteriaUpdate<ErsUser> cu = cb.createCriteriaUpdate(ErsUser.class);
            Root<ErsUser> root = cu.from(ErsUser.class);

            cu.set( "username", username).where(cb.equal(root.get("ersUserId"), id));

            session.createQuery(cu).executeUpdate();
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        }
    }

    public void changeEmailById (int id, String email) {

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try{
            tx = session.beginTransaction();
            cb = session.getCriteriaBuilder();

            CriteriaUpdate<ErsUser> cu = cb.createCriteriaUpdate(ErsUser.class);
            Root<ErsUser> root = cu.from(ErsUser.class);

            cu.set( "email", email).where(cb.equal(root.get("ersUserId"), id));

            session.createQuery(cu).executeUpdate();
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        }
    }

    public void changeRoleById (int id, String role) {

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try{
            tx = session.beginTransaction();
            cb = session.getCriteriaBuilder();

            CriteriaUpdate<ErsUser> cu = cb.createCriteriaUpdate(ErsUser.class);
            Root<ErsUser> root = cu.from(ErsUser.class);

            cu.set( "ersUserRole", role).where(cb.equal(root.get("ersUserId"), id));

            session.createQuery(cu).executeUpdate();
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        }

    }

    public void changeStatusById (int id, boolean status) {

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try{
            tx = session.beginTransaction();
            cb = session.getCriteriaBuilder();

            CriteriaUpdate<ErsUser> cu = cb.createCriteriaUpdate(ErsUser.class);
            Root<ErsUser> root = cu.from(ErsUser.class);

            cu.set( "status", status).where(cb.equal(root.get("ersUserId"), id));

            session.createQuery(cu).executeUpdate();
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        }

    }

    public void save(ErsUser newUser) {

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try {

            Transaction tx = session.beginTransaction();
            session.save(newUser);
            tx.commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

    }

}

/*

Session session = sessionFactory.getCurrentSession();

try{

//tx.commit(); <-- dont have to do it but its good practice
}

 */
