package com.example.vaadin1.suppliers.backend.entity;

import javax.persistence.Entity;

@Entity
public class Company extends AbstractEntity {

    private String name;
    private String address;
    private String phone;
    private String email;
    private boolean frozen;
    private boolean veggies;
    private boolean seafood;

    public Company() {
    }

    public Company(String name, String address, String phone, String email, boolean frozen, boolean veggies, boolean seafood) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.frozen = frozen;
        this.veggies = veggies;
        this.seafood = seafood;
    }

    public boolean isVeggies() {
        return veggies;
    }

    public void setVeggies(boolean veggies) {
        this.veggies = veggies;
    }

    public boolean isSeafood() {
        return seafood;
    }

    public void setSeafood(boolean seafood) {
        this.seafood = seafood;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
