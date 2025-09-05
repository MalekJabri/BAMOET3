package com.ibm.edu.bamoe.labs.model;

import java.time.LocalDate;
import java.time.Period;

public class BankingCustomer {

    private String id;
    private String accountNumber;
    private String lastName;
    private String firstName;
    private int age;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[banking customer id=" + getId() + ", accountNumber=" + getAccountNumber() + ", lastName=" + getLastName() + ", firstName=" + getFirstName() + ", age=" + getAge() + "]";
    }
}
