package com.revature.ers.repo;

import com.revature.ers.models.ErsReimbursementType;
import com.revature.ers.models.ErsUser;
import com.revature.ers.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class ErsReimbursementTypeRepository {


    static CriteriaBuilder cb;
    static Transaction tx = null;
    static Session session;


    public static void printErsReimbursementTypes(){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
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

    public Optional<ErsReimbursementType> getErsReimbursementTypeByName(String ersReimbursementTypeName){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        Optional<ErsReimbursementType> _ersReimbursementType = Optional.empty();

        System.out.println("name in getErsReimbursementTypeByName "+ersReimbursementTypeName);

        try{

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();

            CriteriaQuery<ErsReimbursementType> cq = cb.createQuery(ErsReimbursementType.class);
            Root<ErsReimbursementType> root = cq.from(ErsReimbursementType.class);
            cq.select(root);

            cq.where(cb.equal(root.get("reimbTypeName"), ersReimbursementTypeName));

            Query query = session.createQuery(cq);

            _ersReimbursementType = query.getResultList().stream().findFirst();

            tx.commit();

            System.out.println(_ersReimbursementType.get() + " reimb type");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return (_ersReimbursementType);
    }


}
