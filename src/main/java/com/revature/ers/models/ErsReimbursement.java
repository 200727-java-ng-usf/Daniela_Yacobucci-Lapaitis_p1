package com.revature.ers.models;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    //TODO if resolver gets deleted what happens to this reference?
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="resolver_id")
    private ErsUser resolver;
    //TODO maybe change fetch type to lazy to increase performance
    // but find a workaround lazyinitializationexception

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="reimb_status_id")
    private ErsReimbursementStatus ersReimbursementStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="reimb_type_id")
    private ErsReimbursementType ersReimbursementType;

}
