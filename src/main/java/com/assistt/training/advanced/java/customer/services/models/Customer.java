package com.assistt.training.advanced.java.customer.services.models;

import com.assistt.training.advanced.java.customer.validation.NotContains;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
@Data
//@SecondaryTable(name = "deneme")
@Table(name = "musteri")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Long          customerId;
    private String        name;
    @Column(nullable = false)
    private String        surname;
    //@Column(table = "deneme")
    @NotEmpty
    private String        username;
    @NotEmpty
    private String        password;
    @Enumerated(EnumType.STRING)
    private EStatus       customerStatus = EStatus.ACTIVE;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    @Version
    private Long ver;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Phone> phones;

    @PrePersist
    public void beforeInsert() {
        creationDate = LocalDateTime.now();
        updateDate   = creationDate;
    }

    @PreUpdate
    public void beforeUpdate() {
        updateDate = creationDate;
    }

}
