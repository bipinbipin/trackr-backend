package de.techdev.trackr.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Represents any employee of techdev.
 * @author Moritz Schulze
 */
@Data
@Entity
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

    private String phoneNumber;

    private String title;

    private BigDecimal salary;

    private BigDecimal hourlyCostRate;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Credential credential;
}
