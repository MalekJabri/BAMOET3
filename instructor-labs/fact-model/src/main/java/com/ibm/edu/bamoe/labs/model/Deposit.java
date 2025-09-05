package com.ibm.edu.bamoe.labs.model;

public class Deposit {

    private String id;
    private BankingCustomer customer;
    private int amount;
    private int deposit;
    private boolean approved = false;
    private int maxAmount;

    public Deposit() {
    }

    public Deposit(String id, int amount, int deposit, int maxAmount, BankingCustomer customer) {
        
        this.id = id;
        this.amount = amount;
        this.deposit = deposit;
        this.maxAmount = maxAmount;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(BankingCustomer customer) {
        this.customer = customer;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public String toString() {
        return "Deposit [id=" + id + ", amount=" + amount + ", deposit=" + deposit + ", approved=" + approved + ", maxAmount=" + maxAmount + ", customer=" + customer + "]";
    }
}
