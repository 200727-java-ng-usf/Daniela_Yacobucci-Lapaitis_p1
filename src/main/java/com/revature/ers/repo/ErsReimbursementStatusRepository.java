package com.revature.ers.repo;

import com.revature.ers.models.ErsReimbursementStatus;
import com.revature.ers.models.ErsReimbursementType;
import com.revature.ers.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class ErsReimbursementStatusRepository {

    static CriteriaBuilder cb;
    static Transaction tx = null;
    static Session session;

    public static void printErsReimbursementStatuses(){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
        tx = null;

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

    public Optional<ErsReimbursementStatus> getErsReimbursementStatusByName(String ersReimbursementStatusName){


        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
        tx = null;

        Optional<ErsReimbursementStatus> _ersReimbursementStatus= Optional.empty();

        try{

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();

            CriteriaQuery<ErsReimbursementStatus> cq = cb.createQuery(ErsReimbursementStatus.class);
            Root<ErsReimbursementStatus> root = cq.from(ErsReimbursementStatus.class);
            cq.select(root);

            cq.where(cb.equal(root.get("reimbStatusName"), ersReimbursementStatusName));

            Query query = session.createQuery(cq);

            _ersReimbursementStatus = (Optional<ErsReimbursementStatus>) query.getResultList().stream().findFirst();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return (_ersReimbursementStatus);
    }

}
