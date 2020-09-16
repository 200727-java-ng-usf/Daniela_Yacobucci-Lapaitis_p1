package com.revature.ers.models;


import java.time.LocalTime;

public class ErsReimbursement {

    private int reimbId;
    private double amount;
    // TODO finish implementing
    // TODO change to have timezone?
    private LocalTime submitted;
    private LocalTime resolved;
    String description;
    //TODO change receipt to blob or image??
    private String receipt;

    //int author id
    //TODO if author gets deleted all their reinbursements get deleted
    private ErsUser author;
    //TODO if resolver gets deleted what happens to this reference?

    private ErsUser resolver;
    //TODO maybe change fetch type to lazy to increase performance
    // but find a workaround lazyinitializationexception

    private ErsReimbursementStatus ersReimbursementStatus;

    private ErsReimbursementType ersReimbursementType;

}
