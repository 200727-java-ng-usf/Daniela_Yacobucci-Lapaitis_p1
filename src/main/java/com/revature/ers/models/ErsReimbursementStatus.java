package com.revature.ers.models;

import javax.persistence.*;

@Entity
@Table(name = "ers_reimbursement_statuses", schema = "project_1")
public class ErsReimbursementStatus {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "reimb_status_id")
    private int reimbStatusId;

    @Column(name = "reimb_status")
    private String reimbStatusName;

    public ErsReimbursementStatus(){

    }

    public ErsReimbursementStatus(int reimbStatusId, String reimbStatus) {
        this.reimbStatusId = reimbStatusId;
        this.reimbStatusName = reimbStatus;
    }

    public int getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatusId(int reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

    public String getReimbStatus() {
        return reimbStatusName;
    }

    public void setReimbStatus(String reimbStatus) {
        this.reimbStatusName = reimbStatus;
    }

    @Override
    public String toString() {
        return "ErsReimbursementStatus{" +
                "reimbStatusId=" + reimbStatusId +
                ", reimbStatusName='" + reimbStatusName + '\'' +
                '}';
    }
}
