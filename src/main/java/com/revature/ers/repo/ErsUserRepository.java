package com.revature.ers.repo;

import com.revature.ers.models.ErsUser;
import com.revature.ers.models.ErsUserRole;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class ErsUserRepository {

//    static CriteriaBuilder cb;
//    static Transaction tx = null;
//    static Session session;

    //sessionFactory

    public static void printErsUsers(){
//
//        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
//
//        try{
//            //HQL
//            tx = session.beginTransaction();
//            List<ErsUser> ersUsers = session.createQuery("FROM ErsUser ", ErsUser.class).list();
//
//            for (ErsUser ersu : ersUsers) {
//                System.out.println(ersu.toString());
//            }
//
//            tx.commit();
//        } catch (Exception e) {
//            if (tx!= null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
    }

    public static void printErsUsersCriteria(){
//
//        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
//
//        try{
//
//            tx = session.beginTransaction();
//
//            cb = session.getCriteriaBuilder();
//            CriteriaQuery<ErsUser> cq = cb.createQuery(ErsUser.class);
//            Root<ErsUser> root = cq.from(ErsUser.class);
//            cq.select(root);
//
//            Query query = session.createQuery(cq);
//
//            List<ErsUser> ersUsers = query.getResultList();
//
//            for (ErsUser ersu : ersUsers) {
//                System.out.println(ersu.toString());
//            }
//
//            tx.commit();
//        } catch (Exception e) {
//            if (tx!= null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
    }

    public static void deleteUserCriteria(){
//
//        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
//
//        try {
//
//            tx = session.beginTransaction();
//
//            cb = session.getCriteriaBuilder();
//            CriteriaDelete<ErsUser> cd = cb.createCriteriaDelete(ErsUser.class);
//            Root<ErsUser> root = cd.from(ErsUser.class);
//
//            Query query = session.createQuery(cd);
//
//            query.executeUpdate();
//
//
//        } catch (Exception e){
//
//        }

    }

    public static void deleteUserByUsername(String username){
//
//        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
//
//        try {
//
//            tx = session.beginTransaction();
//
//            cb = session.getCriteriaBuilder();
//            CriteriaDelete<ErsUser> cd = cb.createCriteriaDelete(ErsUser.class);
//            Root<ErsUser> root = cd.from(ErsUser.class);
//            cd.where(cb.equal(root.get("username"), username));
//
//            //TODO this returns an int so we can make this return int to debug
//            session.createQuery(cd).executeUpdate();
//
//        } catch (Exception e){
//
//            System.out.println(e.getStackTrace());
//        }

    }

    public Optional<ErsUser> findUserByCredentials(String username, String password){
//
//        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
//
        Optional<ErsUser> _user = Optional.empty();
//
//        try{
//
//            tx = session.beginTransaction();
//
//            cb = session.getCriteriaBuilder();
//
//            CriteriaQuery<ErsUser> cq = cb.createQuery(ErsUser.class);
//            Root<ErsUser> root = cq.from(ErsUser.class);
//            cq.select(root);
//
//            cq.where(cb.equal(root.get("username"), username), cb.equal(root.get("password"), password));
//
//            Query query = session.createQuery(cq);
//
//            _user = (Optional<ErsUser>) query.getResultList().stream().findFirst();
//
//            tx.commit();
//
//        } catch (Exception e) {
//            if (tx!= null) tx.rollback();
//            e.printStackTrace();
//        }
//
//        //TODO remove breadcrumb
//        System.out.println("User and credentials: ");
//        if(_user.isPresent()){
//            System.out.println(_user);
//        }
//        else {
//            System.out.println("SOT PRESENT");
//        }
//
        return (_user);
    }

    public Optional<ErsUser> findUserByUsername(String username){
//
//        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
//
        Optional<ErsUser> _user = Optional.empty();
//
//        try{
//
//            tx = session.beginTransaction();
//
//            cb = session.getCriteriaBuilder();
//
//            CriteriaQuery<ErsUser> cq = cb.createQuery(ErsUser.class);
//            Root<ErsUser> root = cq.from(ErsUser.class);
//            cq.select(root);
//
//            cq.where(cb.equal(root.get("username"), username));
//
//            Query query = session.createQuery(cq);
//
//            _user = (Optional<ErsUser>) query.getResultList().stream().findFirst();
//
//            tx.commit();
//
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//        }
//
        return (_user);
    }

    public Optional<ErsUser> findUserByEmail(String email){

//        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
//
        Optional<ErsUser> _user = Optional.empty();
//
//        try{
//
//            tx = session.beginTransaction();
//
//            cb = session.getCriteriaBuilder();
//
//            CriteriaQuery<ErsUser> cq = cb.createQuery(ErsUser.class);
//            Root<ErsUser> root = cq.from(ErsUser.class);
//            cq.select(root);
//
//            cq.where(cb.equal(root.get("email"), email));
//
//            Query query = session.createQuery(cq);
//
//            _user = (Optional<ErsUser>) query.getResultList().stream().findFirst();
//
//            tx.commit();
//
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//        }
//
//
        return (_user);
    }

    public void changeRoleToInactive (ErsUser ersUser) {
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
//            cu.set("ersUserRole", new ErsUserRole(4,"Inactive"));
//
//            cu.where(cb.equal(root.get("id"), ersUser.getErsUserId()));
//
//            tx.commit();
//
//            return true;
//
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//            return false;
//        }
    }


    public void changeRoleToInactiveById (int id) {
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
//            cu.where(cb.equal(root.get("id"), id));
//
//            Query query = session.createQuery(cu);
//            query.executeUpdate();
//
//
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//
//        }
    }

    private Set<ErsUser> mapResultSet(ResultSet rs) throws SQLException {

        Set<ErsUser> users = new HashSet<>();

        while (rs.next()) {
            ErsUser temp = new ErsUser();
            temp.setErsUserId(rs.getInt("user_id"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setEmail(rs.getString("email"));
            temp.setErsUserRole(ErsUserRole.getByName(rs.getString("name")));
            users.add(temp);
        }

        return users;

    }
}

/*

Session session = sessionFactory.getCurrentSession();

try{

//tx.commit(); <-- dont have to do it but its good practice
}

 */
