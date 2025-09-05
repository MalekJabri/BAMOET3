package com.ibm.edu.bamoe.labs.model;

import java.time.LocalDate;
import java.time.Period;

public class Customer {

    private String id;
    private String lastName;
    private String firstName;
    private String maritalStatus;
    private long annualEarnedIncome;
    private LocalDate dateOfBirth;
    private int age;
    private String countryOfResidence;
    private String accountNumber;
    private Recommendation recommendation = new Recommendation();

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public long getAnnualEarnedIncome() {
        return this.annualEarnedIncome;
    }

    public void setAnnualEarnedIncome(long annualEarnedIncome) {
        this.annualEarnedIncome = annualEarnedIncome;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfResidence() {
        return this.countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public Recommendation getRecommendation() {
        return this.recommendation;
    }

    public void setRecommendation(Recommendation recommendation) {
        this.recommendation = recommendation;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer calculateAge() {

        LocalDate currentDate = LocalDate.now();
        return (Integer) Period.between(dateOfBirth, currentDate).getYears();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "[customer id=" + getId() + ", accountNumber=" + getAccountNumber() + ", lastName=" + getLastName() + ", firstName=" + getFirstName() + ", dateOfBirth=" + getDateOfBirth() + ", age=" + getAge() + ", " + getRecommendation() + "]";
    }
}
