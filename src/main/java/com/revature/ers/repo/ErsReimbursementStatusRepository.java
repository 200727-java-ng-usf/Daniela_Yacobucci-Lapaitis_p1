package com.revature.ers.repo;

import com.revature.ers.models.ErsReimbursementStatus;
import com.revature.ers.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ErsReimbursementStatusRepository {

    public static void printErsReimbursementStatuses(){

        Session session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            List<ErsReimbursementStatus> ersReimbursementStatuses = session.createQuery("FROM ErsReimbursementStatus ", ErsReimbursementStatus.class).list();

            for (ErsReimbursementStatus ersrs : ersReimbursementStatuses) {
                System.out.println(ersrs.toString());
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
