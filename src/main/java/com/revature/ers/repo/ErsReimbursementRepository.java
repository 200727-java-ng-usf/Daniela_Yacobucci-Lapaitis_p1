package com.revature.ers.repo;

import com.revature.ers.models.ErsReimbursement;
import com.revature.ers.models.ErsReimbursementStatus;
import com.revature.ers.models.ErsReimbursementType;
import com.revature.ers.models.ErsUser;
import com.revature.ers.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class ErsReimbursementRepository {

    static CriteriaBuilder cb;
    static Transaction tx = null;
    static Session session;

    public Optional<List<ErsReimbursement>> getAllReimbursements(){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();
        Optional<List<ErsReimbursement>> _allReimbursements = Optional.empty();

        try{
            //HQL
            tx = session.beginTransaction();
            List<ErsReimbursement> ersReimbursements = session.createQuery("FROM ErsReimbursement ", ErsReimbursement.class).list();
            _allReimbursements = Optional.of(ersReimbursements);

            for (ErsReimbursement er : _allReimbursements.get()) {
                System.out.println(er.toString());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx!= null) tx.rollback();
            e.printStackTrace();
        }

        return _allReimbursements;
    }

    public void save(ErsReimbursement ersReimbursement) {

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try {

            Transaction tx = session.beginTransaction();
            System.out.println("here?");
            session.save(ersReimbursement);
            System.out.println("here??");
            tx.commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    public Optional<ErsReimbursement> findReimbursementById(int id){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        Optional<ErsReimbursement> _reimbursement = Optional.empty();

        try{

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();

            CriteriaQuery<ErsReimbursement> cq = cb.createQuery(ErsReimbursement.class);
            Root<ErsReimbursement> root = cq.from(ErsReimbursement.class);
            cq.select(root);

            cq.where(cb.equal(root.get("reimbId"), id));

            Query query = session.createQuery(cq);

            _reimbursement = (Optional<ErsReimbursement>) query.getResultList().stream().findFirst();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return (_reimbursement);
    }


    public Optional<List<ErsReimbursement>> getReimbursementsByAuthor(ErsUser author){


        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        Optional<List<ErsReimbursement>> _reimbursements = Optional.empty();

        try{

            tx = session.beginTransaction();

            cb = session.getCriteriaBuilder();

            CriteriaQuery<ErsReimbursement> cq = cb.createQuery(ErsReimbursement.class);
            Root<ErsReimbursement> root = cq.from(ErsReimbursement.class);
            cq.select(root);

            cq.where(cb.equal(root.get("author"), author));

            Query query = session.createQuery(cq);


            _reimbursements = Optional.of(query.getResultList());


            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return (_reimbursements);

    }

    public void changeReimbursementStatusByReimbId (int reimbId, ErsReimbursementStatus ersReimbursementStatus){

        session = HibernateUtils.getSessionFactoryProgrammaticConfig().openSession();

        try{
            tx = session.beginTransaction();
            cb = session.getCriteriaBuilder();

            CriteriaUpdate<ErsReimbursement> cu = cb.createCriteriaUpdate(ErsReimbursement.class);
            Root<ErsReimbursement> root = cu.from(ErsReimbursement.class);

            cu.set( "ersReimbursementStatus", ersReimbursementStatus).where(cb.equal(root.get("reimbId"), reimbId));

            session.createQuery(cu).executeUpdate();
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        }


    }


}
