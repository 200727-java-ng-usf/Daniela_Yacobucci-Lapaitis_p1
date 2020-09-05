package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name = "ers_reimbursement_types", schema = "project_1")
public class ErsReimbursementType {

    @Id @GeneratedValue
    @Column(name = "reimb_type_id")
    private int reimbTypeId;

    @Column(name = "reimb_type")
    private String reimbTypeName;

    public ErsReimbursementType(){

    }

    public ErsReimbursementType(int reimbTypeId, String reimbTypeName) {
        reimbTypeId = reimbTypeId;
        reimbTypeName = reimbTypeName;
    }

    public int getReimbTypeId() {
        return reimbTypeId;
    }

    public void setReimbTypeId(int reimbTypeId) {
        reimbTypeId = reimbTypeId;
    }

    public String getReimbTypeName() {
        return reimbTypeName;
    }

    public void setReimbTypeName(String reimbTypeName) {
        reimbTypeName = reimbTypeName;
    }

    @Override
    public String toString() {
        return "ErsReimbursementType{" +
                "reimbTypeId='" + reimbTypeId + '\'' +
                ", reimbTypeName='" + reimbTypeName + '\'' +
                '}';
    }
}
