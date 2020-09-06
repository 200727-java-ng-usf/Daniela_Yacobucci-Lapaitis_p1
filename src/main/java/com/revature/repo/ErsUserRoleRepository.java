package com.revature.repo;

import com.revature.models.ErsReimbursementType;
import com.revature.models.ErsUserRole;
import com.revature.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ErsUserRoleRepository {

    public static void printErsUserRoles(){

        Session session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            List<ErsUserRole> ersUserRoles = session.createQuery("FROM ErsUserRole ", ErsUserRole.class).list();

            for (ErsUserRole ersur : ersUserRoles) {
                System.out.println(ersur.toString());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx!= null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
