package com.revature.ers.dtos;

import com.revature.ers.models.ErsReimbursement;
import com.revature.ers.models.ErsReimbursementStatus;
import com.revature.ers.models.ErsReimbursementType;
import com.revature.ers.models.ErsUser;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

public class ErsReimbursementView {

    private int reimbId;

    private double amount;

    private LocalTime submitted;

    private LocalTime resolved;

    private String description;

    private String receipt;

    private String authorFirstName;

    private String authorLastName;

    private String resolverFirstName;

    private String resolverLastName;

    private String ersReimbursementStatusName;

    private String ersReimbursementTypeName;

    public ErsReimbursementView(){

    }

    public ErsReimbursementView (ErsReimbursement ersReimbursement){

        this.amount = ersReimbursement.getAmount();

        if(ersReimbursement.getAuthor()!=null){

            this.authorFirstName = ersReimbursement.getAuthor().getFirstName();
            this.authorLastName = ersReimbursement.getAuthor().getLastName();

        }

        if(ersReimbursement.getResolver()!= null){
            this.resolverFirstName = ersReimbursement.getResolver().getFirstName();
            this.resolverFirstName = ersReimbursement.getResolver().getLastName();
        }

        this.description = ersReimbursement.getDescription();
        this.ersReimbursementStatusName = ersReimbursement.getDescription();
        this.ersReimbursementTypeName = ersReimbursement.getErsReimbursementType().getReimbTypeName();

        if(ersReimbursement.getReceipt()!=null){
            this.receipt = ersReimbursement.getReceipt();
        }

        this.reimbId = ersReimbursement.getReimbId();

        if(ersReimbursement.getResolved()!=null){
            this.resolved = ersReimbursement.getResolved();
        }

        this.submitted = ersReimbursement.getSubmitted();
    }

    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalTime getSubmitted() {
        return submitted;
    }

    public void setSubmitted(LocalTime submitted) {
        this.submitted = submitted;
    }

    public LocalTime getResolved() {
        return resolved;
    }

    public void setResolved(LocalTime resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getResolverFirstName() {
        return resolverFirstName;
    }

    public void setResolverFirstName(String resolverFirstName) {
        this.resolverFirstName = resolverFirstName;
    }

    public String getResolverLastName() {
        return resolverLastName;
    }

    public void setResolverLastName(String resolverLastName) {
        this.resolverLastName = resolverLastName;
    }

    public String getErsReimbursementStatusName() {
        return ersReimbursementStatusName;
    }

    public void setErsReimbursementStatusName(String ersReimbursementStatusName) {
        this.ersReimbursementStatusName = ersReimbursementStatusName;
    }

    public String getErsReimbursementTypeName() {
        return ersReimbursementTypeName;
    }

    public void setErsReimbursementTypeName(String ersReimbursementTypeName) {
        this.ersReimbursementTypeName = ersReimbursementTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErsReimbursementView that = (ErsReimbursementView) o;
        return reimbId == that.reimbId &&
                Double.compare(that.amount, amount) == 0 &&
                Objects.equals(submitted, that.submitted) &&
                Objects.equals(resolved, that.resolved) &&
                Objects.equals(description, that.description) &&
                Objects.equals(receipt, that.receipt) &&
                Objects.equals(authorFirstName, that.authorFirstName) &&
                Objects.equals(authorLastName, that.authorLastName) &&
                Objects.equals(resolverFirstName, that.resolverFirstName) &&
                Objects.equals(resolverLastName, that.resolverLastName) &&
                Objects.equals(ersReimbursementStatusName, that.ersReimbursementStatusName) &&
                Objects.equals(ersReimbursementTypeName, that.ersReimbursementTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbId, amount, submitted, resolved, description, receipt, authorFirstName, authorLastName, resolverFirstName, resolverLastName, ersReimbursementStatusName, ersReimbursementTypeName);
    }

    @Override
    public String toString() {
        return "ErsReimbursementView{" +
                "reimbId=" + reimbId +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", resolverFirstName='" + resolverFirstName + '\'' +
                ", resolverLastName='" + resolverLastName + '\'' +
                ", ersReimbursementStatusName='" + ersReimbursementStatusName + '\'' +
                ", ersReimbursementTypeName='" + ersReimbursementTypeName + '\'' +
                '}';
    }

}
