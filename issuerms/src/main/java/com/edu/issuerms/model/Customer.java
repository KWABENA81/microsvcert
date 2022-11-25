package com.edu.issuerms.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER_TB")
public class Customer implements Comparable<Customer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname", nullable = false, length = 45)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 45)
    private String lastname;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "email", nullable = false, length = 35)
    private String email;

    @OneToMany(targetEntity = Issuer.class, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Issuer> issuedList;

    @Override
    public int compareTo(Customer c) {
        int value = this.email.compareTo(c.email);
        if (value == 0) value = this.phone.compareTo(c.phone);
        return value;
    }
}
