package com.revature.ers.services;

import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.models.ErsReimbursementType;
import com.revature.ers.repo.ErsReimbursementTypeRepository;
import com.revature.ers.repo.ErsReimbursementRepository;

public class ErsReimbursementTypeService {

    private ErsReimbursementTypeRepository ersReimbursementTypeRepository = new ErsReimbursementTypeRepository();

    public ErsReimbursementType getErsReimbursementTypeByName(String name){
        return ersReimbursementTypeRepository.getErsReimbursementTypeByName(name).orElseThrow(InvalidRequestException :: new);
    }
}
