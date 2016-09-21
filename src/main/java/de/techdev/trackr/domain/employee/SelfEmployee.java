package de.techdev.trackr.domain.employee;

import de.techdev.trackr.domain.company.Address;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.math.BigDecimal;

@Getter
@Setter
public class SelfEmployee {

    private Long id;

    private Integer version;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private String phoneNumber;

    private String title;

    private BigDecimal salary;

    @Valid
    private Address address;

    public static SelfEmployee valueOf(Employee employee) {
        SelfEmployee selfEmployee = new SelfEmployee();
        selfEmployee.setId(employee.getId());
        selfEmployee.setFirstName(employee.getFirstName());
        selfEmployee.setLastName(employee.getLastName());
        selfEmployee.setPhoneNumber(employee.getPhoneNumber());
        selfEmployee.setAddress(employee.getAddress());
        selfEmployee.setVersion(employee.getVersion());
        selfEmployee.setSalary(employee.getSalary());
        selfEmployee.setTitle(employee.getTitle());
        return selfEmployee;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
