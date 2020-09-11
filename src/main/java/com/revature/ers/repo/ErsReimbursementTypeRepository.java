package com.revature.ers.repo;

import com.revature.ers.models.ErsReimbursementType;
import com.revature.ers.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ErsReimbursementTypeRepository {

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
