package com.revature.ers.models;


public class ErsReimbursementType {

    private int reimbTypeId;

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
