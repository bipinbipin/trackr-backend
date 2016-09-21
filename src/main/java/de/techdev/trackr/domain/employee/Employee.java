package de.techdev.trackr.domain.employee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.techdev.trackr.domain.common.FederalState;
import de.techdev.trackr.domain.company.Address;
import de.techdev.trackr.domain.employee.expenses.reports.Report;
import de.techdev.trackr.domain.employee.vacation.VacationRequest;
import de.techdev.trackr.domain.project.billtimes.BillableTime;
import de.techdev.trackr.domain.project.worktimes.WorkTime;
import de.techdev.trackr.domain.validation.constraints.EndAfterBegin;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents any employee of techdev.
 */
@Entity
@Getter
@Setter
@JsonIgnoreProperties({"credential", "workTimes", "billableTimes", "vacationRequests", "approvedRequests", "travelExpenseReports"})
@EndAfterBegin(begin = "joinDate", end = "leaveDate")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Column(unique = true)
    @Email
    @NotEmpty
    private String email;

    private String phoneNumber;

    private String title;

    private BigDecimal salary;

    private BigDecimal hourlyCostRate;

    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @Temporal(TemporalType.DATE)
    private Date leaveDate;

    @Enumerated(EnumType.STRING)
    @NotNull
    private FederalState federalState;

    private Float vacationEntitlement;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "employee")
    private List<WorkTime> workTimes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "employee")
    private List<BillableTime> billableTimes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "employee")
    private List<VacationRequest> vacationRequests;

    @OneToMany(mappedBy = "approver")
    private List<VacationRequest> approvedRequests;

    @OneToMany(mappedBy = "employee")
    private List<Report> travelExpenseReports;

    @OneToOne(orphanRemoval = true)
    private Address address;

    private boolean deleted;

    public String fullName() {
        return this.firstName + " " + this.lastName;
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getHourlyCostRate() {
        return hourlyCostRate;
    }

    public void setHourlyCostRate(BigDecimal hourlyCostRate) {
        this.hourlyCostRate = hourlyCostRate;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public FederalState getFederalState() {
        return federalState;
    }

    public void setFederalState(FederalState federalState) {
        this.federalState = federalState;
    }

    public Float getVacationEntitlement() {
        return vacationEntitlement;
    }

    public void setVacationEntitlement(Float vacationEntitlement) {
        this.vacationEntitlement = vacationEntitlement;
    }

    public List<WorkTime> getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(List<WorkTime> workTimes) {
        this.workTimes = workTimes;
    }

    public List<BillableTime> getBillableTimes() {
        return billableTimes;
    }

    public void setBillableTimes(List<BillableTime> billableTimes) {
        this.billableTimes = billableTimes;
    }

    public List<VacationRequest> getVacationRequests() {
        return vacationRequests;
    }

    public void setVacationRequests(List<VacationRequest> vacationRequests) {
        this.vacationRequests = vacationRequests;
    }

    public List<VacationRequest> getApprovedRequests() {
        return approvedRequests;
    }

    public void setApprovedRequests(List<VacationRequest> approvedRequests) {
        this.approvedRequests = approvedRequests;
    }

    public List<Report> getTravelExpenseReports() {
        return travelExpenseReports;
    }

    public void setTravelExpenseReports(List<Report> travelExpenseReports) {
        this.travelExpenseReports = travelExpenseReports;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
