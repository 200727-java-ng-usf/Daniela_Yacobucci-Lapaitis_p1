package com.revature.ers.repo;

import com.revature.ers.models.ErsReimbursement;
import com.revature.ers.models.ErsUser;
import com.revature.ers.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
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
}
