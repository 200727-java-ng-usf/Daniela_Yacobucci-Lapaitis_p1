package com.revature.ers.models;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "ers_reimbursements", schema = "project_1")
public class ErsReimbursement {


    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="reimb_id")
    private int reimbId;

    @Column(name = "amount")
    private double amount;
    // TODO finish implementing
    // TODO change to have timezone?

    @Column(name = "submitted")
    private LocalTime submitted;

    @Column(name = "resolved")
    private LocalTime resolved;

    @Column(name = "description")
    private String description;
    //TODO change receipt to blob or image??

    @Column(name = "receipt")
    private String receipt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="author_id")
    private ErsUser author;

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

    public ErsReimbursement() {

    }

    //without id
    public ErsReimbursement(double amount, LocalTime submitted, LocalTime resolved, String description, String receipt, ErsUser author, ErsUser resolver, ErsReimbursementStatus ersReimbursementStatus, ErsReimbursementType ersReimbursementType) {
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.author = author;
        this.resolver = resolver;
        this.ersReimbursementStatus = ersReimbursementStatus;
        this.ersReimbursementType = ersReimbursementType;
    }

    public ErsReimbursement(int reimbId, double amount, LocalTime submitted, LocalTime resolved, String description, String receipt, ErsUser author, ErsUser resolver, ErsReimbursementStatus ersReimbursementStatus, ErsReimbursementType ersReimbursementType) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.author = author;
        this.resolver = resolver;
        this.ersReimbursementStatus = ersReimbursementStatus;
        this.ersReimbursementType = ersReimbursementType;
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

    public ErsUser getAuthor() {
        return author;
    }

    public void setAuthor(ErsUser author) {
        this.author = author;
    }

    public ErsUser getResolver() {
        return resolver;
    }

    public void setResolver(ErsUser resolver) {
        this.resolver = resolver;
    }

    public ErsReimbursementStatus getErsReimbursementStatus() {
        return ersReimbursementStatus;
    }

    public void setErsReimbursementStatus(ErsReimbursementStatus ersReimbursementStatus) {
        this.ersReimbursementStatus = ersReimbursementStatus;
    }

    public ErsReimbursementType getErsReimbursementType() {
        return ersReimbursementType;
    }

    public void setErsReimbursementType(ErsReimbursementType ersReimbursementType) {
        this.ersReimbursementType = ersReimbursementType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErsReimbursement that = (ErsReimbursement) o;
        return reimbId == that.reimbId &&
                Double.compare(that.amount, amount) == 0 &&
                Objects.equals(submitted, that.submitted) &&
                Objects.equals(resolved, that.resolved) &&
                Objects.equals(description, that.description) &&
                Objects.equals(receipt, that.receipt) &&
                Objects.equals(author, that.author) &&
                Objects.equals(resolver, that.resolver) &&
                Objects.equals(ersReimbursementStatus, that.ersReimbursementStatus) &&
                Objects.equals(ersReimbursementType, that.ersReimbursementType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbId, amount, submitted, resolved, description, receipt, author, resolver, ersReimbursementStatus, ersReimbursementType);
    }

    @Override
    public String toString() {
        return "ErsReimbursement{" +
                "reimbId=" + reimbId +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", author=" + author +
                ", resolver=" + resolver +
                ", ersReimbursementStatus=" + ersReimbursementStatus +
                ", ersReimbursementType=" + ersReimbursementType +
                '}';
    }
}
