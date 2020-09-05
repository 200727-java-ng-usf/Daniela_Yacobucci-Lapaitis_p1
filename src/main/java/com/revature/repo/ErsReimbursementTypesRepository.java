package com.revature.repo;

import com.revature.models.ErsReimbursementType;
import com.revature.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ErsReimbursementTypesRepository {

    public static void printErsReimbursementTypes(){

        Session session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            List<ErsReimbursementType> ersReimbursementTypes = session.createQuery("FROM ErsReimbursementType ", ErsReimbursementType.class).list();

            for (ErsReimbursementType ersrt : ersReimbursementTypes) {
                System.out.println(ersrt.toString());
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
