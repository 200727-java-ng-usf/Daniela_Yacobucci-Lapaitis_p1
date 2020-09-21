package com.revature.ers.services;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.NoValuesFoundException;
import com.revature.ers.models.ErsReimbursement;
import com.revature.ers.models.ErsReimbursementStatus;
import com.revature.ers.models.ErsReimbursementType;
import com.revature.ers.models.ErsUser;
import com.revature.ers.repo.ErsReimbursementRepository;
import com.revature.ers.repo.ErsUserRepository;

import java.util.List;

public class ErsReimbursementService {

    ErsReimbursementRepository ersReimbursementRepo = new ErsReimbursementRepository();
    ErsUserService ersUserService = new ErsUserService();
    ErsReimbursementStatusService ersReimbursementStatusService = new ErsReimbursementStatusService();
    ErsReimbursementTypeService ersReimbursementTypeService = new ErsReimbursementTypeService();

    public List<ErsReimbursement> getAllReimbursements () {

        return ersReimbursementRepo.getAllReimbursements()
                .orElseThrow(NoValuesFoundException::new);

    }

    public void createReimbursement(ErsReimbursement ersReimbursement){

        ersReimbursementRepo.save(ersReimbursement);

    }

    public ErsReimbursement getReimbursementById (int id){

        return ersReimbursementRepo.findReimbursementById(id)
                .orElseThrow(NoValuesFoundException::new);
    }


    public void changeReimbursementStatusByReimbId(int id, String status){

        System.out.println(status);

        if(!(status.equals("Pending") || status.equals("Denied") || status.equals("Approved"))){
            throw new InvalidRequestException("Invalid request. Status value is invalid.");
        }

        //TODO change to status
        ErsReimbursementStatus ersReimbursementStatus = ersReimbursementStatusService.getErsReimbursementStatusByName(status);

        ersReimbursementRepo.changeReimbursementStatusByReimbId(id, ersReimbursementStatus);

        //ersReimbursementRepo.changeReimbursementStatusByReimbId(id, ersReimbursementType);

    }

    public List<ErsReimbursement> getReimbursementsByAuthorUsername(String username){

        return ersReimbursementRepo.getReimbursementsByAuthor(ersUserService.findUserByUsername(username))
                .orElseThrow(NoValuesFoundException::new);

    }

    public List<ErsReimbursement> getReimbursementsByAuthorId (int id){

        return ersReimbursementRepo.getReimbursementsByAuthor(ersUserService.findUserById(id))
                .orElseThrow(NoValuesFoundException::new);

    }
}
