package com.revature.ers.services;

import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.models.ErsReimbursementStatus;
import com.revature.ers.models.ErsReimbursementType;
import com.revature.ers.repo.ErsReimbursementStatusRepository;
import com.revature.ers.repo.ErsReimbursementTypeRepository;

public class ErsReimbursementStatusService {

    private ErsReimbursementStatusRepository ersReimbursementStatusRepository = new ErsReimbursementStatusRepository();

    public ErsReimbursementStatus getErsReimbursementStatusByName(String name){

        System.out.println("name of status in service: " + name);

        return ersReimbursementStatusRepository.getErsReimbursementStatusByName(name).orElseThrow(InvalidRequestException:: new);
    }
}
