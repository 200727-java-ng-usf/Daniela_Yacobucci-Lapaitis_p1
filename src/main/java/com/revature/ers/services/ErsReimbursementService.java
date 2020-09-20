package com.revature.ers.services;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.models.ErsReimbursement;
import com.revature.ers.models.ErsUser;
import com.revature.ers.repo.ErsReimbursementRepository;

import java.util.List;

public class ErsReimbursementService {

    ErsReimbursementRepository ersReimbursementRepo = new ErsReimbursementRepository();

    public List<ErsReimbursement> getAllReimbursements () {

        return ersReimbursementRepo.getAllReimbursements()
                .orElseThrow(AuthenticationException::new);

    }

    public void createReimbursement(ErsReimbursement ersReimbursement){

        ersReimbursementRepo.save(ersReimbursement);

    }

    public void setReimbursementStatusToDeniedById(){

    }

    public void setReimbursementStatusToApprovedById(){

    }
}
