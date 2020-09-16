package com.revature.ers.models;


public class ErsReimbursementStatus {

    private int reimbStatusId;

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
