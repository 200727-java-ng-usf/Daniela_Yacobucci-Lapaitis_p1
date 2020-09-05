package com.revature;

import com.revature.repo.ErsReimbursementStatusesRepository;
import com.revature.repo.ErsReimbursementTypesRepository;

public class AppDriver {

    public static void main(String[] args) {

        ErsReimbursementStatusesRepository.printErsReimbursementStatuses();
        ErsReimbursementTypesRepository.printErsReimbursementTypes();

    }
}