package com.edu.registerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register implements Comparable<Register> {

    @Id
    private Integer id;
    private String name;
    private Double payableFees;

    public Double getPayableFees() {
        return payableFees;
    }

    public void setPayableFees(Double payableFees) {
        this.payableFees = payableFees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Register register) {
        return this.name.compareTo(register.name);
    }
}
