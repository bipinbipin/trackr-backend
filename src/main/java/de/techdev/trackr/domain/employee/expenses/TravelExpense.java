package de.techdev.trackr.domain.employee.expenses;

import de.techdev.trackr.domain.employee.expenses.reports.Report;
import de.techdev.trackr.domain.validation.constraints.EndAfterBegin;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@EndAfterBegin(begin = "fromDate", end = "toDate")
public class TravelExpense {

    public enum Type {
        HOTEL, TAXI, FLIGHT, TRAIN, PARKING, OEPNV, MILEAGE_ALLOWANCE, OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    @NotNull
    @ManyToOne
    private Report report;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;

    @NotNull
    private BigDecimal cost;

    @NotNull
    private BigDecimal vat;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;

    private String comment;

    private boolean paid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
